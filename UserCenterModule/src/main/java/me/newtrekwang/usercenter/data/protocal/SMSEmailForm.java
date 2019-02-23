package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName SMSPhoneForm
 * @createDate 2018/10/10 10:52
 * @email 408030208@qq.com
 * @desc 获取短信验证码json表单
 */
public  class SMSEmailForm {

    private String language;
    private String email;

    public SMSEmailForm(String language, String email) {
        this.language = language;
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SMSEmailForm{" +
                "language='" + language + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
