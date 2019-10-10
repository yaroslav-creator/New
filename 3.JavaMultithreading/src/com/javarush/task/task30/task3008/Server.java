package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send( message );
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage( "Сообщение не отправлено" );
        }
    }

    public static void main(String[] args) {

        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket( serverPort )) {
            ConsoleHelper.writeMessage( "Введите порт сервера:" );

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler( socket );
                handler.start();
                ConsoleHelper.writeMessage( "Сервер запущен" );
            }
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }

    private static class Handler extends Thread {
        public Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send( new Message( MessageType.NAME_REQUEST ) );
            Message message = connection.receive();

            if (message.getType() != MessageType.USER_NAME) {
                return serverHandshake( connection );
            }
            if (message.getData().isEmpty() || connectionMap.containsKey( message.getData() )) {
                return serverHandshake( connection );
            }
            connection.send( new Message( MessageType.NAME_ACCEPTED ) );
            connectionMap.put( message.getData(), connection );
            return message.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals( userName )) {
                    connection.send( new Message( MessageType.USER_ADDED, name ) );
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message newMessage = new Message( MessageType.TEXT, userName + ": " + message.getData() );
                    sendBroadcastMessage( newMessage );
                } else {
                    ConsoleHelper.writeMessage( "Error" );
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage( "Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress() );

            String userName = null;

            try (Connection connection = new Connection( socket )) {
                userName = serverHandshake( connection );

                sendBroadcastMessage( new Message( MessageType.USER_ADDED, userName ) );
                notifyUsers( connection, userName );
                serverMainLoop( connection, userName );

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage( "Ошибка при обмене данными с удаленным адресом" );

            } finally {
                if (userName != null) {
                    connectionMap.remove( userName );
                    sendBroadcastMessage( new Message( MessageType.USER_REMOVED, userName ) );
                }
                ConsoleHelper.writeMessage( "Соединение с удаленным адресом закрыто" + socket.getRemoteSocketAddress());
            }
        }
    }
}