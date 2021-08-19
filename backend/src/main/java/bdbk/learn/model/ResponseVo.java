package bdbk.learn.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author little_eight
 * @since 2021/8/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseVo {

    /** 成功 */
    public static final String SUCCESS_CODE = "0";
    /** 参数校验错误 */
    public static final String BAD_REQUEST = "00001";
    /** 未授权请求 */
    public static final String UNAUTHORIZED = "10001";
    /** 数据库操作异常 */
    public static final String SQL_ERROR = "10002";
    /** 业务逻辑异常 */
    public static final String LOGIC_ERROR = "10003";
    /** 流控异常 */
    public static final String FLOW_CONTROL_ERROR = "10004";
    /** 系统内部错误 */
    public static final String SYSTEM_ERROR = "20001";
    /** 服务不可用 */
    public static final String UNAVAILABLE = "20002";
    /** 其它异常 */
    public static final String OTHER = "99999";

    private String code;
    private String message;
    private Object data;

    public static ResponseVo success(Object data) {
        return new ResponseVo(SUCCESS_CODE, "成功", data);
    }
    public static ResponseVo error(String code, String message) {
        return new ResponseVo(code, message, null);
    }

}
