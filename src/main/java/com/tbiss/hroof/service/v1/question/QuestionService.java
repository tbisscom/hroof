package com.tbiss.hroof.service.v1.question;

import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.domain.category.Category;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDTO> findQuestionByCategory(int page, int offset, Category category);
    List<QuestionDTO> findAllQuestions(int page,int offset);
    Optional<QuestionDTO> findQuestionById(Long id);
}
