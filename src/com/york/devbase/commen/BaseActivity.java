/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.commen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.york.devbase.App;
import com.york.devbase.R;
import com.york.devbase.helper.ApplicationHelper;

/**
 * 整个项目的Actiivty的基类（项目内的所有Activity都继承该Activity） Created by york_zhang on
 * 2016/1/20.
 */
public class BaseActivity extends Activity {
	/** 标题栏 */
	public RelativeLayout _base_title_bar;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ProActivityManager.getInstance().addActivity2List(this);
	}

	@Override
	public void setContentView(final int layoutResID) {
		final LinearLayout view = (LinearLayout) getLayoutInflater().inflate(
				R.layout.base_view, null);
		_base_title_bar = (RelativeLayout) view
				.findViewById(R.id.base_title_bar);
		super.setContentView(layoutResID);
		final View layView = getLayoutInflater().inflate(layoutResID, null);
		final LayoutParams layoutParams = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		view.addView(layView, layoutParams);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!App.isAppActive) {
			// app从后台唤醒，进入前台
			App.isAppActive = true;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (!ApplicationHelper.isAppOnForeground(this)) {
			// app进入后台
			App.isAppActive = false;
		}
	}

	@Override
	protected void onActivityResult(final int requestCode,
			final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		App.isAppActive = true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ProActivityManager.getInstance().removeActivityFromList(this);
	}
}
