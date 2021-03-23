package ru.sfedu.hibernatecoursezz.lab5;


import ru.sfedu.hibernatecoursezz.lab5.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static List<Article> generateArticles(int count) {
        List<Article> article = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Article articles = new Article();
            articles.setTitle(generateString());
            articles.setContent(generateString());
            article.add(articles);
        }
        return article;
    }

    public static List<Requisites> generateRequisites(int count) {
        List<Requisites> requisitesList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Requisites requisites = new Requisites();
            requisites.setLogin(generateString());
            requisites.setPassword(generateString());
            requisites.setId(generateLong());
            requisitesList.add(requisites);
        }
        return requisitesList;
    }

    public static List<Book> generateBooks(int count) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Book book = new Book();
            book.setId(generateLong());
            book.setNameOfBook(generateString());
            book.setAuthorName(generateString());
            bookList.add(book);
        }
        return bookList;
    }

    public static List<Client> generateClients(int count, int plansCount) {
        List<Client> clientList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Client client = new Client();
            client.setId(generateLong());
            client.setName(generateString());
            client.setPlanList(generatePlans(plansCount, 3));
            clientList.add(client);
        }
        return clientList;
    }

    public static List<Plan> generatePlans(int count, int booksCount) {
        List<Plan> planList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Plan plan = new Plan();
            plan.setId(generateLong());
            plan.setName(generateString());
            plan.setStatus(generateBoolean());
            planList.add(plan);
        }
        return planList;
    }

    private static String generateString() {
        Random random = new Random();
        char[] word = new char[random.nextInt(9) + 5];
        for (int i = 0; i < word.length; i++) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }

    private static int generateInt() {
        return new Random().nextInt(10000000);
    }

    public static Long generateLong() {
        return Long.valueOf(generateInt());
    }

    private static boolean generateBoolean() {
        return new Random().nextInt(100) % 2 == 1;
    }
}
