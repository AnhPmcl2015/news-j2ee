package com.uit.common.base;

public interface IDtoToEntity<E,D> {
	void convertDtosToEntity(E entity, D dto);
}
