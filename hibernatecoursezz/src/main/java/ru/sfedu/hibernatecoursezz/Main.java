package ru.sfedu.hibernatecoursezz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.hibernatecoursezz.api.HibernateMetadataProvider;

import ru.sfedu.hibernatecoursezz.lab2.api.HibernateEntityProvider;
import ru.sfedu.hibernatecoursezz.lab2.model.NewEntity;
import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.lab5.api.HibernateDP;
import ru.sfedu.hibernatecoursezz.lab5.model.Article;
import ru.sfedu.hibernatecoursezz.lab5.model.Book;
import ru.sfedu.hibernatecoursezz.lab5.model.Plan;
import ru.sfedu.hibernatecoursezz.lab5.model.Requisites;
import ru.sfedu.hibernatecoursezz.utils.Additional;
import ru.sfedu.hibernatecoursezz.utils.Constants;
import ru.sfedu.hibernatecoursezz.utils.Result;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws IOException {
        log.info(String.join(",", args));
        if (args.length < 1) {
            log.error(Constants.NO_ARGS);
            return;
        }
        switch (Integer.parseInt(args[0])) {
            case 1:
                HibernateMetadataProvider dp = new HibernateMetadataProvider();
                System.out.print(dp.getSchema());
                System.out.print(dp.getTables());
                System.out.print(dp.getSchemaName());
                System.out.print(dp.getDetails());
                break;
            case 2:
                if (args.length > 1) {
                    HibernateEntityProvider lr2 = new HibernateEntityProvider();
                    switch(args[1].toUpperCase(Locale.ROOT)) {
                        case "CREATE":
                            NewEntity newEntity = new NewEntity();
                            newEntity.setName(args[5]);
                            newEntity.setDescription(args[6]);
                            newEntity.setCollection(Additional.stringToListString(args[7]));
                            lr2.createEntity(args[2], args[3],new java.util.Date(),Boolean.valueOf(args[4]), newEntity);
                            break;
                        case "DELETE":
                            if (args.length > 2) {
                                try {
                                    Long id = Long.parseLong(args[2]);
                                    log.info(lr2.delete(id));
                                } catch (Exception e) {
                                    log.error(Constants.BAD_ARG);
                                }
                            }
                            break;
                        case "UPDATE":
                            NewEntity entity = new NewEntity();
                            entity.setName(args[6]);
                            entity.setDescription(args[7]);
                            entity.setCollection(Additional.stringToListString(args[8]));
                            lr2.updateEntity(Long.valueOf(args[2]), args[3],args[4],new java.util.Date(),Boolean.valueOf(args[5]), entity);
                            break;
                    }
                } else {
                    log.error(Constants.FEW_ARGUMENTS);
                }
                break;
            case 3:
                switch(args[1].toUpperCase(Locale.ROOT)) {
                    case "MAPPED":
                        ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.api.HibernateProvider provider = new ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.api.HibernateProvider();
                        switch(args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE_BOOK":
                                if (args.length > 2) {
                                    ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.Book book = new ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.Book();
                                    provider.createBook(args[3],args[4],args[5],args[6],args[7], Integer.parseInt(args[8]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_ARTICLE":
                                if (args.length > 2) {
                                    provider.createArticle(args[3],args[4],args[5],args[6]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_FILM":
                                if (args.length > 2) {
                                    provider.createFilm(args[3],args[4],args[5],args[6],args[7],args[8]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider.deleteBook(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider.deleteArticle(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider.deleteFilm(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider.updateBook(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], Integer.parseInt(args[9]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider.updateArticle(Long.valueOf(args[3]),args[4],args[5],args[6],args[7]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider.updateFilm(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], args[9]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                        break;
                    case "SINGLETABLE":
                        ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.HibernateProvider provider1 = new ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.HibernateProvider();
                        switch(args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE_BOOK":
                                if (args.length > 2) {
                                    provider1.createBook(args[3],args[4],args[5],args[6],args[7], Integer.parseInt(args[8]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_ARTICLE":
                                if (args.length > 2) {
                                    provider1.createArticle(args[3],args[4],args[5],args[6]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_FILM":
                                if (args.length > 2) {
                                    provider1.createFilm(args[3],args[4],args[5],args[6],args[7],args[8]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider1.deleteBook(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider1.deleteArticle(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider1.deleteFilm(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider1.updateBook(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], Integer.parseInt(args[9]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider1.updateArticle(Long.valueOf(args[3]),args[4],args[5],args[6],args[7]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider1.updateFilm(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], args[9]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                        break;
                    case "TABLEPERCLASS":
                        ru.sfedu.hibernatecoursezz.lab3.TablePerClass.api.HibernateProvider provider2 = new ru.sfedu.hibernatecoursezz.lab3.TablePerClass.api.HibernateProvider();
                        switch(args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE_BOOK":
                                if (args.length > 2) {
                                    provider2.createBook(args[3],args[4],args[5],args[6],args[7], Integer.parseInt(args[8]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_ARTICLE":
                                if (args.length > 2) {
                                    provider2.createArticle(args[3],args[4],args[5],args[6]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_FILM":
                                if (args.length > 2) {
                                    provider2.createFilm(args[3],args[4],args[5],args[6],args[7],args[8]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider2.deleteBook(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider2.deleteArticle(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider2.deleteFilm(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider2.updateBook(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], Integer.parseInt(args[9]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider2.updateArticle(Long.valueOf(args[3]),args[4],args[5],args[6],args[7]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider2.updateFilm(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], args[9]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                        break;
                    case "JOINEDTABLE":
                        ru.sfedu.hibernatecoursezz.lab3.JoinedTable.api.HibernateProvider provider3 = new ru.sfedu.hibernatecoursezz.lab3.JoinedTable.api.HibernateProvider();
                        switch(args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATE_BOOK":
                                if (args.length > 2) {
                                    provider3.createBook(args[3],args[4],args[5],args[6],args[7], Integer.parseInt(args[8]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_ARTICLE":
                                if (args.length > 2) {
                                    provider3.createArticle(args[3],args[4],args[5],args[6]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "CREATE_FILM":
                                if (args.length > 2) {
                                    provider3.createFilm(args[3],args[4],args[5],args[6],args[7],args[8]);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider3.deleteBook(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider3.deleteArticle(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "DELETE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider3.deleteFilm(Long.valueOf(args[3]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                break;
                            case "UPDATE_BOOK":
                                if (args.length > 2) {
                                    try {
                                        provider3.updateBook(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], Integer.parseInt(args[9]));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_ARTICLE":
                                if (args.length > 2) {
                                    try {
                                        provider3.updateArticle(Long.valueOf(args[3]),args[4],args[5],args[6],args[7]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE_FILM":
                                if (args.length > 2) {
                                    try {
                                        provider3.updateFilm(Long.valueOf(args[3]),args[4],args[5],args[6],args[7],args[8], args[9]);
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                    }
                                }
                                else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }

                }
                break;
            case 4:
                switch(args[1].toUpperCase(Locale.ROOT)) {
                    case "SET":
                        ru.sfedu.hibernatecoursezz.lab4.setCollection.api.SetDP providerSet = new ru.sfedu.hibernatecoursezz.lab4.setCollection.api.SetDP();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATECLIENT":
                                if (args.length > 2) {
                                    providerSet.createClient(args[3], args[4], args[5], Additional.stringToSet(args[6]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "GETBYID":
                                if (args.length > 2) {
                                    Long id = Long.parseLong(args[3]);
                                    Client client = providerSet.getbyidClient(Long.valueOf(id));
                                    log.info(client);
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "GET":
                                List<Client> clientList = providerSet.getClient();
                                log.info(clientList);
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    providerSet.updateClient(Long.parseLong(args[3]), args[4], args[5], args[6], Additional.stringToSet(args[7]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        providerSet.deleteClient(Long.valueOf(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                        break;
                                    }
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                    case "MAP":
                        ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.MapDP providerMap = new ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.MapDP();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATECLIENT":
                                if (args.length > 2) {
                                    providerMap.createClient(args[3], args[4], args[5], Additional.stringToMap(args[6]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    providerMap.updateClient(Long.parseLong(args[3]), args[4], args[5], args[6], Additional.stringToMap(args[7]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        providerMap.deleteClient(Long.valueOf(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                        break;
                                    }
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                    case "LIST":
                        ru.sfedu.hibernatecoursezz.lab4.listCollection.api.ListDP providerList = new ru.sfedu.hibernatecoursezz.lab4.listCollection.api.ListDP();
                        switch (args[2].toUpperCase(Locale.ROOT)) {
                            case "CREATECLIENT":
                                if (args.length > 2) {
                                    providerList.createClient(args[3], args[4], args[5], Additional.stringToListString(args[6]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "UPDATE":
                                if (args.length > 2) {
                                    providerList.updateClient(Long.parseLong(args[3]), args[4], args[5], args[6], Additional.stringToListString(args[7]));
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                            case "DELETE":
                                if (args.length > 2) {
                                    try {
                                        Long id = Long.parseLong(args[3]);
                                        providerList.deleteClient(Long.valueOf(id));
                                    } catch (Exception e) {
                                        log.error(Constants.BAD_ARG);
                                        break;
                                    }
                                } else {
                                    log.error(Constants.FEW_ARGUMENTS);
                                }
                                break;
                        }
                }
                break;
            case 5:
                if (args.length > 1) {
                    HibernateDP lr5 = new HibernateDP();
                    switch (args[1].toUpperCase(Locale.ROOT)) {
                        case "CREATE":
                            ru.sfedu.hibernatecoursezz.lab5.model.Client client = new ru.sfedu.hibernatecoursezz.lab5.model.Client();
                            client.setName(args[2]);
                            for (String str : Arrays.copyOfRange(args, 3, args.length)) {
                                client = parseNested(str, client);
                            }
                            log.info(client);
                            lr5.createClient(client);
                            break;
                        case "GET":
                            List<ru.sfedu.hibernatecoursezz.lab5.model.Client> clientList = lr5.getClients();
                            log.info(clientList);
                            break;
                        case "GETBYID":
                            try {
                                Long id = Long.parseLong(args[2]);
                                client = lr5.getClientById(id);
                                log.info(client);
                            } catch (Exception e) {
                                log.error(Constants.BAD_ARG);
                            }
                            break;
                        case "DELETE":
                            try {
                                Long id = Long.parseLong(args[2]);
                                Boolean isDeleted = lr5.deleteClient(id);
                                log.info(isDeleted);
                            } catch (Exception e) {
                                log.error(Constants.BAD_ARG);
                            }
                            break;
                        case "UPDATE":
                            ru.sfedu.hibernatecoursezz.lab5.model.Client clientt = new ru.sfedu.hibernatecoursezz.lab5.model.Client();
                            clientt.setId(Long.parseLong(args[2]));
                            clientt.setName(args[3]);
                            for (String str : Arrays.copyOfRange(args, 4, args.length)) {
                                clientt = parseNested(str, clientt);
                            }
                            log.info(clientt);
                            lr5.updateClient(clientt);
                            break;
                    }
                }

                        break;
            default:
                log.info(Constants.BAD_ARG);
                break;

        }
    }

    private static Book parseBook(String rawData) {
        Book book = new Book();
        String[] arr = rawData.split(",");
        try {
            book.setNameOfBook(arr[0]);
            book.setAuthorName(arr[1]);
        } catch (Exception e ) {
            log.error(e);
        } finally {
            return book;
        }
    }


    private static Plan parsePlan(String rawData) {
        Plan plan = new Plan();
        try {
            plan.setName(rawData);
        } catch (Exception e ) {
            log.error(e);
        } finally {
            return plan;
        }
    }

    private static Requisites parseRequisites(String rawData) {
        Requisites requisites = new Requisites();
        String[] arr = rawData.split(",");
        try {
            requisites.setLogin(arr[0]);
            requisites.setPassword(arr[1]);
        } catch (Exception e ) {
            log.error(e);
        } finally {
            return requisites;
        }
    }

    private static Article parseArticle(String rawData) {
        Article article = new Article();
        String[] arr = rawData.split(",");
        try {
            article.setTitle(arr[0]);
            article.setContent(arr[1]);
        } catch (Exception e ) {
            log.error(e);
        } finally {
            return article;
        }
    }

    private static ru.sfedu.hibernatecoursezz.lab5.model.Client parseNested(String raw, ru.sfedu.hibernatecoursezz.lab5.model.Client client) {
        if (raw.startsWith("*")) {
            raw = removeBrackets(raw);
            Requisites requisitess  = parseRequisites(raw);
            client.setRequisites(requisitess);
            return client;
        }
        if (raw.startsWith("[")) {
            raw = removeBrackets(raw);
            Plan plans  = parsePlan(raw);
            client.setPlanList(Collections.singletonList(plans));
            return client;
        }
        if (raw.startsWith("(")) {
            raw = removeBrackets(raw);
            Article article = parseArticle(raw);
            client.setArticles(Collections.singletonList(article));
            return client;
        }
        return client;
    }

    private static String removeBrackets(String raw) {
        return raw.substring(1, raw.length() - 1);
    }
}




