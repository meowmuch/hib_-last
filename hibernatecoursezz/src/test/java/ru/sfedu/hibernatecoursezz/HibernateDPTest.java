package ru.sfedu.hibernatecoursezz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab5.Generator;
import ru.sfedu.hibernatecoursezz.lab5.api.HibernateDP;
import ru.sfedu.hibernatecoursezz.lab5.model.*;
import ru.sfedu.hibernatecoursezz.utils.Constants;

import java.math.BigInteger;
import java.util.List;

public class HibernateDPTest {

    private HibernateDP dp = new HibernateDP();
    private Logger log = LogManager.getLogger(HibernateDPTest.class);

    @Test
    public void getRequisites() {
        List<Requisites> requisitesList = dp.getRequisites();
        log.info(requisitesList);
    }

    @Test
    public void createRequisites() {
        Requisites requisites = new Requisites();
        requisites.setLogin("login1");
        requisites.setPassword("password1");
        dp.createRequisites(requisites);
        log.info(requisites);
    }

    @Test
    public void getRequisitesById() {
        Requisites requisites = dp.getRequisitesById(1);
        log.info(requisites);
    }

    @Test
    public void deleteRequisites() {
        List<Requisites> requisitesList = dp.getRequisites();
        long id = requisitesList.get(0).getId();
        Boolean hasDeleted = dp.deleteRequisites(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateRequisites() {
        List<Requisites> requisitesList = dp.getRequisites();
        Requisites requisites = requisitesList.get(0);
        requisites.setLogin(requisites.getLogin() + "_new");
        requisites.setPassword(requisites.getPassword() + "_new");
        dp.updateRequisites(requisites);
        log.info(requisites);
    }

    @Test
    public void getBooks() {
        List<Book> bookList = dp.getBooks();
        log.info(bookList);
    }

    @Test
    public void createBook() {
        Book book = new Book();
        book.setNameOfBook("Book1");
        book.setAuthorName("Name1");
        book = dp.createBook(book);
        log.info(book);
    }

    @Test
    public void getBookById() {
        Book book = dp.getBookById(1);
        log.info(book);
    }

    @Test
    public void deleteBook() {
        List<Book> bookList = dp.getBooks();
        long id = bookList.get(0).getId();
        Boolean hasDeleted = dp.deleteBook(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateBook() {
        List<Book> bookList = dp.getBooks();
        Book book = bookList.get(0);
        book.setNameOfBook(book.getNameOfBook() + "_new");
        book.setAuthorName(book.getAuthorName() + "_new");
        book = dp.updateBook(book);
        log.info(book);
    }

    @Test
    public void getPlans() {
        List<Plan> planList = dp.getPlans();
        log.info(planList);
    }

    @Test
    public void createPlan() {
        List<Book> bookList = Generator.generateBooks(5);
        Plan plan = new Plan();
        plan.setName("Name Plan");
        plan.setStatus(false);
        plan = dp.createPlan(plan);
        log.info(plan);
    }

    @Test
    public void getPlanById() {
        Plan plan = dp.getPlanById(1);
        log.info(plan);
    }

    @Test
    public void deletePlan() {
        List<Plan> planList = dp.getPlans();
        long id = planList.get(0).getId();
        Boolean hasDeleted = dp.deletePlan(id);
        log.info(hasDeleted);
    }

    @Test
    public void updatePlan() {
        List<Plan> planList = dp.getPlans();
        Plan plan = planList.get(0);
        plan.setName(plan.getName() + "_new");
        plan = dp.updatePlan(plan);
        log.info(plan);
    }

    @Test
    public void getClients() {
        List<Client> clientList = dp.getClients();
        log.info(clientList);
    }

    @Test
    public void createClient() {
        Client client = new Client();

        List<Article> article = Generator.generateArticles(3);

        client.setArticles(article);

        List<Plan> planList = Generator.generatePlans(5, 2);
        client.setPlanList(planList);

        Requisites requisites = new Requisites();
        requisites.setLogin("login2");
        requisites = dp.createRequisites(requisites);
        client.setRequisites(requisites);

        client.setName("client name");
        client = dp.createClient(client);
        log.info(client);
    }

    @Test
    public void getClientById() {
        Client client = dp.getClientById(1);
        log.info(client);
    }

    @Test
    public void deleteClient() {
        List<Client> clientList = dp.getClients();
        long id = clientList.get(0).getId();
        Boolean hasDeleted = dp.deleteClient(id);
        log.info(hasDeleted);
    }



    @Test
    public void createArticle() {
        Article article = new Article();
        article.setTitle("Title1");
        article.setContent("Content1");
        dp.createArticle(article);
        log.info(article);
    }

    @Test
    public void getArticles() {
        List<Article> articleList = dp.getArticles();
        log.info(articleList);
    }

    @Test
    public void getArticleById() {
        Article article = dp.getArticleById(1);
        log.info(article);
    }

    @Test
    public void deleteArticle() {
        Article article = new Article();
        article.setTitle("Title1");
        article.setContent("Content1");
        dp.createArticle(article);
        List<Article> articleList = dp.getArticles();
        long id = articleList.get(0).getId();
        Boolean hasDeleted = dp.deleteArticle(id);
        log.info(hasDeleted);
    }

    @Test
    public void updateArticle() {

        List<Article> articleList = dp.getArticles();
        Article article = articleList.get(0);
        article.setTitle(article.getTitle() + "_new");
        article = dp.updateArticle(article);
        log.info(article);
    }

    @Test
    public void getClientCountNative() {
        BigInteger count = dp.getClientCountNative();
        log.info(count);
    }

    @Test
    public void getClientCountHQL() {
        Long count = dp.getClientCountHQL();
        log.info(count);
    }

    @Test
    public void getClientCountCriteria() {
        Long count = dp.getClientCountCriteria();
        log.info(count);
    }

    @Test
    public void checkTimeHQL() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeHQL() / 1000L));
    }

    @Test
    public void checkTimeNative() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeHQL() / 1000L));
    }

    @Test
    public void checkTimeCriteria() {
        log.info(String.format(Constants.TIME_TAKEN, (double) dp.checkTimeCriteria() / 1000L));
    }
}
