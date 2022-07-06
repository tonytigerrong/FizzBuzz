package com.rbc.interview.fizzbuzz.controller;

import com.rbc.interview.fizzbuzz.FizzbuzzApplication;
import com.rbc.interview.fizzbuzz.model.FizzBuzzReps;
import com.rbc.interview.fizzbuzz.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FizzbuzzApplication.class)
@AutoConfigureMockMvc
public class ControllerIntegrationTest {


    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mvc;

    /**
     * Integration test via same session
     * @throws Exception
     */
    @Test
    public void getNextViaSameSession() throws Exception {
        FizzBuzzReps result = new FizzBuzzReps();
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("fakeSession","");
        String sessionId = session.getId();
        mvc.perform(
                get("/fizzbuzz/next").session(session).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(result))
        ).andExpect(jsonPath("$.nextValue",is("101")));

        mvc.perform(
                get("/fizzbuzz/next").session(session).contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(result))

        ).andExpect(jsonPath("$.nextValue",is("Fizz")));

        mvc.perform(
                get("/fizzbuzz/next").session(session).contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(result))

        ).andExpect(jsonPath("$.nextValue",is("103"))).andExpect(jsonPath("$.sessionId", is(sessionId)));
    }

    /**
     * Integration test via diff session
     * @throws Exception
     */
    @Test
    public void getNextViaDiffSession() throws Exception {
        FizzBuzzReps result = new FizzBuzzReps();
        MockHttpSession session1 = new MockHttpSession();
        session1.setAttribute("fakeSession","1");
        MockHttpSession session2 = new MockHttpSession();
        session2.setAttribute("fakeSession","2");
        mvc.perform(
                get("/fizzbuzz/next").session(session1).contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(result))
        ).andExpect(jsonPath("$.nextValue",is("101")));

        mvc.perform(
                get("/fizzbuzz/next").session(session2).contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(result))

        ).andExpect(jsonPath("$.nextValue",is("101")));
    }
}
