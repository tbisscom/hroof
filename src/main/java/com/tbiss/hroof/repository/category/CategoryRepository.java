package com.tbiss.hroof.repository.category;

import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.language.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends PagingAndSortingRepository<Category,Long> {

    Page<Category> findAllByLanguage(Language language, Pageable pageable);
}
