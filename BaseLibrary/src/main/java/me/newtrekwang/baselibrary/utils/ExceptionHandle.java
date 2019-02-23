package me.newtrekwang.baselibrary.utils;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * @author newtrekWang
 * @fileName ExceptionHandle
 * @createDate 2018/7/25 15:10
 * @email 408030208@qq.com
 * @desc 异常处理类
 */
public class ExceptionHandle {

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    /**
     * 处理异常
     * @param e 原始异常对象
     * @return 最终都会转换为统一异常对象
     */
    public static ResponseException handleException(Throwable e) {
        ResponseException ex;
        Log.e("tag", "e.toString = " + e.toString());
        if (e instanceof HttpException) {
            // http异常
            HttpException httpException = (HttpException) e;
            ex = new ResponseException(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    ex.message = "未验证";
                    break;
                case FORBIDDEN:
                    ex.message = "服务禁止访问";
                    break;
                case NOT_FOUND:
                    ex.message = "服务不存在";
                    break;
                case REQUEST_TIMEOUT:
                    ex.message = "请求超时";
                    break;
                case GATEWAY_TIMEOUT:
                    ex.message = "网关超时";
                    break;
                case INTERNAL_SERVER_ERROR:
                    ex.message = "服务器内部错误";
                    break;
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误"+httpException.getMessage();
                    break;
            }
            return ex;
        }else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            // 解析异常
            ex = new ResponseException(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";
            return ex;
        } else if (e instanceof ConnectException) {
            // 连接异常
            ex = new ResponseException(e, ERROR.NETWORK_ERROR);
            ex.message = "连接失败";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            // 证书异常
            ex = new ResponseException(e, ERROR.SSL_ERROR);
            ex.message = "证书验证失败";
            return ex;
        } else if (e instanceof ResponseException){
            // 自己约定的异常
            ex  = (ResponseException) e;
            return ex;
        } else {
            // 其他错误
            ex = new ResponseException(e, ERROR.UNKNOWN);
            ex.message =e.getMessage();
            return ex;
        }
    }

    /**
     * 约定异常
     */
    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORK_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
        /**
         * 自定义异常
         */
        public static final int CUSTOM_ERROR = 1006;
    }


    /**
     * @className ResponseException
     * @createDate 2018/7/25 15:17
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc  统一异常类，便于处理
     *
     */
    public static class ResponseException extends Exception {
        public int code;
        public String message;

        public ResponseException(Throwable throwable, int code) {
            super(throwable);
            this.code = code;
            this.message = throwable.getMessage();
        }
    }

}
