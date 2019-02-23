package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName BaseUserInfo
 * @createDate 2018/10/11 10:18
 * @email 408030208@qq.com
 * @desc 基本用户信息类
 */
public class BaseUserInfo {
    private String address;
    private String birthday;
    private String id;
    private String language;
    private int sex;
    private String token;
    private String userName;

    public BaseUserInfo(String address, String birthday, String id, String language, int sex, String token, String userName) {
        this.address = address;
        this.birthday = birthday;
        this.id = id;
        this.language = language;
        this.sex = sex;
        this.token = token;
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "BaseUserInfo{" +
                "address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", sex=" + sex +
                ", token='" + token + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
