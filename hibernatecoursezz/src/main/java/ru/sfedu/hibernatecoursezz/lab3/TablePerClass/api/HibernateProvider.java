package ru.sfedu.hibernatecoursezz.lab3.TablePerClass.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Article;
import ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Book;
import ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Film;
import ru.sfedu.hibernatecoursezz.utils.ResultType;
import ru.sfedu.hibernatecoursezz.utils.HibernateUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class HibernateProvider implements IHibernateProvider{

    public static Logger log = LogManager.getLogger(IHibernateProvider.class);
    static Session session;

    @Override
    public Long createBook(String aname, String bname, String link,
                           String review, String genre, int time) {
        Book book = new Book();
        book.setBookAuthorName(aname);
        book.setNameOfBook(bname);
        book.setLink(link);
        book.setReview(review);
        book.setGenre(genre);
        book.setTimeReading(time);
        log.debug("Initializing bean:" + book);
        Long id = this.save(book);
        log.debug("Saving book with id: " + id);
        return id;
    }

    @Override
    public Long createFilm(String aname, String bname, String country,
                           String year, String producer, String format) {
        Film film = new Film();
        film.setBookAuthorName(aname);
        film.setNameOfBook(bname);
        film.setCountry(country);
        film.setYear(year);
        film.setProducer(producer);
        film.setFormat(format);
        log.debug("Initializing bean:" + film);
        Long id = this.save(film);
        log.debug("Saving film with id: " + id);
        return id;
    }

    @Override
    public Long createArticle(String aname, String bname, String title,
                              String content) {
        Article article = new Article();
        article.setBookAuthorName(aname);
        article.setNameOfBook(bname);
        article.setTitle(title);
        article.setContent(content);
        log.debug("Initializing bean:" + article);
        Long id = this.save(article);
        log.debug("Saving article with id: " + id);
        return id;
    }

    @Override
    public ResultType updateFilm(Long id, String aname, String bname, String country,
                                 String year, String producer, String format) {
        try {
            log.debug("In updateFilm method");
            Film film = getById(Film.class, id).get();;
            film.setBookAuthorName(aname);
            film.setNameOfBook(bname);
            film.setCountry(country);
            film.setYear(year);
            film.setProducer(producer);
            film.setFormat(format);
            this.update(film);
            return ResultType.COMPLETE;
        } catch (NoSuchElementException e) {
            log.error("Updating bean error");
            return ResultType.FAIL;
        }

    }

    @Override
    public ResultType updateBook(Long id, String aname, String bname, String link,
                                 String review, String genre, int time) {
        try {
            log.debug("In updateBook method");
            Book book = getById(Book.class, id).get();;
            book.setBookAuthorName(aname);
            book.setNameOfBook(bname);
            book.setLink(link);
            book.setReview(review);
            book.setGenre(genre);
            book.setTimeReading(time);
            this.update(book);
            return ResultType.COMPLETE;
        } catch (NoSuchElementException e) {
            log.error("Updating bean error");
            return ResultType.FAIL;
        }

    }

    @Override
    public ResultType updateArticle(Long id, String aname, String bname, String title,
                                    String content) {
        try {
            log.debug("In updateArticle method");
            Article article = getById(Article.class, id).get();;
            article.setBookAuthorName(aname);
            article.setNameOfBook(bname);
            article.setTitle(title);
            article.setContent(content);
            this.update(article);
            return ResultType.COMPLETE;
        } catch (NoSuchElementException e) {
            log.error("Updating bean error");
            return ResultType.FAIL;
        }

    }

    @Override
    public ResultType deleteBook(Long Id) {
        log.debug("On deleteBook method");
        try {
            session = this.getSession();
            Book book = this.getById(Book.class,Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public ResultType deleteFilm(Long Id) {
        log.debug("On deleteFilm method");
        try {
            session = this.getSession();
            Film film = this.getById(Film.class,Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(film);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public ResultType deleteArticle(Long Id) {
        log.debug("On deleteArticle method");
        try {
            session = this.getSession();
            Article article = this.getById(Article.class,Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(article);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    public <T> void update(T cn) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(cn);
            transaction.commit();
        } catch (IOException | NonUniqueObjectException e) {
            log.error(e);
        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    @Transactional
    public <T> Optional<T> getById(Class<T> cn, Long id) {
        try {
            Session session = this.getSession();
            T resultBean = session.get(cn, id);
            log.debug("Returned entity: " + resultBean.toString());
            session.close();
            return Optional.of(resultBean);
        } catch (IOException | NullPointerException e) {
            log.error(e);
            return Optional.empty();
        }
    }

    @Override
    public <T>Long save(T cn) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(cn);
            transaction.commit();
            log.debug("Saving bean with the id: " + id.toString());
            return id;
        } catch (IOException e) {
            log.error(e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    private Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }


}
