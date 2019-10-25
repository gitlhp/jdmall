package com.lhp.demo.autombg.mapper;

import com.lhp.demo.Jdmall1Application;
import com.lhp.demo.autombg.model.PmsBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: PmsBrandMapperTest
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 17:28
 * @Version： V1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Jdmall1Application.class)
@Slf4j
public class PmsBrandMapperTest {
    @Autowired
    PmsBrandMapper pmsBrandMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
        long id =2;
        pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExampleWithBLOBs() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
        long id = 1;
        pmsBrandMapper.selectByPrimaryKey(id);


    }
}