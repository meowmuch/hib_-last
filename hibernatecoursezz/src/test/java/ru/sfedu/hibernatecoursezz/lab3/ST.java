package ru.sfedu.hibernatecoursezz.lab3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.HibernateProvider;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.IHibernateProvider;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ST {
    public static Logger log = LogManager.getLogger(ST.class);
    IHibernateProvider provider = new HibernateProvider();

    @Test
    public void createBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertNotNull(id);
    }

    @Test
    public void createFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertNotNull(id);
    }

    @Test
    public void createArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertNotNull(id);
    }

    @Test
    public void deleteBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.COMPLETE, provider.deleteBook(id));
    }

    @Test
    public void deleteFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.COMPLETE, provider.deleteFilm(id));
    }

    @Test
    public void deleteArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.COMPLETE, provider.deleteArticle(id));
    }

    @Test
    public void updateBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.COMPLETE, provider.updateBook(id, " new book name", "author name", "link.com", "review1", "genre1", 5));
    }

    @Test
    public void updateFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.COMPLETE, provider.updateFilm(id, "new book name", "new author name", "country", "2000", "producer1", "format1"));
    }

    @Test
    public void updateArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.COMPLETE, provider.updateArticle(id, "new book name", "author name", "new title", "content"));
    }

}
