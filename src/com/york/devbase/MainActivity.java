package com.york.devbase;

import java.util.ArrayList;

import android.os.Bundle;

import com.litesuits.orm.LiteOrm;
import com.york.devbase.commen.BaseActivity;
import com.york.devbase.commen.DbManager;
import com.york.devbase.commen.DbManager.DBCallback;
import com.york.devbase.commen.SqlCommen;
import com.york.devbase.model.Info;

public class MainActivity extends BaseActivity {
	/**
	 * 数据库操作索引
	 */
	private LiteOrm mLiteOrm;
	private Info mInfo;
	private Info testInfo;
	private ArrayList<Info> mInfos;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testDB();
	}

	// =====================================================测试数据库操作start=========================================================

	/**
	 * 初始化数据库相关数据
	 */
	private void initDBData() {
		int index = 1;
		boolean flag = false;
		mInfo = new Info(1, "冷死了", "求不装逼", "http://www.baidu.com",
				System.currentTimeMillis(), System.currentTimeMillis(), true);
		testInfo = new Info(100, "测试", "测试数据", "http://www.google.cn",
				System.currentTimeMillis(), System.currentTimeMillis(), false);
		mInfos = new ArrayList<Info>();
		mInfos.add(mInfo);
		while (index < 100000) {
			index++;
			if (index / 2 == 0) {
				flag = false;
			} else {
				flag = true;
			}
			mInfos.add(new Info(index, "冷死了" + index, "求不装逼" + index,
					"http://www.baidu.com/" + index,
					System.currentTimeMillis(), System.currentTimeMillis(),
					flag));
		}
	}

	/**
	 * 测试DB操作
	 */
	private void testDB() {
		initDbAbout();
		initDBData();
		final DbManager manager = DbManager.getInstance();
		manager.insertObj2DB(mInfo, new DBCallback() {

			@Override
			public void onSuccess(final Object obj) {

			}

			@Override
			public void onFail() {

			}
		});
	}

	// =====================================================测试数据库操作end=========================================================

	/**
	 * 初始化DB相关
	 */
	private void initDbAbout() {
		if (null == mLiteOrm) {
			mLiteOrm = LiteOrm.newCascadeInstance(this, SqlCommen.DB_NAME);
		}
		mLiteOrm.setDebugged(true);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		/*
		 * if (null != mLiteOrm) { mLiteOrm.close(); }
		 */
	}
}
