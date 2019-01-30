package com.tbiss.hroof.service.v1.language;

import com.tbiss.hroof.api.v1.mapper.LanguageMapper;
import com.tbiss.hroof.api.v1.model.language.LanguageDTO;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.language.LanguageDirection;
import com.tbiss.hroof.repository.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository ;

    private LanguageMapper languageMapper ;


    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Autowired
    public void setLanguageMapper(LanguageMapper languageMapper) {
        this.languageMapper = languageMapper;
    }

    @Override
    public Optional<LanguageDTO> findLanguageById(Long id) {
        return languageRepository.findById(id)
                .map(languageMapper::languageToLanguageDTO)
                ;
    }

    @Override
    public List<LanguageDTO> findLanguageByDirection(int page, int offset, LanguageDirection direction) {

        Pageable pageable = PageRequest.of(page,offset);

        return languageRepository.findAllByDirection(direction,pageable)
                    .stream()
                    .map(languageMapper::languageToLanguageDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public List<LanguageDTO> findAll(int page, int offset) {
        Pageable pageable = PageRequest.of(page,offset);


        return languageRepository.findAll(pageable)
                .stream()
                .map(languageMapper::languageToLanguageDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Language> findById(Long id) {
        return languageRepository.findById(id);
    }
}
