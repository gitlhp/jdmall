package com.lhp.demo.service.impl;

import com.lhp.demo.autombg.mapper.PmsBrandMapper;
import com.lhp.demo.autombg.model.PmsBrand;
import com.lhp.demo.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: PmsBrandServiceImplTestMock
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 17:55
 * @Version： V1.0
 **/
@RunWith(PowerMockRunner.class)
//@PrepareForTest({PmsBrandServiceImpl.class})
@Slf4j
public class PmsBrandServiceImplTestMock extends PowerMockito {
    //模拟dao层
    @Mock
    private PmsBrandMapper pmsBrandMapper;
    @InjectMocks
    private PmsBrandServiceImpl pmsBrandService;

//    @Before
//    public void setUp() throws Exception {
    //类中的静态方法 如果用到了Spring环境对象，这时就要PowerMockito.mockStatic；
//        PowerMockito.mockStatic(PmsBrandServiceImpl.class);
//    }

    @Test
    public void getBrand() {
        PmsBrand pmsBrand=PmsBrand.builder().name("lhp").build();
        System.out.println(pmsBrand.getName());
        PowerMockito.when(pmsBrandMapper.selectByPrimaryKey((long) 1)).thenReturn(pmsBrand);
        Assert.assertEquals(pmsBrand.getName(),pmsBrandService.getBrand((long) 1).getName());
        log.info("MOCK测试成功执行");
    }
}