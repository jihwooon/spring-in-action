package com.example.atddexample;

import com.example.atddexample.application.PendingOrderRequest;
import com.example.atddexample.application.PendingOrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderApiIntegrationTest extends Exception {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectConfig projectConfig;

    @Test
    void result() throws Exception {
        // Arrange
        long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        // Act
        MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(projectConfig.toJson(request)))
                .andReturn().getResponse();

        // Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponse pendingOrderResponse = projectConfig.getValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isGreaterThan(0);
    }
}
