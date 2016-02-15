/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.helper;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Application的帮助类
 * Created by york_zhang on 2016/1/21.
 */
public class ApplicationHelper {
	/**
	 * 判断程序是否在前台运行
	 * @param context
	 * @return
	 */
	public static boolean isAppOnForeground(Context context) {
		ActivityManager manager = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
		String packageName = context.getApplicationContext().getPackageName();
		List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = manager.getRunningAppProcesses();

		if (null == runningAppProcesses) {
			return false;
		}

		for (ActivityManager.RunningAppProcessInfo info : runningAppProcesses) {
			if (info.processName.equals(packageName)&&info.importance== ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND){
				return true;
			}
		}

		return false;
	}
}
