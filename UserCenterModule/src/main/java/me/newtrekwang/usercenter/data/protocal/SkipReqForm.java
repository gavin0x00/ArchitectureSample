package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName SkipReqForm
 * @createDate 2018/10/10 11:52
 * @email 408030208@qq.com
 * @desc 注册验证表单
 */
public class SkipReqForm {

    /**
     * code : 620702
     * language : ch
     * phone : 18683668831
     */

    private String code;
    private String language;
    private String phone;

    public SkipReqForm(String code, String language, String phone) {
        this.code = code;
        this.language = language;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SkipReqForm{" +
                "code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
