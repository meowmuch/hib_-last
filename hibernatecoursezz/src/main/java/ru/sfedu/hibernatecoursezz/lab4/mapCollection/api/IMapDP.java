package ru.sfedu.hibernatecoursezz.lab4.mapCollection.api;

import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IMapDP {

    ResultType updateClient(long id, String cname, String login, String password, Map<String, String> comment);

    Long createClient(String cname, String login, String password, Map<String, String> comment);

    ResultType deleteClient(Long Id);

    <T> void update(T bean);

    @Transactional
    <T> Optional<T> getByID(Class<T> bean, long id);

    <T>Long save(T bean);
}
