package ru.sfedu.hibernatecoursezz.lab4;

import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.IMapDP;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.MapDP;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapDPTest {

    public IMapDP provider = new MapDP();
    public static Map<String,String> comment = new HashMap<String,String>();
    public static Map<String,String> commentUpdated = new HashMap<String,String>();

    @Test
    public void updateClient() {
        comment.put("comment_key","comment_1");
        commentUpdated.put("key","material_upd");
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
        comment.put("comment_key","comment_1");
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
