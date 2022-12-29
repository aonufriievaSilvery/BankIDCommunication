package com.cib.bankidcommunication.Authorization.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Request {
    String responseType; //Значення повинно бути “code”
    String clientId; //Ідентифікатор абонентського вузла отриманий при підключенні
    String redirectURI;
    String state; //Унікальний ідентифікатор сесії. Генерується з боку Центрального вузла і має бути повернутий абонентським вузлом у запиті з кодом авторизації. Не більше 50 знаків.
    String login;
    String password;
    String otp;
    String code; //Код авторизації (authorization_code) — унікальний ідентифікатор, який формується на стороні Абонентаідентифікатора. Час дії коду 90 секунд. Не більше 50 знаків
    Date requestDate;

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date now = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(now)); // нужно убрать после проверки
        this.requestDate = now;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        if(responseType=="code"){
            this.responseType = responseType;
        }else{
            this.responseType = responseType; //нужно дописать исключение
        }
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getAuthorizationCode() {
        String str = ""; //Код авторизації (authorization_code) — унікальний ідентифікатор, який формується на стороні Абонентаідентифікатора. Час дії коду 90 секунд. Не більше 50 знаків
        return str;
    }
}
