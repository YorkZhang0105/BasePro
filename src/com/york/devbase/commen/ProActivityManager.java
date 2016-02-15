/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.commen;

import android.app.Activity;

import java.util.LinkedList;

/**
 * Created by york_zhang on 2016/1/20.
 * 项目Activity的管理者（单例实现）
 */
public class ProActivityManager {
	/**Activity管理者的实例（整个项目内只有（共用）一个这样的实例）*/
	private static ProActivityManager mProActivityManager = null;
	/**当前前台显示的activity集合*/
	private final LinkedList<Activity> mActivities;


	/**
	 * 私有的构造方法
	 */
	private ProActivityManager() {
		mActivities = new LinkedList<Activity>();
	}

	/**
	 * 共有静态的实例获取方法
	 *
	 * @return 项目Activity管理者实例
	 */
	public static ProActivityManager getInstance() {

		if (null == mProActivityManager) {
			mProActivityManager = new ProActivityManager();
		}
		return mProActivityManager;
	}

	/**
	 * 获取展示在前台的第一个Activity
	 *
	 * @return 当前展示在前台的第一个Activity
	 */
	public Activity getCurrentShowActivity() {
		Activity activity;
		synchronized (mActivities) {
			activity = mActivities.getLast();
		}
		return activity;
	}

	/**
	 * 将传入的Activity加入进管理队列
	 *
	 * @param activity 待加入管理队列的activity
	 */
	public void addActivity2List(Activity activity) {
		if (null == activity) {
			return;
		}

		mActivities.add(activity);
	}

	/**
	 * 将传入的Activity从管理队列中移除
	 *
	 * @param activity 待移除管理队列的activity
	 */
	public void removeActivityFromList(Activity activity) {
		if (null == activity || mActivities.indexOf(activity) == 0) {
			return;
		}
		if (mActivities.contains(activity)) {
			mActivities.remove(activity);
		}
	}

	/**
	 * 移除管理队列中的所有activity
	 */
	public void closeAllActivity() {
		if (mActivities.size() < 1) {
			return;
		}

		while (mActivities.size() > 0) {
			mActivities.poll().finish();
		}
	}

}
