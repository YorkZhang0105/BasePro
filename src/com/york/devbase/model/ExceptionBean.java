/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.model;

import com.litesuits.orm.db.annotation.Column;
import com.york.devbase.commen.BaseBean;

/**
 * 异常实体Bean Created by york_zhang on 2016/1/21.
 */
@SuppressWarnings("serial")
public class ExceptionBean extends BaseBean {
	@Column("_id")
	/** 数据库标识id */
	private int _id;
	@Column("exceptionDesc")
	/** 异常描述信息 */
	private String exceptionDesc;
	/** 异常发生时间 */
	@Column("time")
	private String time;

	public int get_id() {
		return _id;
	}

	public void set_id(final int _id) {
		this._id = _id;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	public void setExceptionDesc(final String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String time) {
		this.time = time;
	}
}
