package com.gklyphon.termometer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 *
 * REST controller that provides endpoints to convert Celsius degrees
 * to other temperature scales, such as Fahrenheit and Kelvin.
 *
 * <p>This controller offers two conversion methods:
 * <ul>
 * <li>Celsius to Fahrenheit</li>
 * <li>Celsius to Kelvin</li>
 * </ul>
 * <p>Conversions are performed using decimal values (BigDecimal).
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@RestController
@RequestMapping("/celsius-to")
public class CelsiusController {

    /**
     * Converts Celsius degrees to Fahrenheit degrees.
     *
     * <p>This endpoint accepts a parameter called "degrees" which represents
     * the temperature in Celsius. If no value is provided, 0°C is used as the default.
     *
     * <p>The conversion formula used is:
     * <pre>(Celsius * 1.8) + 32</pre>
     *
     * @param degrees Temperature in Celsius to convert (optional, default value is 0)
     * @return {@link ResponseEntity} with the temperature converted to Fahrenheit
     * in the response body and an HTTP status code of 200 (OK)
     */
    @GetMapping("/fahrenheit")
    public ResponseEntity<?> celsiusToFahrenheit(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {
        return ResponseEntity.ok().body(
                (degrees.multiply(BigDecimal.valueOf(1.8)))
                        .add(BigDecimal.valueOf(32))
        );
    }

    /**
     * Converts Celsius degrees to Kelvin degrees.
     *
     * <p>This endpoint accepts a parameter called "degrees" which represents
     * the temperature in Celsius. If no value is provided, 0°C is used as the default.
     *
     * <p>The conversion formula used is:
     * <pre>Celsius + 273.15</pre>
     *
     * @param degrees Temperature in Celsius to convert (optional, default value is 0)
     * @return {@link ResponseEntity} with the temperature converted to Kelvin
     * in the response body and an HTTP status code of 200 (OK)
     */
    @GetMapping("/kelvin")
    public ResponseEntity<?> celsiusToKelvin(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {
        return ResponseEntity.ok().body(
                degrees.subtract(BigDecimal.valueOf(273.15))
        );
    }

}
