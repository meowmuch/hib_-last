package ru.sfedu.hibernatecoursezz.api;

import java.util.List;

public interface IMetadataProvider {
    List getSchema();

    List getTables();

    List getDetails();

    List getSchemaName();
}
