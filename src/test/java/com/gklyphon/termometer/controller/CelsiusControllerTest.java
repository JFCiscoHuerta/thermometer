package com.gklyphon.termometer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for the {@link CelsiusController}, verifying temperature conversion
 * endpoints from Celsius to Fahrenheit and Celsius to Kelvin.
 *
 * <p>This class uses MockMvc to perform HTTP requests and validate responses,
 * ensuring the correct results and HTTP status codes are returned for various input cases.
 *
 *  @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class CelsiusControllerTest {

    @Autowired
    MockMvc mockMvc;

    /** Base URL for temperature conversion API endpoints */
    final String API_URL = "/celsius-to";

    /**
     * Tests the Celsius to Fahrenheit conversion with a given parameter.
     *
     * <p>Makes a GET request to the /fahrenheit endpoint with 100.0 degrees Celsius.
     * The expected result is 212.0 Fahrenheit, with an HTTP status of 200 (OK).
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void celsiusToFahrenheit_shouldReturnTheCorrectResult_whenCelsiusToFahrenheitCalled() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL + "/fahrenheit")
                        .param("degrees","100.0")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("212.0"));
    }

    /**
     * Tests the Celsius to Fahrenheit conversion without a specified parameter.
     *
     * <p>Makes a GET request to the /fahrenheit endpoint with no parameters.
     * The default value is 0.0 Celsius, expected to return 32.0 Fahrenheit,
     * with an HTTP status of 200 (OK).
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void celsiusToFahrenheit_shouldReturnTheCorrectResult_whenCelsiusToFahrenheitCalledWithoutParams() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/fahrenheit")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("32.0"));
    }

    /**
     * Tests the Celsius to Kelvin conversion with a given parameter.
     *
     * <p>Makes a GET request to the /kelvin endpoint with 100.0 degrees Celsius.
     * The expected result is -173.15 Kelvin, with an HTTP status of 200 (OK).
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void celsiusToKelvin_shouldReturnTheCorrectResult_whenCelsiusToKelvinCalled() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL + "/kelvin")
                        .param("degrees","100.0")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-173.15"));
    }

    /**
     * Tests the Celsius to Kelvin conversion without a specified parameter.
     *
     * <p>Makes a GET request to the /kelvin endpoint with no parameters.
     * The default value is 0.0 Celsius, expected to return -273.15 Kelvin,
     * with an HTTP status of 200 (OK).
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void celsiusToKelvin_shouldReturnTheCorrectResult_whenCelsiusToKelvinCalledWithoutParams() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/kelvin")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-273.15"));
    }

}