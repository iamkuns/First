#include <Wire.h>
#include <hd44780.h>                       // main hd44780 header
#include <hd44780ioClass/hd44780_I2Cexp.h> // i2c expander i/o class header
#include <DHT.h>

// Define DHT11 pin and type
#define DHTPIN 13
#define DHTTYPE DHT11

// Initialize the LCD and DHT sensor
hd44780_I2Cexp lcd; // auto locate & auto config expander chip
DHT dht(DHTPIN, DHTTYPE);

// Define the pins for Serial2 (for Bluetooth communication)
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

void setup() {
  // Initialize the LCD
  lcd.begin(16, 2);
  lcd.backlight();

  // Initialize the DHT sensor
  dht.begin();

  // Initialize Serial communication for output to Serial Monitor
  Serial.begin(9600);

  // Initialize Serial2 for Bluetooth communication
  Serial2.begin(9600, SERIAL_8N1, RXD2, TXD2); // Set baud rate to 9600 for HC-05

  // Print a message to the LCD
  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
}

void loop() {
  // Read temperature as Celsius
  float temp = dht.readTemperature();

  // Check if any reads failed and exit early (to try again)
  if (isnan(temp)) {
    lcd.setCursor(0, 1);
    lcd.print("Error");
    Serial.println("Error reading temperature");
    Serial2.println("Error reading temperature"); // Send error to Bluetooth
    return;
  }

  // Display the temperature on the LCD
  lcd.setCursor(6, 0);
  lcd.print(temp);
  lcd.print(" C");

  // Output the temperature to the Serial Monitor
  Serial.print("Temperature: ");
  Serial.print(temp);
  Serial.println(" °C");

  // Send temperature data via Bluetooth (Serial2)
  Serial2.print("Temperature: ");
  Serial2.print(temp);
  Serial2.println(" °C");

  // Read the battery voltage
  int batteryValue = analogRead(BATTERY_PIN);  // Read the ADC pin
  float voltage = (batteryValue / 4095.0) * 3.3;  // Convert ADC value to voltage
  float batteryVoltage = voltage * ((R1 + R2) / R2);  // Convert back to battery voltage

  // Calculate battery percentage
  float batteryPercentage = ((batteryVoltage - MIN_BATTERY_VOLTAGE) / (MAX_BATTERY_VOLTAGE - MIN_BATTERY_VOLTAGE)) * 100;

  // Ensure battery percentage is between 0% and 100%
  if (batteryPercentage > 100) batteryPercentage = 100;
  if (batteryPercentage < 0) batteryPercentage = 0;

  // Display battery percentage on the LCD
  lcd.setCursor(0, 1);
  lcd.print("Batt: ");
  lcd.print(batteryPercentage, 1);  // Display percentage with 1 decimal point
  lcd.print("%");

  // Output battery percentage to the Serial Monitor
  Serial.print("Battery Percentage: ");
  Serial.print(batteryPercentage);
  Serial.println("%");

  // Send battery percentage data via Bluetooth (Serial2)
  Serial2.print("Battery Percentage: ");
  Serial2.print(batteryPercentage);
  Serial2.println("%");

  // Wait a few seconds between measurements
  delay(2000);
}
