package com.cib.bankidcommunication.Authorization.service;

import com.cib.bankidcommunication.Authorization.model.Request;

import java.util.List;

public interface RequestService {
    void create(Request request); //создает новый запрос @param request - запрос для создания
    List<Request> readAll(); //Возвращает список всех имеющихся запросов
    Request read(String login); //возвращает запрос по логину(номеру телефона) клиента
    boolean update(Request request, String login); //обновляет запрос в соответствии с передаными параметрами (возможно не нужен)
    boolean delete(String login); //удаляет запрос с заданым логином клиента
}
