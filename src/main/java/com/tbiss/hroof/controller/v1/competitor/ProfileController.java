package com.tbiss.hroof.controller.v1.competitor;


import com.tbiss.hroof.api.v1.model.user.CompetitorPatchDTO;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.service.v1.user.competitor.CompetitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(ProfileController.RESOURCE_PATH)
@Api(tags = "V1 Authentication")
public class ProfileController {

    public static final String RESOURCE_PATH = "/v1/competitor/profile";
    Logger logger = LoggerFactory.getLogger(ProfileController.class);


    private CompetitorService competitorService ;

    public ProfileController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }


    @PatchMapping()
    @ApiImplicitParam(name = "id",required = true,type = "int",paramType = "param")
    @ApiOperation("Patch Specific Competitor")
    public Map<String,Object> update(@RequestBody CompetitorPatchDTO competitorPatchDTO, Authentication authentication
    ){
        User userDetails = (User) authentication.getPrincipal();


        logger.info(userDetails.getEmail());
        try{
           String token =  competitorService.update(userDetails,competitorPatchDTO);


            Map<String,Object> model = new HashMap<>();
            model.put("token",token);
            return model;
        }catch (AuthenticationException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }


    }

}
