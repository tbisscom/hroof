package com.tbiss.hroof.service.v1.user.competitor;

import com.tbiss.hroof.api.v1.mapper.UserMapper;
import com.tbiss.hroof.api.v1.model.user.CompetitorPatchDTO;
import com.tbiss.hroof.config.provider.JwtTokenProvider;
import com.tbiss.hroof.domain.user.Competitor;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.repository.user.CompetitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompetitorServiceImpl implements CompetitorService {


    private CompetitorRepository competitorRepository;
    private UserMapper userMapper ;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider ;
    Logger logger = LoggerFactory.getLogger(CompetitorServiceImpl.class);


    @Autowired
    public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Autowired()
    public void setUserRepository(CompetitorRepository userRepository) {
        this.competitorRepository = userRepository;
    }

    @Autowired()
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String update(User userDetails , CompetitorPatchDTO competitorPatchDTO) {

        Optional<Competitor> competitor = competitorRepository.findByEmail(userDetails.getEmail());

        if(competitor.isPresent()){
            Competitor currentCompetitor = competitor.get() ;

            if(competitorPatchDTO.getEmail() != null){


                if(this.isEmailUsed(competitorPatchDTO.getEmail())){
                    throw new UsernameNotFoundException("Email:"+competitorPatchDTO.getEmail()+ "is taken");
                }
                currentCompetitor.setEmail(competitorPatchDTO.getEmail());

            }

            if(competitorPatchDTO.getPassword() != null){
                currentCompetitor.setPassword(passwordEncoder.encode(competitorPatchDTO.getPassword()));
            }

            if(competitorPatchDTO.getName() != null){
                currentCompetitor.setName(competitorPatchDTO.getName());
            }

            competitorRepository.save(currentCompetitor);

            String token = jwtTokenProvider.createToken(currentCompetitor.getEmail(), this.competitorRepository.findByEmail(currentCompetitor.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Email " + currentCompetitor.getEmail() + "not found")).getRoles());


            return token ;
        }else{
            throw new UsernameNotFoundException("not found resource");
        }

    }



    private boolean isEmailUsed(String email){
        return this.competitorRepository.findByEmail(email).isPresent()  ;
    }
}
