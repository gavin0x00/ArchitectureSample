package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName ResetPwdForm
 * @createDate 2018/10/10 15:55
 * @email 408030208@qq.com
 * @desc 重置密码表单
 */
public class ResetPwdForm {

    /**
     * code : 123456
     * language : ch or en
     * password : 123456
     * phone : 18670827798
     * rePassword : 123456
     * token : string
     * userId : string
     */

    private String  code;
    private String language;
    private String  password;
    private String  phone;
    private String  rePassword;
    private String token;
    private String userId;

    public ResetPwdForm(String code, String language, String password, String phone, String rePassword, String token, String userId) {
        this.code = code;
        this.language = language;
        this.password = password;
        this.phone = phone;
        this.rePassword = rePassword;
        this.token = token;
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ResetPwdForm{" +
                "code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
