package com.tbiss.hroof.service.v1.language;

import com.tbiss.hroof.api.v1.model.language.LanguageDTO;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.language.LanguageDirection;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    Optional<LanguageDTO> findLanguageById(Long id);
    List<LanguageDTO> findLanguageByDirection(int page, int offset, LanguageDirection direction);
    List<LanguageDTO> findAll(int page,int offset);
    Optional<Language> findById(Long id);
}
