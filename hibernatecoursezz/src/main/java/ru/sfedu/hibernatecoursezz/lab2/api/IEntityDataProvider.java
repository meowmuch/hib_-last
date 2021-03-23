package ru.sfedu.hibernatecoursezz.lab2.api;

import ru.sfedu.hibernatecoursezz.lab2.model.NewEntity;
import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEntityDataProvider {
    public Long createEntity(String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);
    public ResultType updateEntity(Long id, String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);
    public void update(TestEntity entity);
    public ResultType delete(Long Id);
    public Optional<TestEntity> getById(Class<TestEntity> entity, Long id);
    public Long save(TestEntity entity);
}
