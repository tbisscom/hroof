package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.category.CategoryDTO;
import com.tbiss.hroof.domain.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    CategoryDTO categoryToCategoryDTO(Category category);
}
