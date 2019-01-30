package com.tbiss.hroof.repository.language;

import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.language.LanguageDirection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language,Long> {

    List<Language> findAllByDirection(LanguageDirection direction, Pageable pageable);
}
