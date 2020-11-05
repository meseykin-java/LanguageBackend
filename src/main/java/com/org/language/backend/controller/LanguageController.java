package com.org.language.backend.controller;

import com.org.language.backend.model.Language;
import com.org.language.backend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(value = "/language")
    public ResponseEntity<Language> create(@RequestBody Language language) {
        languageService.create(language);
        return new ResponseEntity<>(language, HttpStatus.CREATED);
    }

    @GetMapping(value = "/language")
    public ResponseEntity<List<Language>> read() {
        final List<Language> languages = languageService.readAll();

        return languages != null &&  !languages.isEmpty()
                ? new ResponseEntity<>(languages, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/language/{name}")
    public ResponseEntity<Language> read(@PathVariable(value="name") String name) {
        final Language language = languageService.read(name);

        return language != null
                ? new ResponseEntity<>(language, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/language/{name}")
    public ResponseEntity<Language> update(@PathVariable(name = "name") String name, @RequestBody Language language) {
        final boolean updated = languageService.update(language, name);

        return updated
                ? new ResponseEntity<>(language, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/language/{name}")
    public ResponseEntity<?> delete(@PathVariable(name = "name") String name) {
        final boolean deleted = languageService.delete(name);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
