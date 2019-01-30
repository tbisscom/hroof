package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.answer.AnswerDTO;
import com.tbiss.hroof.domain.question.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO answerToAnswerDTO(Answer answer);
}
