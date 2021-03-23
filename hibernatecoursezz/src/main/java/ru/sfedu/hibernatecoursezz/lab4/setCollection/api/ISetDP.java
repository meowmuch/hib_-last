package ru.sfedu.hibernatecoursezz.lab4.setCollection.api;

import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ISetDP {
    ResultType updateClient(long id, String cname, String login, String password, Set<String> comment);

    Long createClient(String cname, String login, String password, Set<String> comment);

    ResultType deleteClient(Long Id);


    Client getbyidClient(Long Id);

    List<Client> getClient();

    <T> void update(T bean);

    @Transactional
    <T> Optional<T> getByID(Class<T> bean, long id);

    <T>Long save(T bean);
}
