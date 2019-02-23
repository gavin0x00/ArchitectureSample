package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName LoginForm
 * @createDate 2018/10/10 15:14
 * @email 408030208@qq.com
 * @desc 登录信息表单
 */
public class LoginForm {

    /**
     * code : string
     * language : ch
     * password : 123456
     * userName : 18683668831
     */

    private String code;
    private String language;
    private String password;
    private String userName;

    public LoginForm(String code, String language, String password, String userName) {
        this.code = code;
        this.language = language;
        this.password = password;
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
