/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase;

import java.util.ArrayList;

import android.app.Application;

import com.litesuits.orm.LiteOrm;
import com.york.devbase.commen.ProExceptionHandler;
import com.york.devbase.commen.SqlCommen;
import com.york.devbase.model.ExceptionBean;

/**
 * 项目的application类 Created by york_zhang on 2016/1/21.
 */
public class App extends Application {

	/** Aplication实例索引 */
	public static App context;
	/** 程序是否出于前台标志位 */
	public static boolean isAppActive;
	/** 全局的数据操作索引 */
	public static LiteOrm appLiteOrm;

	@Override
	public void onCreate() {
		super.onCreate();
		/* 初始化全局异常监听 */
		ProExceptionHandler.getInstance().init();
		initDbAbout();
		final ArrayList<ExceptionBean> exceptions = appLiteOrm
				.query(ExceptionBean.class);
		// TODO 将数据库内的异常传入后台
		// TODO 清空异常数据库
	}

	/**
	 * 初始化DB相关
	 */
	private void initDbAbout() {
		if (null == appLiteOrm) {
			appLiteOrm = LiteOrm.newCascadeInstance(this, SqlCommen.DB_NAME);
		}
		appLiteOrm.setDebugged(true);
	}

}
