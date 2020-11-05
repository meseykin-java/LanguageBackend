package com.org.language.backend.service;

import com.org.language.backend.model.Language;

import java.util.List;

public interface LanguageService {

    /**
     * Создает новый язык
     * @param language - книга для создания
     */
    void create(Language language);


    /**
     * Возвращает список всех имеющихся языков
     * @return список языков
     */
    List<Language> readAll();


    /**
     * Возвращает язык по его ID
     * @param id - ID языка
     * @return - объект языка с заданным ID
     */
    Language read(long id);


    /**
     * Возвращает язык по его имени
     * @param name - имя языка
     * @return - объект языка с заданным именем
     */
    Language read(String name);


    /**
     * Обновляет язык с заданным ID,
     * в соответствии с переданным языком
     * @param language - язык в соответсвии с которым нужно обновить данные
     * @param name - имя языка которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Language language, String name);


    /**
     * Удаляет язык с заданным ID
     * @param name - имя языка, которого нужно удалить
     * @return - true если язык был удален, иначе false
     */
    boolean delete(String name);
}
