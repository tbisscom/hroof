package com.tbiss.hroof.api.v1.model.question;

import com.tbiss.hroof.api.v1.model.answer.AnswerDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private Long id;

    private String name ;

    private List<AnswerDTO> answers ;
}
