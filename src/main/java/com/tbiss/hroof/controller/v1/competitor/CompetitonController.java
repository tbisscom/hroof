package com.tbiss.hroof.controller.v1.competitor;

import com.tbiss.hroof.api.v1.model.competition.CompetitionCreateDTO;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.service.v1.category.CategoryService;
import com.tbiss.hroof.service.v1.language.LanguageService;
import com.tbiss.hroof.service.v1.question.QuestionService;
import com.tbiss.hroof.service.v1.user.competitor.CompetitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping()
public class CompetitonController
{
    public static final String RESOURCE_PATH = "/v1/competitor/competition";
    Logger logger = LoggerFactory.getLogger(CategoryController.class);


    CategoryService categoryService ;
    QuestionService questionService;
    CompetitorService competitorService ;
    LanguageService languageService ;


    public CompetitonController(CategoryService categoryService, QuestionService questionService, CompetitorService competitorService) {
        this.categoryService = categoryService;
        this.questionService = questionService;
        this.competitorService = competitorService;
    }




    @PostMapping()
    public CompetitionCreateDTO createCompetition(@ApiIgnore() Authentication authentication,
                                                  @ApiIgnore() @RequestHeader("Content-Language") String languageCode){


        User user =  (User) authentication.getPrincipal() ;


        //Check if the current player joined another competition and throw exception
        //check if there's no another competition waiting for someone
        //

        return null ;
    }
}
