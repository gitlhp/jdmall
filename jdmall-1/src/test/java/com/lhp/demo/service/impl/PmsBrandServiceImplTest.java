package com.lhp.demo.service.impl;

import com.lhp.demo.autombg.mapper.PmsBrandMapper;
import com.lhp.demo.autombg.model.PmsBrand;
import com.lhp.demo.autombg.model.PmsBrandExample;
import com.lhp.demo.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: PmsBrandServiceImplTest
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 15:57
 * @Version： V1.0
 **/
//创造spring环境
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class PmsBrandServiceImplTest {
    @Autowired
    PmsBrandMapper pmsBrandMapper;
    @Autowired
    PmsBrandService pmsBrandService;

    @Before
    public void setUp() {
        log.debug("单元测试开始");
    }

    @Test
    public void listAllBrand() {
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandService.listAllBrand();
    }

    @Test
    public void createBrand() {
    }

    @Test
    public void updateBrand() {
    }

    @Test
    public void deleteBrand() {
        Assert.assertEquals(1,pmsBrandService.deleteBrand((long) 4));
    }

    @Test
    public void listBrand() {
    }

    @Test
    public void getBrand() {
        PmsBrand pmsBrand = pmsBrandService.getBrand((long) 5);
        System.out.println(pmsBrand.toString());
        log.info("成功了！");
    }

    @org.junit.jupiter.api.Test
    void testGetBrand() {
    }
}