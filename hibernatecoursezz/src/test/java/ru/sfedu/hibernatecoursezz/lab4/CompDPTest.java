package ru.sfedu.hibernatecoursezz.lab4;

import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.api.CompDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.api.ICompDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.Plan;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.Collections;

import static org.junit.Assert.*;

public class CompDPTest {

    public ICompDP provider = new CompDP();
    public static Plan plan = new Plan();

    @Test
    public void updateClient() {
        Plan planNew = new Plan();
        planNew.setName("New plan plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(planNew));
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",Collections.singletonList(planNew)));
    }

    @Test
    public void updateClientFail() {
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",Collections.emptyList()));
    }

    @Test
    public void createClient() {
        plan.setName("New plan");
        Long id = provider.createClient("name","login", "password", Collections.singletonList(plan));
        assertNotNull(id);
    }

    @Test
    public void createClientFail() {
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(plan));
        assertNotNull(id);
    }

    @Test
    public void deleteClient() {
        plan.setName("New plan");
        Long id = provider.createClient("name","login", "password",Collections.emptyList());
        assertEquals(ResultType.COMPLETE,provider.deleteClient(id));
    }

    @Test
    public void deleteClientFail(){
        assertEquals(ResultType.FAIL,provider.deleteClient(0L));
    }


}
