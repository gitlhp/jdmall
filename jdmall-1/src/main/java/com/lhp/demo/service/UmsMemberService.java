package com.lhp.demo.service;

import com.lhp.demo.common.api.CommonResult;

/**
 * @ClassName: UmsMemberService
 * @Description:会员管理Service
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/10/25 15:16
 * @Version： V1.0
 **/
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
