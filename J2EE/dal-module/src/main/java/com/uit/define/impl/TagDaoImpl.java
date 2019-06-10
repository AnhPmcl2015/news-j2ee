package com.uit.define.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uit.define.ITagDao;
import com.uit.entity.Tag;
import com.uit.repository.TagRepository;

@Repository
public class TagDaoImpl implements ITagDao{


	@Autowired private TagRepository tagRepository;
	
	@Override
	public Tag findById(Integer id) {
		Optional<Tag> tagOpt = tagRepository.findById(id);
		
		if(tagOpt.isPresent()) {
			return tagOpt.get();
		}
		return null;
	}

	@Override
	public void insertOrUpdate(Tag tag) {
		this.tagRepository.saveAndFlush(tag);
	}

	@Override
	public void delete(Tag tag) {
		this.tagRepository.delete(tag);
	}

	@Override
	public long count() {
		return this.tagRepository.count();
	}

	@Override
	public List<Tag> findAll() {
		return this.tagRepository.findAll();
	}

	@Override
	public Tag getTagByUrl(String url) {
		
		Optional<Tag> tagOpt = this.tagRepository.findByUrl(url);
		
		if(tagOpt.isPresent()) {
			return tagOpt.get();
		}
		return null;
	}
	
}
