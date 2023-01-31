package com.example.atddexample;

import com.example.atddexample.application.PendingOrderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class orderApiIntegrationTest extends Exception {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Test
    void result() throws Exception {
        // Arrange


        // Act

        // Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isGreaterThan(0);
    }
}
