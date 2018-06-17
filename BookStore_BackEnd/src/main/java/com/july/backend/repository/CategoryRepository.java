package com.july.backend.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.july.backend.models.Category;


public interface CategoryRepository extends Repository<Category, Integer>{
	List<Category> listCategory();
}
