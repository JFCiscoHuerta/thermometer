package com.gklyphon.termometer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Rest Controller for converting temperatures from Fahrenheit to other scales.
 *
 * <p>This controller offers two conversion methods:
 * <ul>
 * <li>Fahrenheit to Celsius</li>
 * <li>Kelvin to Celsius</li>
 * </ul>
 * <p>Conversions are performed using decimal values (BigDecimal).
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@RestController
@RequestMapping("/fahrenheit-to")
public class FahrenheitController {

    /**
     * Converts Fahrenheit to Celsius.
     *
     * <p>This endpoint accepts a Fahrenheit temperature value as a query parameter and returns
     * the equivalent temperature in Celsius. If no value is provided, it defaults to 0°F.
     *
     * @param degrees the temperature in Fahrenheit to be converted to Celsius
     * @return the equivalent temperature in Celsius
     */
    @GetMapping("/celsius")
    public ResponseEntity<?> fahrenheitToCelsius(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {

        return ResponseEntity.ok().body(
                (degrees.subtract(BigDecimal.valueOf(32)))
                        .multiply(BigDecimal.valueOf(0.5556))
        );
    }

    /**
     * Converts Fahrenheit to Kelvin.
     *
     * <p>This endpoint accepts a Fahrenheit temperature value as a query parameter and returns
     * the equivalent temperature in Kelvin. If no value is provided, it defaults to 0°F.
     *
     * @param degrees the temperature in Fahrenheit to be converted to Kelvin
     * @return the equivalent temperature in Kelvin
     */
    @GetMapping("/kelvin")
    public ResponseEntity<?> fahrenheitToKelvin(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {

        return ResponseEntity.ok().body(
                ((degrees.subtract(BigDecimal.valueOf(32)))
                        .multiply(BigDecimal.valueOf(0.5556)))
                        .add(BigDecimal.valueOf(273.15))
        );
    }

}
