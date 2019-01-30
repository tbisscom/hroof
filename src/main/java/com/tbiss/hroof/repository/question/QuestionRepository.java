package com.tbiss.hroof.repository.question;

import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.question.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question,Long> {
    List<Question> findByCategory(Category category, Pageable pageable);
}
