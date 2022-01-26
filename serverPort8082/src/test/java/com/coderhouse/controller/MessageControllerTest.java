package com.coderhouse.controller;

import com.coderhouse.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mock;

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - It is executed before all tests");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - It is executed before each test");
    }

    @Test
    public void getAllMessages() throws Exception {
        var result = mock.perform(get("/coder-house/mensajes/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        var content = result.getResponse().getContentAsString();
        var messages = mapper.readValue(content, List.class);

        Assert.notNull(messages, "Message list is not null");
        Assert.notEmpty(messages, "Message list with elements");
        Assert.isTrue(messages.size() == 5, "List size is 4");
    }

    @Test
    public void getMessageById() throws Exception {
        mock.perform(get("/coder-house/mensajes/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Mensaje-ABCD")));
    }

    @Test
    public void getMessageByIdResult() throws Exception {
        var result = mock.perform(get("/coder-house/mensajes/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        var content = result.getResponse().getContentAsString();
        var message = mapper.readValue(content, Message.class);

        Assert.notNull(message, "Message is not null");
        Assert.isTrue(message.getId() == 1, "Message ID is ok");
        Assert.isTrue(message.getDescription().equals("Mensaje-ABCD"), "Message description is OK");
    }

}