package com.tbiss.hroof.controller.v1.competitor;

import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.service.v1.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(QuestionController.RESOURCE_PATH)
@Api(tags = "V1 Question")
public class QuestionController {

    public static final String RESOURCE_PATH = "/v1/competitor/question" ;
    QuestionService questionService ;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @ApiOperation("List Questions")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",required = true,dataType = "int"),
            @ApiImplicitParam(name = "offset",required = true,dataType = "int")
    })
    List<QuestionDTO> getQuestions(@RequestParam(required = true,name = "page") int page,
                                   @RequestParam(required = true,name = "offset") int offset){

        return questionService.findAllQuestions(page,offset);
    }


    @GetMapping("/{id}")
    @ApiOperation("Get Specific Question")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",type = "int",example = "Question Id",required = true,paramType = "path")
    )
    QuestionDTO getQuestion(@PathVariable(name = "id",required = true) Long id){

        Optional<QuestionDTO> question = questionService.findQuestionById(id) ;

        if(question.isPresent()){
            return question.get() ;
        }

        throw new ResponseStatusException( HttpStatus.NOT_FOUND,"Question Not Found");
    }





}
