package ru.sfedu.hibernatecoursezz.lab4.listCollection.api;

import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IListDP {

    ResultType updateClient(long id, String cname, String login, String password, List<String> comment);

    Long createClient(String cname, String login, String password, List<String> comment);

    ResultType deleteClient(Long Id);

    <T> void update(T bean);

    @Transactional
    <T> Optional<T> getByID(Class<T> bean, long id);

    <T>Long save(T bean);
}
