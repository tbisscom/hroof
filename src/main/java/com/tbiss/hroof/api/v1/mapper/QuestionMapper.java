package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.domain.question.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class );
    QuestionDTO questionToQuestionDTO(Question question);

}
