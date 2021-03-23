package ru.sfedu.hibernatecoursezz.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.lab5.model.*;


import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final String CUSTOM_CONFIG_PATH = System.getProperty("configPath");
    private static Logger log = LogManager.getLogger(ru.sfedu.hibernatecoursezz.utils.HibernateUtil.class);
    /**
     * Создание фабрики
     *
     */
  /*  public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
// loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
           // metadataSources.addAnnotatedClass(TestEntity.class);// Аннотированная сущность
           // metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }*/

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            File nf;
            try{
                nf = new File(CUSTOM_CONFIG_PATH);
            }
            catch(NullPointerException e){
                nf = new File(Constants.PATH_TO_CFG_XML);
            };
            File file = nf;
            Configuration configuration = new Configuration().configure(file);

            log.error(file.getName());

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);


            //metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы

            addEntities(metadataSources);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources){
        metadataSources.addAnnotatedClass(Requisites.class);
        metadataSources.addAnnotatedClass(Article.class);
        metadataSources.addAnnotatedClass(Book.class);
        metadataSources.addAnnotatedClass(Client.class);
        metadataSources.addAnnotatedClass(Plan.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.listCollection.model.Client.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.mapCollection.model.Client.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.Client.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.Plan.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Client.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Plan.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model.Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model.Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Film.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Article.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Book.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.InfoRes.class);
        metadataSources.addAnnotatedClass(ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model.Film.class);
        metadataSources.addAnnotatedClass(TestEntity.class);




    }
}