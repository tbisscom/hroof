package com.tbiss.hroof.service.v1.authentication;

import com.tbiss.hroof.api.v1.model.auth.AuthenticationRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.AuthenticationResponseDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterRequestDTO;
import com.tbiss.hroof.api.v1.model.auth.RegisterResponseDTO;

public interface AuthenticationService {

   AuthenticationResponseDTO signin(AuthenticationRequestDTO authenticationRequestDTO);

   RegisterResponseDTO register(RegisterRequestDTO registerDTO);
}
