package ru.sfedu.hibernatecoursezz.lab4.componentCollection.api;

import ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.Plan;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICompDP {

    ResultType updateClient(long id, String cname, String login, String password, List<Plan> plan);

    Long createClient(String cname, String login, String password, List<Plan> plan);

    ResultType deleteClient(Long Id);

    <T> void update(T bean);

    @Transactional
    <T> Optional<T> getByID(Class<T> bean, long id);

    <T>Long save(T bean);
}
