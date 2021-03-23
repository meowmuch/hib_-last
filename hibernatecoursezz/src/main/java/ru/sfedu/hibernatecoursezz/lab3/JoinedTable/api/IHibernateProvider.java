package ru.sfedu.hibernatecoursezz.lab3.JoinedTable.api;


import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IHibernateProvider {
    Long createBook(String aname, String bname, String link,
                    String review, String genre, int time);

    Long createFilm(String aname, String bname, String country,
                    String year, String producer, String format);

    Long createArticle(String aname, String bname, String title,
                       String content);

    ResultType updateFilm(Long id, String aname, String bname, String country,
                          String year, String producer, String format);

    ResultType updateBook(Long id, String aname, String bname, String link,
                          String review, String genre, int time);

    ResultType updateArticle(Long id, String aname, String bname, String title,
                             String content);

    ResultType deleteBook(Long Id);

    ResultType deleteFilm(Long Id);

    ResultType deleteArticle(Long Id);

    <T> void update(T cn);

    @Transactional
    <T> Optional<T> getById(Class<T> cn, Long id);

    <T> Long save(T cn);
}
