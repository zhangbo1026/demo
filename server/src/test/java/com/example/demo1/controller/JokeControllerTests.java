package com.example.demo1.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo1.model.Joke;
import com.example.demo1.repository.JokeRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc
public class JokeControllerTests {
    private Logger logger = LoggerFactory.getLogger(JokeControllerTests.class);
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JokeRepository jokeRepository;

    @Test
    public void getAllJokesTest() throws Exception {
        mockMvc.perform(get("/api/jokes")).andExpect(status().isOk());
    }
    @Test
    public  void jokeCurd() throws Exception {
        jokeRepository.deleteAll();
        Joke joke = new Joke();
        joke.setTitle("joketitle");
        joke.setContent("jokecontent");
        joke.setUpdatedAt(new Date());
        joke.setCreateAt(new Date());
        JSONObject object = new JSONObject();
        object.put("id","88888");
        object.put("title",joke.getTitle());
        object.put("content",joke.getContent());
        object.put("createAt",joke.getCreateAt());
        object.put("updatedAt",joke.getUpdatedAt());
       MvcResult mvcResult =  mockMvc.perform(post("/api/jokes").
                content(object.toJSONString()).
               contentType(MediaType.APPLICATION_JSON)).
               andExpect(status().isOk())
               .andReturn();
       String test = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONArray.parseArray(test);
        assertThat(jsonArray.size()).isEqualTo(1);
        //查看title
        assertThat(((JSONObject)jsonArray.get(0)).getString("title")).isEqualTo("joketitle");


       logger.info(test);


       /////////////修改
        int id = ((JSONObject) jsonArray.get(0)).getInteger("id");
        joke.setId(id);
        joke.setTitle("joketitle1");
        mvcResult = mockMvc.perform(put("/api/jokes/"+id).
                content(JSONObject.toJSONString(joke)).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        object =JSONObject.parseObject( mvcResult.getResponse().getContentAsString());
        assertThat(object.getString("title")).isEqualTo("joketitle1");



        /////删除
        mockMvc.perform(delete("/api/jokes/"+id)).andExpect(status().isOk());



        mvcResult = mockMvc.perform(get("/api/jokes")).andExpect(status().isOk())
                .andReturn();

        jsonArray = JSONArray.parseArray(mvcResult.getResponse().getContentAsString());
        //若删除成功，那么jsonArray size = 0
        assertThat(jsonArray.size()).isEqualTo(0);
    }
    public void exceptionTest(){

    }
    @After
    public void removeAllJokes() {
        jokeRepository.deleteAll();
    }

}
