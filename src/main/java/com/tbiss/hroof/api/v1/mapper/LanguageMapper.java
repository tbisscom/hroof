package com.tbiss.hroof.api.v1.mapper;

import com.tbiss.hroof.api.v1.model.language.LanguageDTO;
import com.tbiss.hroof.domain.language.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface LanguageMapper {


    LanguageMapper INSTANCE = Mappers.getMapper( LanguageMapper.class );


    LanguageDTO languageToLanguageDTO(Language language);

}
