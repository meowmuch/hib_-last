package ru.sfedu.hibernatecoursezz.lab4;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api.CompMapDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api.ICompMapDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Plan;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.IMapDP;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.MapDP;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompMapDPTest {

    public ICompMapDP provider = new CompMapDP();
    public static Plan plan = new Plan();


    @Test
    public void updateClient() {
        Plan planNew = new Plan();
        planNew.setName("New plan name");
        Map<String, Plan> plans = new HashMap<String, Plan>();
        plans.put("plan_key", planNew);
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",plans));
    }

    @Test
    public void updateClientFail() {
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",Collections.emptyMap()));
    }

    @Test
    public void createClient() {
        plan.setName("New section");
        Map<String ,Plan> plans = new HashMap<String,Plan>();
        plans.put("plan_key",plan);
        Long id  = provider.createClient("Name","login","password", plans);
        Assertions.assertNotNull(id);
    }

    @Test
    public void createClientFail() {
        Long id  = provider.createClient("name","login", "password", Collections.emptyMap());
        assertNotNull(id);
    }

    @Test
    public void deleteClient() {
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
        assertEquals(ResultType.COMPLETE,provider.deleteClient(id));
    }

    @Test
    public void deleteClientFail(){
        assertEquals(ResultType.FAIL,provider.deleteClient(0L));
    }

}
