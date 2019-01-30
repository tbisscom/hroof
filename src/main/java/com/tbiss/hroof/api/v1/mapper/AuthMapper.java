package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.auth.RegisterResponseDTO;
import com.tbiss.hroof.domain.user.Competitor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper( AuthMapper.class );

    RegisterResponseDTO competitorToRegisterDTO(Competitor competitor);

}
