package ru.sfedu.hibernatecoursezz.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hibernatecoursezz.utils.Constants;
import ru.sfedu.hibernatecoursezz.utils.HibernateUtil;

import java.io.IOException;
import java.util.List;


public class HibernateMetadataProvider implements IMetadataProvider{

    private static Logger log = LogManager.getLogger(ru.sfedu.hibernatecoursezz.api.HibernateMetadataProvider.class);



    @Override
    public List getSchema() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.SCHEMA);
            List resList = query.getResultList();
            session.close();
            log.info("Get schema size: {}", resList.size());
            return resList;
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getTables() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.TABLE);
            List resList = query.getResultList();
            session.close();
            log.debug("Get table name: {}" + resList.toString());
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getSchemaName() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.NAME);
            List resList = query.getResultList();
            session.close();
            log.debug("Get schema name: {}", resList);
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getDetails() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.DETAILS);
            List resList = query.getResultList();
            session.close();
            log.debug("Get details: {}",resList);
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    private Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }
}
