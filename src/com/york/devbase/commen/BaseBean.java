/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.commen;

import java.io.Serializable;
import java.lang.reflect.Field;

import android.text.TextUtils;

/**
 * 实体基类（建议项目所有实体Bean继承该基类）[该基类主要实现了序列化接口，复写了toString（）方法] Created by york_zhang
 * on 2016/1/21.
 */
@SuppressWarnings("serial")
public class BaseBean implements Serializable {
	/** 序列化id */
	public static final Long serialVersionUID = -1148312504867461812L;

	/**
	 * 复写toString（）方法，实现对对象的名称和值进行字符串拼接
	 * 
	 * @return
	 */
	@Override
	public String toString() {

		final String fieldNameAndValue = getFieldNameAndValue(this);
		if (TextUtils.isEmpty(fieldNameAndValue)) {
			return super.toString();
		}

		return fieldNameAndValue;
	}

	/**
	 * 得到对象的属性名称和属性的值
	 * 
	 * @param object
	 *            待处理的对象
	 * @return 属性名称与属性值拼接成的字符串
	 */
	private String getFieldNameAndValue(final Object object) {
		if (null == object) {
			return null;
		}
		/**
		 * 利用反射技术完成对象属性的输出
		 */
		final Class<?> c = object.getClass();
		final Field[] fields = c.getDeclaredFields();
		final StringBuilder strBuilder = new StringBuilder("\n");
		for (final Field field : fields) {
			field.setAccessible(true);
			final String fieldStr = field.toString();
			// 得到属性名称
			final String fieldName = fieldStr.substring(fieldStr
					.lastIndexOf(".") + 1);
			try {
				strBuilder
						.append(fieldName + ":" + field.get(object) + "&&&&&");
			} catch (final IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return strBuilder.toString();
	}
}
