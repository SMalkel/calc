package ru.neoflex.practice;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PracticeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    //subtract operation testing

    @Test
    public void shouldReturnSummary() throws Exception {
        this.mockMvc.perform(get("/plus/103.5/21.3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("124.8")));
    }

    @Test
    public void shouldReturnSummaryMinus() throws Exception {
        this.mockMvc.perform(get("/plus/52.2/-7.4")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("44.8")));
    }

    @Test
    public void shouldReturnSummaryString() throws Exception {
        this.mockMvc.perform(get("/plus/a/-8")).andDo(print()).andExpect(status().isBadRequest());
    }

    //fold operation testing

    @Test
    public void shouldReturnDifference() throws Exception {
        this.mockMvc.perform(get("/minus/98/10.1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("87.9")));
    }

    @Test
    public void shouldReturnDifferenceMinus() throws Exception {
        this.mockMvc.perform(get("/minus/67/-72.6")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("139.6")));
    }

    @Test
    public void shouldReturnDifferenceString() throws Exception {
        this.mockMvc.perform(get("/minus/6/b")).andDo(print()).andExpect(status().isBadRequest());
    }

    //multiplication operation testing

    @Test
    public void shouldReturnMultiplication() throws Exception {
        this.mockMvc.perform(get("/multiply/3.3/2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("6.6")));
    }

    @Test
    public void shouldReturnMultiplicationMinus() throws Exception {
        this.mockMvc.perform(get("/multiply/8.1/-4.2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("-34.02")));
    }

    @Test
    public void shouldReturnMultiplicationString() throws Exception {
        this.mockMvc.perform(get("/multiply/a/-8")).andDo(print()).andExpect(status().isBadRequest());
    }

    //division operation testing

    @Test
    public void shouldReturnDivision() throws Exception {
        this.mockMvc.perform(get("/devide/78.5/10")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("7.85")));
    }

    @Test
    public void shouldReturnDivisionMinus() throws Exception {
        this.mockMvc.perform(get("/devide/3/-1.2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("-2.5")));
    }

    @Test
    public void shouldReturnDivisionString() throws Exception {
        this.mockMvc.perform(get("/devide/6/b")).andDo(print()).andExpect(status().isBadRequest());
    }
}