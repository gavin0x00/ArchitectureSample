package me.newtrekwang.baselibrary.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @className PerComponentScope
 * @createDate 2018/7/16 9:11
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc component层级
 *
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerComponentScope {
}
