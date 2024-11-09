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
 * Test class for the {@link FahrenheitController}, verifying temperature conversion
 * endpoints from Fahrenheit to Celsius and Fahrenheit to Kelvin.
 *
 * <p>This class uses MockMvc to perform HTTP requests and validate responses,
 * ensuring the correct results and HTTP status codes are returned for various input cases.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class FahrenheitControllerTest {

    @Autowired
    MockMvc mockMvc;

    /** Base URL for temperature conversion API endpoints */
    final String API_URL = "/fahrenheit-to";

    /**
     * Tests the Fahrenheit to Celsius conversion with a specified parameter.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void fahrenheitToCelsius_shouldReturnCorrectResult_whenFahrenheitToCelsiusCalled() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL + "/celsius")
                        .param("degrees", "50")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("10.0008"));
    }

    /**
     * Tests the Fahrenheit to Celsius conversion with no specified parameter.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void fahrenheitToCelsius_shouldReturnCorrectResult_whenFahrenheitToCelsiusCalledWithoutParams() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/celsius")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-17.7792"));
    }

    /**
     * Tests the Fahrenheit to Kelvin conversion with a specified parameter.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void fahrenheitToKelvin_shouldReturnCorrectResult_whenFahrenheitToKelvinCalled() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL + "/kelvin")
                        .param("degrees", "87")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("303.708"));

    }

    /**
     * Tests the Fahrenheit to Kelvin conversion with no specified parameter.
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    void fahrenheitToKelvin_shouldReturnCorrectResult_whenFahrenheitToKelvinCalledWithoutParams() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/kelvin")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("255.3708"));

    }
}