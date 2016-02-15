/*
 * Copyright (c) 2016 york All rights reserved
 */

package com.york.devbase.model;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.york.devbase.commen.BaseBean;
import com.york.devbase.commen.SqlCommen;

/**
 * Info实体Bean Created by york_zhang on 2016/1/22.
 */
@SuppressWarnings("serial")
@Table(SqlCommen.TB_INFO)
public class Info extends BaseBean {
	// 指定字段在数据库内的列名
	@Column("_id")
	// 指定为主键，自增长
	@PrimaryKey(AssignType.AUTO_INCREMENT)
	/**数据库内存储的数据id*/
	private int _id;
	@Column("id")
	/**数据id*/
	private int id;
	@Column("title")
	/**信息标题*/
	private String title;
	@Column("subTitle")
	/**信息的副标题*/
	private String subTitle;
	@Column("imgUrl")
	/**信息缩略图路径*/
	private String imgUrl;
	@Ignore
	/**信息的创建时间*/
	private long createTime;
	@Column("updateTime")
	/**信息的更新时间*/
	private long updateTime;
	@Column("isTop")
	/**是否置顶*/
	private boolean isTop;

	public Info(final int id, final String title, final String subTitle,
			final String imgUrl, final long createTime, final long updateTime,
			final boolean isTop) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.imgUrl = imgUrl;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isTop = isTop;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(final int _id) {
		this._id = _id;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(final String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(final String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(final long createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(final long updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setIsTop(final boolean isTop) {
		this.isTop = isTop;
	}
}
