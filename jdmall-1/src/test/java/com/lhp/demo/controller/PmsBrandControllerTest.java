package com.lhp.demo.controller;

import com.lhp.demo.autombg.model.PmsBrand;
import com.lhp.demo.service.impl.PmsBrandServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * @ClassName: PmsBrandControllerTest
 * @Description:
 * @Author: 李怀鹏
 * @Company: BJUT
 * @Date： 2019/10/24 17:46
 * @Version： V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class PmsBrandControllerTest {
    @Mock
    PmsBrandServiceImpl pmsBrandService;
    @InjectMocks
    PmsBrandController pmsBrandController;

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        //非mock模式下使用模拟上下文
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        //使用自己搭建的组件
        mockMvc = MockMvcBuilders.standaloneSetup(pmsBrandController).build();
    }

    @Test
    public void getBrandList() {
    }

    @Test
    public void createBrand() {
    }

    @Test
    public void updateBrand() {
    }

    @Test
    public void deleteBrand() {
    }

    @Test
    public void listBrand() {
    }

    @Test
    public void brand() throws Exception {
        PmsBrand pmsBrand = PmsBrand.builder().name("lhp").build();
        PowerMockito.when(pmsBrandService.getBrand(1L)).thenReturn(pmsBrand);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/brand/{id}",1L)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("data.name", is("lhp"))).andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("输出结果：{}", mvcResult.getResponse().getContentAsString());
    }
}