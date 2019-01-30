package com.tbiss.hroof.controller.v1.competitor;


import com.tbiss.hroof.api.v1.model.category.CategoryDTO;
import com.tbiss.hroof.api.v1.model.question.QuestionDTO;
import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.service.v1.category.CategoryService;
import com.tbiss.hroof.service.v1.language.LanguageService;
import com.tbiss.hroof.service.v1.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(CategoryController.RESOURCE_PATH)
@Api(tags = "V1 Category")
public class CategoryController {

    public static final String RESOURCE_PATH = "/v1/competitor/category";
    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    LanguageService languageService ;
    CategoryService categoryService;
    QuestionService questionService ;

    @Autowired
    public CategoryController(LanguageService languageService, CategoryService categoryService,QuestionService questionService) {
        this.languageService = languageService;
        this.categoryService = categoryService;
        this.questionService = questionService ;
    }


    @GetMapping()
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page" , required = true,type = "int",paramType = "query"),
            @ApiImplicitParam(name = "offset",required = true,type = "int",paramType = "query")})
    @ApiOperation("Read All Categories")
    public List<CategoryDTO> getCategories(
            @RequestParam(name = "page",required = true)  int page ,
            @RequestParam(name = "offset",required = true) int offset,
            @ApiIgnore() Authentication authentication
    ){

        logger.info(authentication.getName());
        User userDetails = (User) authentication.getPrincipal();

        logger.info(userDetails.getEmail());

        return categoryService.findAll(page,offset) ;
    }


    @GetMapping("/{id}")
    @ApiImplicitParam(name = "id",required = true,type = "int",paramType = "param")
    @ApiOperation("Read Specific Category")
    public CategoryDTO getCategory(@PathVariable(name = "id",required = true)Optional<Long> id){

        Optional<CategoryDTO> category = categoryService.findById(id.get()) ;


        if(category.isPresent()){
            return category.get() ;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Category Not Not Found");

    }



    @GetMapping("/{categoryId}/questions")
    @ApiOperation("Get Questions for specific Category")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",required = true,dataType = "int"),
            @ApiImplicitParam(name = "offset",required = true,dataType = "int"),
            @ApiImplicitParam(name = "categoryId",paramType = "path",dataType = "long",required = true)
    })
    public List<QuestionDTO> getQuestions(@PathVariable(name = "categoryId",required = true) Optional<Long> categoryId,
                                          @RequestParam(name = "page" ,required = true) int page ,
                                          @RequestParam(name = "offset",required = true) int offset){



            Optional<Category> category = categoryService.findCategoryById(categoryId.get());

            if(category.isPresent()){
                List<QuestionDTO> questions = questionService.findQuestionByCategory(page,offset,category.get());

                return questions ;
            }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Category Not Found");
    }

}
