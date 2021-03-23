package ru.sfedu.hibernatecoursezz.lab2;

import org.junit.Assert;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab2.api.HibernateEntityProvider;
import ru.sfedu.hibernatecoursezz.lab2.api.IEntityDataProvider;
import ru.sfedu.hibernatecoursezz.lab2.model.NewEntity;
import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class HibernateEntityProviderTest {

    public HibernateEntityProviderTest(){};

    @Test
    public void createEntity(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setName("name");
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertEquals(expected,testEntity);
    }

    @Test
    public void deleteTest(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        Date date = new Date();
        TestEntity entity = new TestEntity();
        entity.setDateCreated(date);
        entity.setDescription("Test entity");
        entity.setName("Name");
        Long id = provider.save(entity);
        assertEquals(ResultType.COMPLETE,provider.delete(id));
        assertEquals(Optional.empty(),provider.getById(TestEntity.class,id));
    }

    @Test
    public void deleteTestFail(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        assertEquals(ResultType.FAIL,provider.delete(-1L));
    }

    @Test
    public void updateSuccess(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New name");
        newEntity.setDescription("New Description");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertEquals(ResultType.COMPLETE,provider.updateEntity(id,"name","new description",date,true,newEntity));
        assertEquals("new description",provider.getById(TestEntity.class,id).get().getDescription());
    }

    @Test
    public void updateFail(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        Date date = new Date();
        assertEquals(ResultType.FAIL,provider.updateEntity(-1L,"name","new description",date,true,null));
    }


    @Test
    public void getById() {
        System.out.println("getById");
        Class<TestEntity> entity = null;
        Long id = null;
        HibernateEntityProvider instance = new HibernateEntityProvider();
        Optional<TestEntity> result = instance.getById(entity,id);
        assertNotNull(result);

    }

    @Test
    public void save() {
        System.out.println("save");
        TestEntity entity = new TestEntity();
        entity.setName("Name1");
        IEntityDataProvider instance = new HibernateEntityProvider();
        Long result = instance.save(entity);
        System.out.println(result);
        assertNotNull(result);

    }

}
