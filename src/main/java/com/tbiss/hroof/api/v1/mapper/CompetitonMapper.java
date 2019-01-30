package com.tbiss.hroof.api.v1.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CompetitonMapper {

    CompetitonMapper INSTANCE = Mappers.getMapper( CompetitonMapper.class );

}
