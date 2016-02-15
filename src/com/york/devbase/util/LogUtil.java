/*
 * Copyright (c) 2016 york All rights reserved
 */
package com.york.devbase.util;

import android.util.Log;

import com.york.devbase.commen.Constants;

/**
 * @ClassName: LogUtil
 * @Description: 日志工具类
 * @author york
 * @date 2016-2-1 下午2:49:54
 * 
 */
public class LogUtil {
	public static void d(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void e(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.e(tag, msg);
		}
	}

	public static void i(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.i(tag, msg);
		}
	}

	public static void v(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.v(tag, msg);
		}
	}

	public static void w(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void wtf(final String tag, final String msg) {
		if (Constants.IS_DEBUG) {
			Log.d(tag, msg);
		}
	}

}
