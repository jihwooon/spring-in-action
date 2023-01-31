package hello.advanced.app.v0;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(OrderControllerV0.class)
public class OrderControllerV0Test {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderServiceV0 orderServiceV0;

    @Test
    void result() throws Exception {
        String request = "ex";
        mockMvc.perform(get("/v0/request")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                )
                .andExpect(content().string(containsString("ok")));
    }
}
