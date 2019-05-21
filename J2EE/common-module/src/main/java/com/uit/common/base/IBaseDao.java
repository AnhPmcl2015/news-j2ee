package com.uit.common.base;

public interface IBaseDao<T> {
	T findById(Integer id);
	public void insertOrUpdate(T t);
	public void delete(T t);
	public long count();
}
