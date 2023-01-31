package com.example.atddexample;

import com.example.atddexample.application.PendingOrderRequest;
import com.example.atddexample.application.PendingOrderResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class orderApiIntegrationTest extends Exception {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Test
    void result() throws Exception {
        // Arrange

        // Act
        MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();

        // Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isGreaterThan(0);
    }
}
