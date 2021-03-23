package ru.sfedu.hibernatecoursezz.lab4.listCollection.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.HibernateUtil;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class ListDP implements IListDP {
    public static Logger log = LogManager.getLogger(ListDP.class);
    static Session session;

    @Override
    public ResultType updateClient(long id, String cname, String login, String password, List<String> comment) {
        log.info("In updateSection method");

        try {
            Client client = this.getByID(Client.class, id).get();
            client.setName(cname);
            client.setLogin(login);
            client.setPassword(password);
            client.setComment(comment);
            this.update(client);
            return ResultType.COMPLETE;
        }
        catch (NoSuchElementException e){
            log.error(e);
            return ResultType.FAIL;
        }
    }

    @Override
    public Long createClient(String cname, String login, String password, List<String> comment) {
        log.info("In createSection method");
        Client client = new Client();
        client.setName(cname);
        client.setLogin(login);
        client.setPassword(password);
        client.setComment(comment);
        log.debug("Initializing section: "+ client);
        long id = this.save(client);
        log.debug("Saving section with id: "+ id);
        return id;
    }

    @Override
    public ResultType deleteClient(Long Id) {
        log.debug("On deleteStudent method");
        try {
            session = this.getSession();
            Client client = this.getByID(Client.class,Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }

    public Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }


    @Override
    public <T> void update(T bean) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(bean);
            transaction.commit();
        } catch (IOException | NonUniqueObjectException e) {
            log.error(e);
        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    @Transactional
    public <T> Optional<T> getByID(Class<T> bean, long id) {
        try {
            Session session = this.getSession();
            T resultBean = session.get(bean, id);
            log.debug("Returned entity: " + resultBean.toString());
            session.close();
            return Optional.of(resultBean);
        } catch (IOException | NullPointerException e) {
            log.error(e);
            return Optional.empty();
        }
    }

    @Override
    public <T>Long save(T bean) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(bean);
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
}

