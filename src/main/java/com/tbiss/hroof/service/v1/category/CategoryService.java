package com.tbiss.hroof.service.v1.category;

import com.tbiss.hroof.api.v1.model.category.CategoryDTO;
import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.language.Language;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> findAllByLanguage(int page , int offset ,Language language);
    Optional<CategoryDTO> findById(Long id);
    List<CategoryDTO> findAll(int page,int offset);
    Optional<Category> findCategoryById(Long id);

}
