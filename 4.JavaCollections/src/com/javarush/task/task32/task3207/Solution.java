package com.javarush.task.task32.task3207;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
Remote Method Invocation – удаленный вызов методов.
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    //Представьте, что мы запускаем клиент RMI как поток CLIENT_THREAD
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            try {
                DoubleString service = (DoubleString)registry.lookup( UNIC_BINDING_NAME );
                String result  = service.doubleString( "Hello Amigo! " );
                System.out.println(result);

            }catch (NotBoundException | RemoteException e) {
                e.printStackTrace();
            }
        }

    });

    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        //Представьте, что мы запускаем сервер RMI в качестве основного потока
        Remote stub;
        final DoubleStringImpl service = new DoubleStringImpl();

        try {
            registry = LocateRegistry.createRegistry(2099);
//          final DoubleStringImpl service = new DoubleStringImpl();
            stub = UnicastRemoteObject.exportObject(service, 0);

            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();

        //Чтобы не выбрасывалась ошибка, необходимо добавить этот код ниже
        try {
            Thread.sleep( 120 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // И чтобы завершить программу без ошибок нужно вынести за блок try
       //final DoubleStringImpl service = new DoubleStringImpl();
      //строка 42 на 38  и добавить код ниже (закрыть порт)
        try {
            UnicastRemoteObject.unexportObject(service,true);
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
        }
    }
}