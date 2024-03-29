package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        long startTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here

        synchronized (mail) {
            try {
                mail.wait();
            } catch (InterruptedException e) {

            }
        }

        long endTime = System.currentTimeMillis();
        System.out.format( "%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime) );
    }
}
