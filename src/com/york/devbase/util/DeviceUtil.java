/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.util;

import android.os.Build;

/**
 * 设备相关工具类 Created by york_zhang on 2016/1/21.
 */
public class DeviceUtil {
	/** 分隔符 */
	private static final String DIVIDER = "----";

	/**
	 * 获取简单的设备信息
	 * 
	 * @return 设备信息串
	 */
	public static String getSimpleMachineInfo() {
		final String osVer = "osVer:" + Build.VERSION.RELEASE;
		final String vendor = "vendor:" + Build.MANUFACTURER;
		final String model = "model:" + Build.MODEL;
		final StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(osVer).append(DIVIDER);
		strBuilder.append(vendor).append(DIVIDER);
		strBuilder.append(model).append(DIVIDER);
		return strBuilder.toString();
	}
}
