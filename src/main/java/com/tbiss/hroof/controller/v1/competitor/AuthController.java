package com.tbiss.hroof.controller.v1.competitor;


import com.tbiss.hroof.api.v1.model.auth.AuthenticationRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.AuthenticationResponseDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterResponseDTO;
import com.tbiss.hroof.service.v1.authentication.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthController.RESOURCE_PATH)
@Api(tags = "V1 Authentication")
public class AuthController {
    public static final String RESOURCE_PATH = "/v1/competitor/auth";




    private AuthenticationService authenticationService ;


    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @ApiOperation(("Register new Competitor"))
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO registerRequestDTO){

        try{

            return  authenticationService.register(registerRequestDTO);
        }catch (AuthenticationException exception){
            throw new BadCredentialsException(exception.getMessage());
        }
    }

    @PostMapping("/signin")
    @ApiOperation(("Signin - Authentication"))
    public AuthenticationResponseDTO signin(@RequestBody AuthenticationRequestDTO data) {

        try {

            AuthenticationResponseDTO model = authenticationService.signin(data);

            return model;
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }





}
