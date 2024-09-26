package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatteryInfoServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // URL to ESP32 that returns the battery level and temperature
	        String esp32Url = "http://<ESP32-IP-ADDRESS>/battery"; // Replace <ESP32-IP-ADDRESS> with the actual IP address

	        try {
	            // Make HTTP request to ESP32
	            URL url = new URL(esp32Url);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            // Read response from ESP32
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();

	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            // Close connections
	            in.close();
	            connection.disconnect();

	            // Assuming the ESP32 response is JSON format like: {"batteryLevel": 80, "temperature": 35}
	            String jsonResponse = content.toString();

	            // Send the response to the client
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");
	            PrintWriter out = response.getWriter();
	            out.print(jsonResponse);
	            out.flush();
	            
	        } catch (Exception e) {
	            // Handle errors
	            e.printStackTrace();
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");
	            response.getWriter().write("{\"error\": \"Failed to retrieve battery info\"}");
	        }
	    }
}
