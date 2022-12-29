package com.cib.bankidcommunication.Authorization.service;

import com.cib.bankidcommunication.Authorization.model.Request;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService{

    // Хранилище запросов
    private static final Map<String, Request> REQUEST_REPOSITORY_MAP = new HashMap<>();
    // Переменная для генерации authorization_code запроса
    //private static final String REQUEST_CODE_HOLDER = new String();

    @Override
    public void create(Request request) {
        //String authorizationCode = request.getAuthorizationCode();
        //request.setCode(authorizationCode);
        REQUEST_REPOSITORY_MAP.put(request.getLogin(), request);
    }

    @Override
    public List<Request> readAll() {
        return new ArrayList<>(REQUEST_REPOSITORY_MAP.values());
    }

    @Override
    public Request read(String login) {
        return REQUEST_REPOSITORY_MAP.get(login);
    }

    @Override
    public boolean update(Request request, String login) {
        if (REQUEST_REPOSITORY_MAP.containsKey(login)) {
            request.setLogin(login);
            REQUEST_REPOSITORY_MAP.put(login, request);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String login) {
        return REQUEST_REPOSITORY_MAP.remove(login) != null;
    }
}
