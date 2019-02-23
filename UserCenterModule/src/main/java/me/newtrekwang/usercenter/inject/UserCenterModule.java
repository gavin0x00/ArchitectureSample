package me.newtrekwang.usercenter.inject;

import me.newtrekwang.usercenter.data.service.UserCenterService;
import me.newtrekwang.usercenter.data.service.UserCenterServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * @author newtrekWang
 * @fileName UserCenterModule
 * @createDate 2018/9/3 14:11
 * @email 408030208@qq.com
 * @desc 用户中心Module
 */
@Module
public class UserCenterModule {
    /**
     * 提供UserCenterService实例
     * @param userCenterImp
     * @return userCenterImp
     */
    @Provides
    public UserCenterService provideUserCenterService(UserCenterServiceImpl userCenterImp){
        return userCenterImp;
    }
}
