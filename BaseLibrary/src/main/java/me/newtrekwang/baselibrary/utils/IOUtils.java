package me.newtrekwang.baselibrary.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @className IOUtils
 * @createDate 2018/7/15 23:39
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc IO工具类
 *
 */
public final class IOUtils {
    /**
     * 关闭流
     * @param closeables
     */
    public static void closeAll(Closeable... closeables){
       for(Closeable closeable : closeables){
           try {
               closeable.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
