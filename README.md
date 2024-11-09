## Thermometer

![Java](https://img.shields.io/badge/Java-22-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-green)
![License](https://img.shields.io/badge/License-Apache2-yellow)
![Build](https://img.shields.io/badge/Build-Maven-red)

This project contains a REST API built with Spring Boot that enables temperature conversion between Celsius, Fahrenheit, and Kelvin. It offers controllers with endpoints for seamless conversions across scales, including:

- Celsius to Fahrenheit and Kelvin
- Fahrenheit to Celsius and Kelvin
- Kelvin to Celsius and Fahrenheit
  
Each conversion utilizes high-precision decimal values for accuracy. Endpoints are defined to accept temperature values as query parameters, with defaults set to 0 if no value is provided. 

## Prerequisites
Ensure you have the following installed:
- *Java 22*
- *Maven 3.x*

## Endpoints:
- Celsius to Fahrenheit:  ```/celsius-to/fahrenheit```
- Celsius to Kelvin:      ```/celsius-to/kelvin ```
- Fahrenheit to Kelvin:   ```/fahrenheit-to/kelvin ```
- Fahrenheit to Celsius:  ```/fahrenheit-to/celsius ```
- Kelvin to Celsius:      ```/kelvin-to/celsius ```
- Kelvin to Fahrenheit:   ```/kelvin-to/fahrenheit ```

## Example Usage
Each endpoint accepts a temperature as a query parameter (degrees), with 0 as the default if no value is provided. This flexibility allows for seamless integration into larger applications or testing environments.

Celsius to Fahrenheit:  ```/celsius-to/fahrenheit?degrees=400.0 ```

## License

This project is licensed under the  Apache 2.0 license - see the LICENSE file for detail
