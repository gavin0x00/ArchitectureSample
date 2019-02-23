package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName TokenWrapper
 * @createDate 2018/10/10 15:13
 * @email 408030208@qq.com
 * @desc tokenWrapper
 */
public class TokenWrapper {
    private String token;

    public TokenWrapper(String token) {
        this.token = token;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenWrapper{" +
                "token='" + token + '\'' +
                '}';
    }
}
