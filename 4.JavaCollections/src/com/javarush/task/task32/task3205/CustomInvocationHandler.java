package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
        System.out.println(method.getName() + " in");
        Object result = method.invoke( someInterfaceWithMethods, args );

        //После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
        System.out.println(method.getName() + " out");
        return result;
    }
}
