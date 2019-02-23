package me.newtrekwang.baselibrary.data.net;

import java.io.IOException;

import me.newtrekwang.baselibrary.common.BaseConstant;
import me.newtrekwang.baselibrary.utils.AppPrefsUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author newtrekWang
 * @fileName TokenInterceptor
 * @createDate 2018/7/26 10:02
 * @email 408030208@qq.com
 * @desc token处理拦截器
 */
public class TokenInterceptor implements Interceptor {
    public static int NEED_AUTH = 401;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originalResponse = chain.proceed(request);
        // 401表示需求重新登录或者token失效
        if (originalResponse.code() == NEED_AUTH ){
            //todo 获取新token,暂未完善，后续和后台约定token接口
            String  newToken = "newToken";
            AppPrefsUtils.getInstance().putString(BaseConstant.KEY_SP_TOKEN,newToken);
            Request newRequest = request.newBuilder()
                    .header("token",newToken)
                    .build();
            originalResponse.body().close();
            return chain.proceed(newRequest);
        }
        return originalResponse;
    }


}
