package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName SMSPhoneForm
 * @createDate 2018/10/10 10:52
 * @email 408030208@qq.com
 * @desc 获取短信验证码json表单
 */
public  class SMSPhoneForm {

    /**
     * language : ch
     * phone : 18683668831
     */

    private String language;
    private String phone;

    public SMSPhoneForm(String language, String phone) {
        this.language = language;
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SMSPhoneForm{" +
                "language='" + language + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
