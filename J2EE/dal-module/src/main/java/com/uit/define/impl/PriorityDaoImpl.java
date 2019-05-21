package com.uit.define.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uit.define.IPriorityDao;
import com.uit.entity.Priority;
import com.uit.repository.PriorityRepository;

@Repository
public class PriorityDaoImpl implements IPriorityDao {
	
	@Autowired private PriorityRepository priorityRepository;

	@Override
	public Priority findById(Integer id) {
		
		Optional<Priority> priorityOpt = this.priorityRepository.findById(id);
		
		if(priorityOpt.isPresent()) {
			return priorityOpt.get();
		}
		return null;
	}

	@Override
	public void insertOrUpdate(Priority entity) {
		this.priorityRepository.saveAndFlush(entity);
	}

	@Override
	public void delete(Priority entity) {
		this.priorityRepository.delete(entity);
	}

	@Override
	public long count() {
		return this.priorityRepository.count();
	}

}
