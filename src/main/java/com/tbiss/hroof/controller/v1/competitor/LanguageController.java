package com.tbiss.hroof.controller.v1.competitor;

import com.tbiss.hroof.api.v1.model.category.CategoryDTO;
import com.tbiss.hroof.api.v1.model.language.LanguageDTO;
import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.language.LanguageDirection;
import com.tbiss.hroof.service.v1.category.CategoryService;
import com.tbiss.hroof.service.v1.language.LanguageService;
import com.tbiss.hroof.service.v1.question.QuestionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(LanguageController.RESOURCE_PATH)
@Api(tags = "V1 Language")
public class LanguageController {

    public static final String RESOURCE_PATH = "/v1/competitor/language";

    LanguageService languageService ;
    CategoryService categoryService ;
    QuestionService questionService ;

    @Autowired
    public LanguageController(LanguageService languageService, CategoryService categoryService,QuestionService questionService) {
        this.languageService = languageService;
        this.categoryService = categoryService;
        this.questionService = questionService ;
    }


    @GetMapping()
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page" ,required = true,dataType = "int"),
                    @ApiImplicitParam(name = "offset",required = true,dataType = "int"),
                    @ApiImplicitParam(name = "direction",required = false,dataTypeClass = LanguageDirection.class)
            })
    @ApiOperation("List all languages")
    public List<LanguageDTO> getLanguages(@RequestParam(name = "page" ,required = true) int page ,
                                          @RequestParam(name = "offset",required = true) int offset,
                                          @RequestParam(name = "direction",required = false)LanguageDirection direction){

        if(direction != null){
            return languageService.findLanguageByDirection(page,offset,direction);
        }
        else{
            return languageService.findAll(page,offset);
        }
    }


    @GetMapping("/{id}")
    @ApiOperation("Get Specific Language")
    public LanguageDTO getLanguage(@ApiParam(name = "id",allowEmptyValue = false,type = "int") @PathVariable(name = "id",required = true)Optional<Long> id){

        Optional<LanguageDTO> language = languageService.findLanguageById(id.get()) ;

        if(language.isPresent()){
            return language.get() ;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Language Not Found");
    }


    @GetMapping("/{languageId}/category")
    @ApiOperation("Get Categories for specific Language")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",required = true,dataType = "int"),
            @ApiImplicitParam(name = "offset",required = true,dataType = "int"),
            @ApiImplicitParam(name = "languageId",paramType = "path",dataType = "int",required = true)
    })
    public List<CategoryDTO> getCategories(@PathVariable(name = "languageId",required = true) Optional<Long> id,
                                           @RequestParam(name = "page" ,required = true) int page ,
                                           @RequestParam(name = "offset",required = true) int offset){

        Optional<Language> language = languageService.findById(id.get()) ;

        if(language.isPresent()){
            return categoryService.findAllByLanguage(page,offset,language.get());
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Language Not Found");
    }



}
