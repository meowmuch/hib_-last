package ru.sfedu.hibernatecoursezz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Additional {

    public static List<String> stringToListString(String urls){
        try {
            if (urls.trim().toLowerCase().equals("null")) {
                return new ArrayList<>();
            }
            return Stream.of(urls.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public static Set<String> stringToSet(String string){
        try {
            return Stream.of(string.split(","))
                    .map(String::trim)
                    .collect(Collectors.toSet());
        }
        catch (Exception e){
            return null;
        }
    }

    public static Map<String,String> stringToMap(String string){
        try {
            return Stream.of(string.split(","))
                    .map(s -> s.split(":"))
                    .collect(Collectors.toMap(e -> e[0], e ->(e[1])));
        }
        catch (Exception e){
            return null;
        }
    }



}
