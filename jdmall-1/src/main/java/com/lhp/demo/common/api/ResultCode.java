package com.lhp.demo.common.api;

/**
 * @ClassName: ResultCode
 * @Description:枚举状态码
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 14:37
 * @Version： V1.0
 **/
public enum ResultCode implements IErrorCode{
    //定义五种状态
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String massage;

    private ResultCode(long code, String massage) {
        this.code = code;
        this.massage = massage;
    }


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMassage() {
        return massage;
    }
}
