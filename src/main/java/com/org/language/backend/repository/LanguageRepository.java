package com.org.language.backend.repository;

import com.org.language.backend.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByLanguageName(String languageName);
    void deleteLanguageByLanguageName(String languageName);
    Boolean existsLanguageByLanguageName(String languageName);
}
