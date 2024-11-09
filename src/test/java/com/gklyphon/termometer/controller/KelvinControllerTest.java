package com.gklyphon.termometer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for KelvinController, which handles temperature conversions
 * from Kelvin to Celsius and Fahrenheit.
 * <p>
 * This class tests each conversion endpoint to verify that the expected
 * temperature conversions are correct.
 * </p>
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 09-Nov-2024
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class KelvinControllerTest {

    @Autowired
    MockMvc mockMvc;

    // Base URL for KelvinController API endpoints
    final String API_URL = "/kelvin-to";

    /**
     * Tests the conversion from Kelvin to Celsius using a specific Kelvin value.
     * <p>
     * This test sends a Kelvin temperature of 43.0, expecting a Celsius result
     * of -230.15.
     * </p>
     *
     * @throws Exception if there is an error in performing the request
     */
    @Test
    void kelvinToCelsius_shouldReturnCorrectResult_whenKelvinToCelsiusCalled() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL + "/celsius")
                        .param("degrees", "43.0")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-230.15"));
    }

    /**
     * Tests the default conversion from Kelvin to Celsius without providing a
     * specific Kelvin value.
     * <p>
     * The default value for degrees is 0 K, and the expected Celsius result is
     * -273.15.
     * </p>
     *
     * @throws Exception if there is an error in performing the request
     */
    @Test
    void kelvinToCelsius_shouldReturnCorrectResult_whenKelvinToCelsiusCalledWithourParans() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/celsius")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-273.15"));
    }

    /**
     * Tests the conversion from Kelvin to Fahrenheit using a specific Kelvin value.
     * <p>
     * This test sends a Kelvin temperature of 1090.0, expecting a Fahrenheit result
     * of 1502.33.
     * </p>
     *
     * @throws Exception if there is an error in performing the request
     */
    @Test
    void kelvinToFahrenheit_shouldReturnCorrectResult_whenKelvinToFahrenheitCalled() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/fahrenheit")
                                .param("degrees", "1090.0")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("1502.33"));
    }

    /**
     * Tests the default conversion from Kelvin to Fahrenheit without providing a
     * specific Kelvin value.
     * <p>
     * The default value for degrees is 0 K, and the expected Fahrenheit result is
     * -459.67.
     * </p>
     *
     * @throws Exception if there is an error in performing the request
     */
    @Test
    void kelvinToFahrenheit_shouldReturnCorrectResult_whenKelvinToFahrenheitCalledWithoutParams() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get(API_URL + "/fahrenheit")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("-459.67"));
    }
}