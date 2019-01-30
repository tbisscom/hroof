package com.tbiss.hroof.service.v1.question;

import com.tbiss.hroof.api.v1.mapper.AnswerMapper;
import com.tbiss.hroof.api.v1.mapper.QuestionMapper;
import com.tbiss.hroof.api.v1.model.answer.AnswerDTO;
import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.repository.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {


    QuestionRepository questionRepository ;
    QuestionMapper questionMapper ;
    AnswerMapper answerMapper ;


    @Autowired
    public void setAnswerMapper(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionDTO> findQuestionByCategory(int page, int offset, Category category) {

        Pageable pageable = PageRequest.of(page,offset);
        return questionRepository.findByCategory(category,pageable)
                .stream()
                .map(questionMapper::questionToQuestionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDTO> findAllQuestions(int page, int offset) {
        Pageable pageable = PageRequest.of(page,offset);

        return questionRepository.findAll(pageable)
                .stream()
                .map(question -> {

                    List<AnswerDTO> answers = question.getAnswers()
                                                .stream()
                                                .map(answerMapper::answerToAnswerDTO)
                                                .collect(Collectors.toList());

                    QuestionDTO questionDTO =  questionMapper.questionToQuestionDTO(question);

                    questionDTO.setAnswers(answers);

                    return questionDTO ;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDTO> findQuestionById(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::questionToQuestionDTO);
    }


}
