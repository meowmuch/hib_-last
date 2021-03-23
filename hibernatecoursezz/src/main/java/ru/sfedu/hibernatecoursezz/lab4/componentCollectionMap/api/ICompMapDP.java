package ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api;

import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Plan;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICompMapDP {

    ResultType updateClient(long id, String cname, String login, String password, Map<String, Plan> plan);

    Long createClient(String cname, String login, String password, Map<String, Plan> plan);

    ResultType deleteClient(Long Id);

    <T> void update(T bean);

    @Transactional
    <T> Optional<T> getByID(Class<T> bean, long id);

    <T>Long save(T bean);
}
