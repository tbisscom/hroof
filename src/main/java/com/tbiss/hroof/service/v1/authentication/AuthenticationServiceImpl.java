package com.tbiss.hroof.service.v1.authentication;


import com.tbiss.hroof.api.v1.mapper.AuthMapper;
import com.tbiss.hroof.api.v1.model.auth.AuthenticationRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.AuthenticationResponseDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterResponseDTO;
import com.tbiss.hroof.config.provider.JwtTokenProvider;
import com.tbiss.hroof.domain.user.Competitor;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.repository.user.CompetitorRepository;
import com.tbiss.hroof.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    AuthenticationManager authenticationManager;

    JwtTokenProvider jwtTokenProvider;

    UserRepository users;

    CompetitorRepository competitorRepository ;

    PasswordEncoder passwordEncoder;

    AuthMapper authMapper ;


    @Autowired
    public void setAuthMapper(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Autowired
    public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Autowired
    public void setUsers(UserRepository users) {
        this.users = users;
    }


    @Autowired
    public void setCompetitorRepository(CompetitorRepository competitorRepository){
        this.competitorRepository = competitorRepository ;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder ;
    }



    @Override
    public AuthenticationResponseDTO signin(AuthenticationRequestDTO data) {

        String email = data.getEmail();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));
        String token = jwtTokenProvider.createToken(email, this.users.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email + "not found")).getRoles());


        AuthenticationResponseDTO authResponse = new AuthenticationResponseDTO();
        authResponse.setEmail(email);
        authResponse.setToken(token);

        return authResponse;
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerDTO) {


        Optional<User> user = users.findByEmail(registerDTO.getEmail());

        if(user.isPresent()){
            throw new UsernameNotFoundException("Email: "+registerDTO.getEmail()+ " is already registered");
        }

        Competitor competitor = new Competitor(registerDTO.getName(),registerDTO.getEmail(),passwordEncoder.encode(registerDTO.getPassword()));

        competitor = competitorRepository.save(competitor);


        return authMapper.competitorToRegisterDTO(competitor);
    }
}
