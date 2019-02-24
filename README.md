# Android应用模块化开发说明

## 1. 组件化与模块化

对于组件化和模块化，我的理解是：
- **组件**：指的是单一的功能组件，如地图组件（MapSDK）、支付组件（AnjukePay）、路由组件（Router）等等；
- **模块**：指的是独立的业务模块，如新房模块（NewHouseModule）、二手房模块（SecondHouseModule）、即时通讯模块（InstantMessagingModule）等等；模块相对于组件来说粒度更大。

模块化的好处：
- 多团队并行开发测试；
- 模块间解耦、重用；
- 可单独编译打包某一模块，提升开发效率。

本工程采用模块化开发

## 2. 总体架构图

![架构图](http://img.newtrekwang.me/201818031739-f.png)

总体分为三层
- 最底层为BasicLibrary,职责是为上层提供基础库支持，基础库包含第三方开源库、组件、自定义的库和UI控件等。
- 中间层为Provider，职责是传递给上层基础库支持，也为上层的业务模块提供路由参数，公共常量等。
- 最顶层为Business Module，职责是App业务的具体实现，可根据应用的功能模块拆分成若干业务Module。

## 3. 业务Module分层

![业务Module分层](http://img.newtrekwang.me/201818031810-A.png)

每个业务Module采用MVP分层模式开发，如果业务量小，也可以不采用,直接原始的MVC开发方式也可以。

#### 3.1 mvp分层具体实现模板
例UserCenterModule（用户中心模块）

![UserCenterModule](http://img.newtrekwang.me/myphoto/usercenterShuoMing.png)


![mvp](http://img.newtrekwang.me/myphoto/mvp.png)
## 4. 开发模式切换

例如当前工程包含三个业务Module，即UserCenterModule、OneModule和TwoModule



### 4.1 debug模式

debug模式下，业务module可以单独编译为独立app,相当于一个子工程，与其它业务module解耦，便于专注于业务开发，利于开发人员分工合作，大大加快调试时代码编译速度。可在工程根目录的gradle.properties配置，debugXXX=true

```groovy
org.gradle.jvmargs=-Xmx1536m

# UserCenterModule 是否为debug模式
debugUserCenterModule = true
#debugUserCenterModule = false
# ModuleOne 是否为debug模式
#debugModuleOne = true
debugModuleOne = false
# ModuleTwo 是否为debug模式
#debugModuleTwo = true
debugModuleTwo = false
```

![debug模式](http://img.newtrekwang.me/201818051625-S.png)


此时OneModule,TwoModule和UserCenterModule都是独立android application类型module


### 4.2 release模式

release模式下，业务module会成为library module，为app 壳module提供依赖，所以app壳Module会把需要的业务module集合起来编译成一个完整的apk

可在工程根目录的gradle.properties配置，debugXXX=false

```groovy

org.gradle.jvmargs=-Xmx1536m


# UserCenterModule 是否为debug模式
#debugUserCenterModule = true
debugUserCenterModule = false
# Module1 是否为debug模式
#debugModule1 = true
debugModule1 = false
# Module2 是否为debug模式
#debugModule2 = true
debugModule2 = false
```

![release模式](http://img.newtrekwang.me/201818051624-V.png)

此时module1,module2和usercenter都是android library类型module,release模式一般在最后集成多业务时联合调试时或者要发布应用时用到。


## 5. 业务模块间界面跳转

由于业务模块间已完全解耦，业务模块可独立开发，所以模块间的界面跳转不能时直接引用界面类跳转，需要采用间接跳转。

Android SDK中intent的间接跳转API不好用,故采用alibaba的ARouter路由框架。Arouter用法请参考[ARouter](https://github.com/alibaba/ARouter)

这里所说的跳转一般是Activity跳转，如果是业务Module里的界面类都是Fragment,那么可以这样：
- 业务Module debug模式下，可用一个临时的Activity用来显示fragment
- 业务Module release模式，那么App Module肯定有装业务Module Fragment的Activity壳，通过Arouter间接获取到业务Module的Fragment，然后在动态显示在Activity壳里。

注意：从debug模式切换到release模式时编译，ARouter的注解处理器可能一时不会生效（注册不了路由），请clean一下工程，再编译。

## 6. 业务模块间事件通信

统一采用RxBus事件总线方案


## 7. 依赖库版本统一处理

项目所用的所有库及版本号（除测试库）统一在根目录下的version.gradle中定义，各module按需对其引用。

例如：BaseLibrary里的

```groovy
...
    compileSdkVersion build_versions.target_sdk
    buildToolsVersion build_versions.build_tools

    defaultConfig {
        minSdkVersion build_versions.min_sdk
        targetSdkVersion build_versions.target_sdk
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
...

dependencies {
    ...
    //rxJava
    api deps.rxjava2
    api deps.rx_android
    api deps.rx_lifecycle
    api deps.rx_lifecycle_components
    api deps.rx_relay
    // net
    api deps.retrofit
    api deps.okhttp3
    api deps.okhttp3_interceptor
    api deps.retrofit_converter_gson
    api deps.retrofti_adapter_rxjava
    ...
```

一些版本号设置
```gradle
build_versions.min_sdk = 19
build_versions.target_sdk = 27
build_versions.build_tools = "27.0.3"
```


## 8. 系统适配

暂时支持设定支持Android系统最低为19（Android4.4）,目标系统版本为27（Android8.1）

不过这个工程应该开发的是固定的车机系统应用，所以系统适配可能不做。

## 9. 编码规范

具体可以参考[编码规范](https://github.com/Blankj/AndroidStandardDevelop/blob/master/README.md),下面只是列了几个重要的。


- 遵循Alibaba编码规范（可配置阿里编码规约插件检查）
- 类注释，方法注释，成员注释，都要写上，注释格式遵循javaDoc
- 编辑完 .java、.xml 等文件后一定要格式化
- 删除多余的 import，减少警告出现，可利用 AS 的 Optimize Imports（Settings -> Keymap -> Optimize Imports）快捷键；

命名规范：
- 代码中的命名严禁使用拼音与英文混合的方式
- 包名全部小写，连续的单词只是简单地连接起来，不使用下划线
- 类名都以 `UpperCamelCase` 风格编写。
- 资源文件命名及里面的控件Id名为全部小写，采用下划线命名法。





