package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * который будет производить проверку безопасности перед подключением.
 * В случае, если проверка не пройдена, соединение не должно быть установлено.
 * */
public class SecurityProxyConnector implements Connector{
    private String resourceString;
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        securityChecker = new SecurityCheckerImpl();
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        //должен выполнять проверку безопасности с помощью вызова метода performSecurityCheck
        // у объекта типа SecurityChecker.
        if (securityChecker.performSecurityCheck())
            //Если проверка безопасности была пройдена, должно быть выполнено подключение.
            simpleConnector.connect();
    }
}
