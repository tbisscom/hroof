package com.tbiss.hroof.service.v1.user;

import com.tbiss.hroof.api.v1.mapper.UserMapper;
import com.tbiss.hroof.api.v1.model.user.UserDTO;
import com.tbiss.hroof.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper ;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findUserById(long id) {
        return userRepository.findById(id)
                    .map(userMapper::userToUserDTO)
                    .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        logger.info("loadUserByUsername: "+email);
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email: " + email + " not found"));

    }
}
