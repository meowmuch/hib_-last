package ru.sfedu.hibernatecoursezz.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import ru.sfedu.hibernatecoursezz.lab5.model.*;
import ru.sfedu.hibernatecoursezz.utils.Constants;
import ru.sfedu.hibernatecoursezz.utils.HibernateUtil;
import ru.sfedu.hibernatecoursezz.utils.Result;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HibernateDP {
    private Logger log = LogManager.getLogger(HibernateDP.class);
    private Session session;

    private void initSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public <T>Long save(T bean) {
        try {
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(bean);
            transaction.commit();
            log.debug("Saving bean with the id: " + id.toString());
            return id;
        } catch (Exception e) {
            log.error(e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    private void close() {
        session.close();
    }

    public Article createArticle(Article article) {
        initSession();
        Transaction tx = session.beginTransaction();
        article.setId((Long) session.save(article));
        tx.commit();
        log.debug(article);
        close();
        return article;
    }

    public List<Article> getArticles () {
        String query = String.format(Constants.QUERY, Article.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Article> articleList = session.createQuery(query).list();
        tx.commit();
        log.debug(articleList);
        close();
        return articleList;
    }

    public Article getArticleById(long id) {
        initSession();
        try {
            Article article = session.get(Article.class, id);
            log.debug(article);
            close();
            return article;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Article();
        }
    }

    public Boolean deleteArticle(long id) {
        initSession();
        Article article = new Article();
        article.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(article);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Article updateArticle (Article article) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(article);
        tr.commit();
        close();
        return article;
    }

    public List<Requisites> getRequisites () {
        String query = String.format(Constants.QUERY, Requisites.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Requisites> requisitesList = session.createQuery(query).list();
        tx.commit();
        log.debug(requisitesList);
        close();
        return requisitesList;
    }


    public Requisites createRequisites(Requisites requisites) {
        initSession();
        Transaction tx = session.beginTransaction();
        requisites.setId((long) session.save(requisites));
        tx.commit();
        log.debug(requisites);
        close();
        return requisites;
    }


    public Requisites getRequisitesById(long id) {
        initSession();
        try {
            Requisites requisites = session.get(Requisites.class, id);
            log.debug(requisites);
            close();
            return requisites;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Requisites();
        }
    }


    public Boolean deleteRequisites(long id) {
        initSession();
        Requisites requisites = new Requisites();
        requisites.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(requisites);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Requisites updateRequisites (Requisites requisites) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(requisites);
        tr.commit();
        close();
        return requisites;
    }


    public List<Book> getBooks () {
        String query = String.format(Constants.QUERY, Book.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Book> bookList = session.createQuery(query).list();
        tx.commit();
        log.debug(bookList);
        close();
        return bookList;
    }


    public Book createBook(Book book) {
        initSession();
        Transaction tx = session.beginTransaction();
        book.setId((long) session.save(book));
        tx.commit();
        log.debug(book);
        close();
        return book;
    }


    public Book getBookById(long id) {
        initSession();
        try {
            Book book = session.get(Book.class, id);
            log.debug(book);
            close();
            return book;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Book();
        }
    }


    public Boolean deleteBook(long id) {
        initSession();
        Book book = new Book();
        book.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(book);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Book updateBook (Book book) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(book);
        tr.commit();
        close();
        return book;
    }


    public List<Plan> getPlans () {
        String query = String.format(Constants.QUERY, Plan.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Plan> planList = session.createQuery(query).list();
        tx.commit();
        log.debug(planList);
        close();
        return planList;
    }


    public Plan createPlan(Plan plan) {
        initSession();
        Transaction tx = session.beginTransaction();
        plan.setId((long) session.save(plan));
        tx.commit();
        log.debug(plan);
        close();
        return plan;
    }


    public Plan getPlanById(long id) {
        initSession();
        try {
            Plan plan = session.get(Plan.class, id);
            log.debug(plan);
            close();
            return plan;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Plan();
        }
    }

//    public Result<T> getPlanById(long id) {
//        initSession();
//        try {
//            Result<T> res = session.get(Plan.class, id);
//            log.debug(plan);
//            close();
//            return plan;
//        }
//        catch(Exception e) {
//            log.error("Not found.");
//            close();
//            return new Plan();
//        }
//    }


    public Boolean deletePlan(long id) {
        initSession();
        Plan plan = new Plan();
        plan.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(plan);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }


    public Plan updatePlan (Plan plan) {
        initSession();
        Transaction tr = session.beginTransaction();
        session.update(plan);
        tr.commit();
        close();
        return plan;
    }


    public List<Client> getClients () {
        String query = String.format(Constants.QUERY, Client.class.getSimpleName());
        initSession();
        Transaction tx = session.beginTransaction();
        List<Client> clientList = session.createQuery(query).list();
        tx.commit();
        log.debug(clientList);
        close();
        return clientList;
    }


    public Client createClient(Client client) {
        client.getPlanList().stream().forEach(this::createPlan);
        client.getArticles().stream().forEach(this::createArticle);
        createRequisites(client.getRequisites());
        initSession();
        Transaction tx = session.beginTransaction();
        client.setId((long) session.save(client));
        tx.commit();
        log.debug(client);
        close();
        return client;
    }


    public Client getClientById(long id) {
        initSession();
        try {
            Client client = session.get(Client.class, id);
            log.debug(client);
            close();
            return client;
        }
        catch(Exception e) {
            log.error("Not found.");
            close();
            return new Client();
        }
    }


    public Boolean deleteClient(long id) {
        initSession();
        Client client = new Client();
        client.setId(id);
        try {
            Transaction tr = session.beginTransaction();
            session.delete(client);
            tr.commit();
            close();
            return true;
        } catch (Exception e) {
            log.error(e);
            close();
            return false;
        }
    }

    public Client updateClient (Client client) throws IOException {
        List<Plan> planList = new ArrayList<>();
        for (Plan plan : client.getPlanList()) {
            if ((Long)plan.getId() == null) {
               plan = createPlan(plan);
               planList.add(plan);

            }
        }
        client.setPlanList(planList);
        List<Article> articleList = new ArrayList<>();
        for (Article article : client.getArticles()) {
            if ((Long)article.getId() == null) {
                article = createArticle(article);
                articleList.add(article);
            }
        }
        client.setArticles(articleList);
        initSession();
        Transaction tr = session.beginTransaction();
        tr.commit();
        log.info(123);
        session.update(client);
        close();
        return client;
    }


    public BigInteger getClientCountNative() {
        initSession();
        String query = String.format(Constants.GET_COUNT, Constants.CLIENT);
        BigInteger count = (BigInteger) session.createSQLQuery(query).list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public Long getClientCountHQL() {
        initSession();
        String query = String.format(Constants.GET_COUNT, Constants.CLIENT);
        Long count = (Long) session.createQuery(query).list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public Long getClientCountCriteria() {
        initSession();
        Criteria cr = session.createCriteria(Client.class);
        cr.setProjection(Projections.count("id"));
        Long count = (Long) cr.list().get(0);
        log.debug(count);
        close();
        return count;
    }

    public long checkTimeHQL() {
        long timeStart = System.currentTimeMillis();
        getClientCountHQL();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long checkTimeNative() {
        long timeStart = System.currentTimeMillis();
        getClientCountNative();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long checkTimeCriteria() {
        long timeStart = System.currentTimeMillis();
        getClientCountCriteria();
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

}
