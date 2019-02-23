package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName RegisterForm
 * @createDate 2018/10/10 12:04
 * @email 408030208@qq.com
 * @desc TODO
 */
public class RegisterForm {

    /**
     * id : string
     * language : ch or en
     * password : string
     * rePassword : string
     * userName : string
     */

    private String id;
    private String language;
    private String password;
    private String rePassword;
    private String userName;

    public RegisterForm(String id, String language, String password, String rePassword, String userName) {
        this.id = id;
        this.language = language;
        this.password = password;
        this.rePassword = rePassword;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
