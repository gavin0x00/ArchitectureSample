package me.newtrekwang.baselibrary.rx;


import me.newtrekwang.baselibrary.common.BaseConstant;
import me.newtrekwang.baselibrary.data.protocal.BaseResp;
import me.newtrekwang.baselibrary.utils.ExceptionHandle;
import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * @className BaseFunc
 * @createDate 2018/7/15 23:31
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc  被观察者转换
 * @param <T> T 为data的类型
 *
 */
public class BaseFunc<T> implements Function<BaseResp<T>, Observable<T>> {

    @Override
    public Observable<T> apply(BaseResp<T> tBaseResp) {
        String errorString = "异常";
        // 接口约定的异常处理
        switch (tBaseResp.getCode()){
            case BaseConstant.STATUS_OK:
            case BaseConstant.STATUS_ACESS_NOMAL:
                // 正常请求,传递业务数据
                return Observable.just(tBaseResp.getData());
                case BaseConstant.STATUS_NEED_TOKEN:
                    errorString = "需要用户认证";
                    break;
                    case BaseConstant.STATUS_NOT_FOUND:
                        errorString = "找不到服务";
                        break;
                        case BaseConstant.STATUS_REJECT:
                            errorString = "服务拒绝";
                            break;
                            case BaseConstant.STATUS_SERVER_ERROR:
                                errorString = "服务内部错误";
                                break;
                                default:
                                    if (tBaseResp.getMsg()!=null){
                                        errorString = tBaseResp.getMsg();
                                    }
                                    break;
        }
        // 传递约定异常
        Throwable throwable = new Throwable(errorString);
        ExceptionHandle.ResponseException responseException = new ExceptionHandle.ResponseException(throwable, ExceptionHandle.ERROR.CUSTOM_ERROR);
        return Observable.error(responseException);
    }
}
