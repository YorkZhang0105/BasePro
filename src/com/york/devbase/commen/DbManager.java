package com.york.devbase.commen;

import java.util.ArrayList;
import java.util.List;

import com.litesuits.orm.db.assit.QueryBuilder;
import com.york.devbase.App;
import com.york.devbase.util.LogUtil;

/**
 * @ClassName: DbManager
 * @Description: 数据库操作管理者
 * @author york
 * @date 2016-2-15 上午10:17:22
 * 
 */
public class DbManager {
	private static DbManager dbManager;

	/**
	 * 私有构造方法
	 */
	private DbManager() {

	}

	/**
	 * @Title: getInstance
	 * @Description: 对外公开的获取数据库操作管理者实例的单例方法
	 * @param @return 数据库管理者
	 * @return DbManager
	 * @author york
	 */
	public static DbManager getInstance() {
		if (null == dbManager) {
			dbManager = new DbManager();
		}
		return dbManager;
	}

	/**
	 * @Title: insertObj2DB
	 * @Description: 插入单个对象进入数据库
	 * @param @param obj 待插入的对象
	 * @param @param callback 插入操作的回调
	 * @return void
	 * @author york
	 */
	public void insertObj2DB(final Object obj, final DBCallback callback) {
		if (null == callback) {
			return;
		}

		final long save = App.appLiteOrm.save(obj);

		if (-1 != save) {
			callback.onSuccess(null);
		} else {
			callback.onFail();
		}
	}

	/**
	 * @Title: insertList2DB
	 * @Description: 将对象集合插入数据库
	 * @param @param objs 待插入的对象集合
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void insertList2DB(final List<Object> objs, final DBCallback callback) {
		if (null == callback) {
			return;
		}

		final int save = App.appLiteOrm.save(objs);

		if (-1 != save) {
			callback.onSuccess(null);
		} else {
			callback.onFail();
		}
	}

	/**
	 * @Title: deleteObjFromDB
	 * @Description: 将单个对象从数据库内删除
	 * @param @param obj 待删除的对象
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void deleteObjFromDB(final Object obj, final DBCallback callback) {
		if (null == callback) {
			return;
		}

		final int delete = App.appLiteOrm.delete(obj);

		if (-1 != delete) {
			callback.onSuccess(null);
		} else {
			callback.onFail();
		}
	}

	/**
	 * @Title: deleteListFromDB
	 * @Description: 从数据库内删除对象集合
	 * @param @param objs 待删除的对象集合
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void deleteListFromDB(final List<Object> objs,
			final DBCallback callback) {
		if (null == callback) {
			return;
		}

		final int delete = App.appLiteOrm.delete(objs);

		if (-1 != delete) {
			callback.onSuccess(null);
		} else {
			callback.onFail();
		}
	}

	/**
	 * @Title: updateObjFromDB
	 * @Description: 更新数据库内的对象
	 * @param @param obj 待更新的对象
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void updateObjFromDB(final Object obj, final DBCallback callback) {
		if (null == callback) {
			return;
		}

		final int update = App.appLiteOrm.update(obj);

		if (-1 != update) {
			callback.onSuccess(null);
		} else {
			callback.onFail();
		}
	}

	public void updateListFromDB() {

	}

	public void queryObjFromDB() {

	}

	/**
	 * @Title: queryListFromDB
	 * @Description: 从数据内查询出指定对象的集合
	 * @param @param cla 待查询的对象
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void queryListFromDB(final Class<?> cla, final DBCallback callback) {
		if (null == callback) {
			return;
		}
		final long start = System.currentTimeMillis();
		try {
			final ArrayList<?> list = App.appLiteOrm.query(cla);
			if (null == list) {
				callback.onFail();
			} else {
				callback.onSuccess(list);
			}
		} catch (final Exception e) {
			callback.onFail();
			e.printStackTrace();
		}
		final long end = System.currentTimeMillis();
		LogUtil.d("york", "use times===" + (end - start));

	}

	/**
	 * @Title: queryByQueryBuilder
	 * @Description: 条件查询数据
	 * @param @param qb 查询条件
	 * @param @param callback 数据库操作回调
	 * @return void
	 * @author york
	 */
	public void queryByQueryBuilder(final QueryBuilder<?> qb,
			final DBCallback callback) {
		if (callback == null) {
			return;
		}
		try {
			final ArrayList<?> list = App.appLiteOrm.query(qb);
			if (null == list) {
				callback.onFail();
			} else {
				callback.onSuccess(list);
			}
		} catch (final Exception e) {
			callback.onFail();
			e.printStackTrace();
		}

	}

	public void deleteTable(final String tableName) {
		App.appLiteOrm.dropTable(tableName);
	}

	public void deleteTable(final Class<?> cla) {
		App.appLiteOrm.dropTable(cla);
	}

	/**
	 * @ClassName: DBCallback
	 * @Description: 数据库操作回调
	 * @author york
	 * @date 2016-2-15 上午10:25:23
	 * 
	 */
	public interface DBCallback {
		void onSuccess(Object obj);

		void onFail();
	}
}
