package com.org.language.backend.service;

import com.org.language.backend.model.Language;
import com.org.language.backend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;


    // Переменная для генерации ID книги
    private static final AtomicInteger BOOK_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Language language) {
        final long languageId = BOOK_ID_HOLDER.incrementAndGet();
        language.setLanguageId(languageId);
        languageRepository.save(language);
    }

    @Override
    public List<Language> readAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language read(long id) {
        return languageRepository.getOne(id);
    }

    @Override
    public Language read(String name) {
        return languageRepository.findByLanguageName(name);
    }

    @Override
    public boolean update(Language language, String name) {
        if (languageRepository.existsLanguageByLanguageName(name)) {
            language.setLanguageName(name);
            languageRepository.save(language);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String name) {
        if (languageRepository.existsLanguageByLanguageName(name)) {
            languageRepository.deleteLanguageByLanguageName(name);
            return true;
        }
        return false;
    }
}
