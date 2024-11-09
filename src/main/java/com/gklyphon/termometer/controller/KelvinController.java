package com.gklyphon.termometer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Controller for converting temperatures from Kelvin to other scales.
 *
 * <p>This controller offers two conversion methods:
 * <ul>
 * <li>Kelvin to Celsius</li>
 * <li>Kelvin to Fahrenheit</li>
 * </ul>
 * <p>Conversions are performed using decimal values (BigDecimal).
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@RestController
@RequestMapping("/kelvin-to")
public class KelvinController {

    /**
     * Converts Kelvin to Celsius.
     *
     * <p>This endpoint accepts a Kelvin temperature value as a query parameter and returns
     * the equivalent temperature in Celsius. If no value is provided, it defaults to 0 K.
     *
     * @param degrees the temperature in Kelvin to be converted to Celsius
     * @return the equivalent temperature in Celsius
     */
    @GetMapping("/celsius")
    public ResponseEntity<?> kelvinToCelsius(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {
        return ResponseEntity.ok().body(
                degrees.subtract(BigDecimal.valueOf(273.15))
        );
    }

    /**
     * Converts Kelvin to Fahrenheit.
     *
     * <p>This endpoint accepts a Kelvin temperature value as a query parameter and returns
     * the equivalent temperature in Fahrenheit. If no value is provided, it defaults to 0 K.
     *
     * @param degrees the temperature in Kelvin to be converted to Fahrenheit
     * @return the equivalent temperature in Fahrenheit
     */
    @GetMapping("/fahrenheit")
    public ResponseEntity<?> kelvinToFahrenheit(
            @RequestParam(name = "degrees", defaultValue = "0") BigDecimal degrees) {

        return ResponseEntity.ok().body(
                (degrees.subtract(BigDecimal.valueOf(273.15)))
                        .multiply(BigDecimal.valueOf(1.8))
                        .add(BigDecimal.valueOf(32))
        );
    }


}
