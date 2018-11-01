package com.samrt.qiushi.icecream.utils;

import android.util.Log;

public class LogUtil {
    //日志开关，在应用测试完毕发布版本之前要置为false
   private static boolean isDebug = true;

    public static void i(String tag, String msg){
        if(isDebug){
            Log.i(tag, msg+"");
        }
    }

    public static void d(String tag, String msg){
        if(isDebug){
            Log.d(tag, msg+"");
        }
    }

    public static void e(String tag, String msg){
        if(isDebug){
            Log.e(tag, msg);
        }
    }

    public static void d(Object obj, String msg){
        if(isDebug){
            Log.d(obj.getClass().getSimpleName(), msg);
        }
    }

    public static void e(Object obj, String msg){
        if(isDebug){
            Log.e(obj.getClass().getSimpleName(), msg);
        }
    }
}
