package me.newtrekwang.usercenter.data.protocal;

/**
 * @author newtrekWang
 * @fileName RegisterValidateRes
 * @createDate 2018/10/10 11:56
 * @email 408030208@qq.com
 * @desc TODO
 */
public class RegisterValidateRes {
    /**
     * id : 1049835565799415809
     * userName : 18683668831
     * exist : false
     */

    private String id;
    private String userName;
    private boolean exist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    @Override
    public String toString() {
        return "RegisterValidateRes{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", exist=" + exist +
                '}';
    }
}
