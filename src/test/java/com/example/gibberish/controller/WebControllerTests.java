package com.example.gibberish.controller;

import com.example.gibberish.Gibberish;
import com.example.gibberish.repository.ProverbRepository;
import jdk.jfr.ContentType;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
public class WebControllerTests {

    private MockMvc mockMvc;

    @MockBean
    private ProverbRepository repository;

    @Autowired
    public WebControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void gibberShouldReturnRandomGibberishIfNoParams() throws Exception {
        when(repository.getRandom()).thenReturn("foo").thenReturn("bar").thenReturn("foobar");
        this.mockMvc.perform(get("/gibber"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("foo")));
        this.mockMvc.perform(get("/gibber"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("bar")));
        this.mockMvc.perform(get("/gibber"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("foobar")));
    }

    @Test
    public void gibberShouldReturnJSON() throws Exception {
        when(repository.getRandom()).thenReturn("foo");
        this.mockMvc.perform(get("/gibber"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void gibberShouldReturnGibberishFromParameter() throws Exception {
        this.mockMvc.perform(get("/gibber?text=foo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("foo")));
    }
}
