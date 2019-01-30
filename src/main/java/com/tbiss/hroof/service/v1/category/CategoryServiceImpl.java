package com.tbiss.hroof.service.v1.category;

import com.tbiss.hroof.api.v1.mapper.CategoryMapper;
import com.tbiss.hroof.api.v1.model.category.CategoryDTO;
import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.repository.category.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper ;

    private CategoryRepository categoryRepository ;

    Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);



    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> findAllByLanguage(int page , int offset ,Language language) {
        Pageable pageable = PageRequest.of(page,offset);


        return categoryRepository.findAllByLanguage(language,pageable)
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::categoryToCategoryDTO);
    }

    @Override
    public List<CategoryDTO> findAll(int page, int offset) {
        Pageable pageable = PageRequest.of(page,offset);

        return categoryRepository.findAll(pageable)
                .stream()
                .map(category -> {

                    logger.info(category.getName());
                    logger.info(String.valueOf(category.getId()));

                    CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);


                    return categoryDTO ;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
