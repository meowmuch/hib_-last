package ru.sfedu.hibernatecoursezz.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.api.ISetDP;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.api.SetDP;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class SetDPTest {

    public Set<String> comment = Stream.of("comment1", "comment2", "comment3")
        .collect(Collectors.toSet());
    public Set<String> commentUpdated = Stream.of("comment_1","comment_2","comment_3")
            .collect(Collectors.toSet());


    public ISetDP provider = new SetDP();
    private Logger log = LogManager.getLogger(SetDPTest.class);

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
        assertNotNull(provider.getByID(Client.class,id).get());
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

    @Test
    public void getClients()  {
        Long id = provider.createClient("name","login", "password",comment);
        List<Client> clientList = provider.getClient();
        assertNotNull(clientList);

    }
}
