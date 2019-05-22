package com.uit.common.base;

public interface IBaseBus<T> {
	void insertOrUpdate(T t);
	void delete(T t);
}
