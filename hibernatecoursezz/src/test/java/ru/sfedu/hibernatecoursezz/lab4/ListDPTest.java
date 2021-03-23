package ru.sfedu.hibernatecoursezz.lab4;

import org.junit.Test;
import org.postgresql.shaded.com.ongres.scram.common.message.ClientFirstMessage;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.api.IListDP;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.api.ListDP;

import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListDPTest {

    public List<String> comment = Arrays.asList("comment1","comment2","comment3");

    public List<String> commentUpdated = Arrays.asList("comment_1","comment_2","comment_3");


    public IListDP provider = new ListDP();

    @Test
    public void updateClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",commentUpdated));
    }

    @Test
    public void updateClientFail() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",comment));
    }

    @Test
    public void createClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(id);
    }

    @Test
    public void createClientFail() {
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(id);
    }

    @Test
    public void deleteClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.COMPLETE,provider.deleteClient(id));
    }

    @Test
    public void deleteClientFail(){
        assertEquals(ResultType.FAIL,provider.deleteClient(0L));
    }
}
