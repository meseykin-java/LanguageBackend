package com.org.language.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "T_LANGUAGE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long languageId;

    @Column(name = "f_name")
    @Pattern(regexp = "^(Java|C#|JavaScript|C++|Python)$", message = "not valid language name")
    protected String languageName;

    @Column(name = "f_description")
    protected String languageDescription;

    @Column(name = "f_rating")
    @Min(value = 1, message = "rating should not be less than 1")
    @Max(value = 5, message = "rating should not be greater than 5")
    protected Integer languageRating;

    public long getLanguageId() {
        return languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getLanguageDescription() {
        return languageDescription;
    }

    public Integer getlanguageRating() {
        return languageRating;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setLanguageDescription(String languageDescription) {
        this.languageDescription = languageDescription;
    }

    public void setLanguageRating(Integer languageRating) {
        this.languageRating = languageRating;
    }
}
