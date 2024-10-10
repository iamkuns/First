#include <Wire.h>
#include <hd44780.h>                       // main hd44780 header
#include <hd44780ioClass/hd44780_I2Cexp.h> // i2c expander i/o class header
#include <DHT.h>
#include <BLEDevice.h>
#include <BLEUtils.h>
#include <BLEServer.h>

// Define DHT11 pin and type
#define DHTPIN 13
#define DHTTYPE DHT11

// Initialize the LCD and DHT sensor
hd44780_I2Cexp lcd; // auto locate & auto config expander chip
DHT dht(DHTPIN, DHTTYPE);

// Define the pins for Serial2 (for Bluetooth communication with HC-05)
#define RXD2 16 // ESP32 RX2 connected to HC-05 TX
#define TXD2 17 // ESP32 TX2 connected to HC-05 RX

// Battery voltage pin
#define BATTERY_PIN 34  // ADC pin to read battery level

// Voltage divider resistor values (for battery level measurement)
const float R1 = 100000.0; // 100k ohms
const float R2 = 100000.0; // 100k ohms

// Battery voltage thresholds
const float MAX_BATTERY_VOLTAGE = 4.2;  // Fully charged battery voltage
const float MIN_BATTERY_VOLTAGE = 3.0;  // Discharged battery voltage

// BLE UUIDs for the service and characteristic
#define SERVICE_UUID "4fafc201-1fb5-459e-8fcc-c5c9c331914b"
#define CHARACTERISTIC_UUID "beb5483e-36e1-4688-b7f5-ea07361b26a8"

// BLE Server and Characteristic pointers
BLEServer* pServer = NULL;
BLECharacteristic* pCharacteristic = NULL;
bool deviceConnected = false;

// Callback class for BLE server events
class MyServerCallbacks : public BLEServerCallbacks {
  void onConnect(BLEServer* pServer) {
    deviceConnected = true;
    Serial.println("BLE Device connected");
  }

  void onDisconnect(BLEServer* pServer) {
    deviceConnected = false;
    Serial.println("BLE Device disconnected");
  }
};

void setup() {
  // Initialize Serial Monitor and Serial2 for HC-05 communication
  Serial.begin(9600);
  Serial2.begin(9600, SERIAL_8N1, RXD2, TXD2);

  // Initialize the LCD
  lcd.begin(16, 2);
  lcd.backlight();

  // Initialize the DHT sensor
  dht.begin();

  // Display initial messages
  lcd.setCursor(0, 0);
  lcd.print("Initializing...");

  // Setup BLE server and characteristic
  BLEDevice::init("ESP32_BLE_Device");
  pServer = BLEDevice::createServer();
  pServer->setCallbacks(new MyServerCallbacks());

  BLEService* pService = pServer->createService(SERVICE_UUID);
  pCharacteristic = pService->createCharacteristic(
                      CHARACTERISTIC_UUID,
                      BLECharacteristic::PROPERTY_READ |
                      BLECharacteristic::PROPERTY_NOTIFY
                    );
  pService->start();
  pServer->getAdvertising()->start();
  Serial.println("BLE service started, waiting for client...");
}

void loop() {
  // Read temperature from DHT sensor
  float temp = dht.readTemperature();
  
  // Check for failed readings from the DHT sensor
  if (isnan(temp)) {
    Serial.println("Failed to read temperature from DHT sensor!");
    temp = 0;  // Set to zero if read fails (could also set to a default or error value)
  }

  // Read the battery voltage
  int batteryValue = analogRead(BATTERY_PIN);  // Read the ADC pin
  float voltage = (batteryValue / 4095.0) * 3.3;  // Convert ADC value to voltage
  float batteryVoltage = voltage * ((R1 + R2) / R2);  // Convert back to battery voltage

  // Calculate battery percentage
  float batteryPercentage = ((batteryVoltage - MIN_BATTERY_VOLTAGE) / (MAX_BATTERY_VOLTAGE - MIN_BATTERY_VOLTAGE)) * 100;

  // Ensure battery percentage is between 0% and 100%
  if (batteryPercentage > 100) batteryPercentage = 100;
  if (batteryPercentage < 0) batteryPercentage = 0;

  // Display temperature and battery percentage on the LCD
  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print(temp);
  lcd.print(" C");

  lcd.setCursor(0, 1);
  lcd.print("Batt: ");
  lcd.print(batteryPercentage, 1);  // Display percentage with 1 decimal point
  lcd.print("%");

  // Send temperature and battery data to Serial Monitor
  Serial.print("Temperature: ");
  Serial.print(temp);
  Serial.println(" °C");
  Serial.print("Battery Percentage: ");
  Serial.print(batteryPercentage);
  Serial.println("%");

  // Send temperature and battery data to HC-05 Bluetooth
  Serial2.print("Temperature: ");
  Serial2.print(temp);
  Serial2.println(" °C");
  Serial2.print("Battery Percentage: ");
  Serial2.print(batteryPercentage);
  Serial2.println("%");

  // Send data to BLE clients if connected
  // Send data to BLE clients if connected
if (deviceConnected) {
  // Create a JSON formatted string
  String data = "{\"temperature\":" + String(temp) + ", \"batteryLevel\":" + String(batteryPercentage, 1) + "}";
  pCharacteristic->setValue(data.c_str());
  pCharacteristic->notify(); // Notify connected BLE devices
}


  // Wait 2 seconds before next update
  delay(2000);
}
