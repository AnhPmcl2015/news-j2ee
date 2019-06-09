package com.uit.common.base;

import java.util.List;

public interface IBaseDao<T> {
	T findById(Integer id);
	public void insertOrUpdate(T t);
	public void delete(T t);
	public long count();
	List<T> findAll();
}
