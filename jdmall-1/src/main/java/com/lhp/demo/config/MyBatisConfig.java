package com.lhp.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyBatisConfig
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 13:39
 * @Version： V1.0
 **/
@Configuration
@MapperScan("com.lhp.demo.autombg.mapper")
public class MyBatisConfig {
}
