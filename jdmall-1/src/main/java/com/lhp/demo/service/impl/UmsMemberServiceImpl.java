package com.lhp.demo.service.impl;

import com.lhp.demo.common.api.CommonResult;
import com.lhp.demo.service.RedisService;
import com.lhp.demo.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @ClassName: UmsMemberServiceImpl
 * @Description:会员管理Service实现类
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/10/25 15:20
 * @Version： V1.0
 **/
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 获取验证码
     *
     * @param telephone
     * @return
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append((random.nextInt(10)));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuilder.toString());
        if (redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone) == null) {
            log.error("验证码没有存到redis，请检查数据库,键值为:{}", REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        }else if (stringBuilder.toString().equals(redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone))){
            log.info("验证码存入redis成功");
        }
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        log.info("获取验证码成功：{}", stringBuilder.toString());
        return CommonResult.success(stringBuilder.toString(), "获取验证码成功");
    }

    /**
     * 校验验证码
     *
     * @param telephone 手机号
     * @param authCode  验证码
     * @return
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        //真实的验证码
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
