/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.commen;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.litesuits.orm.LiteOrm;
import com.york.devbase.App;
import com.york.devbase.model.ExceptionBean;

/**
 * 未被捕获的全局异常监听者（管理项目全局异常）[单例实现] Created by york_zhang on 2016/1/21.
 */
public class ProExceptionHandler implements Thread.UncaughtExceptionHandler {
	/** 未被捕获的全局异常监听者实例 */
	private static ProExceptionHandler sProExceptionHandler;
	/** 实际的异常的处理者 */
	private Thread.UncaughtExceptionHandler mProUncaughtExceptionHandler;

	/**
	 * 私有构造方法
	 */
	private ProExceptionHandler() {
	}

	/**
	 * 静态公有的获取全局异常监听者单例实例方法(只能通过该方法获取实例)
	 * 
	 * @return
	 */
	public static ProExceptionHandler getInstance() {
		if (null == sProExceptionHandler) {
			sProExceptionHandler = new ProExceptionHandler();
		}
		return sProExceptionHandler;
	}

	/**
	 * 初始化
	 */
	public void init() {
		/**
		 * 将当前类设置为项目的默认异常处理者，以便由该类处理全局异常
		 */
		mProUncaughtExceptionHandler = Thread
				.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 异常发生时该方法会被执行
	 * 
	 * @param thread
	 * @param throwable
	 */
	@Override
	public void uncaughtException(final Thread thread, final Throwable throwable) {
		final ExceptionBean exceptionBean = new ExceptionBean();
		exceptionBean.setExceptionDesc(getExceptionInfo(throwable));
		exceptionBean.setTime(String.valueOf(System.currentTimeMillis()));
		// TODO 将异常插入数据库
		final LiteOrm liteOrm = LiteOrm.newCascadeInstance(App.context,
				SqlCommen.DB_NAME);
		liteOrm.insert(exceptionBean);
		if (null != mProUncaughtExceptionHandler) {
			mProUncaughtExceptionHandler.uncaughtException(thread, throwable);
		} else {
			ProActivityManager.getInstance().closeAllActivity();
		}

	}

	/**
	 * 根据Throwable，返回异常字符串
	 * 
	 * @param exception
	 *            异常信息
	 * @return 异常字符串
	 */
	private String getExceptionInfo(final Throwable exception) {
		final Writer info = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(info);
		exception.printStackTrace(printWriter);
		final String dum = info.toString();
		printWriter.close();
		return dum;
	}

}
