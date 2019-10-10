package com.javarush.task.task33.task3307;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;

/* 
Десериализация XML объекта
*/
public class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
        System.out.println(cat);
    }

    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz)
            throws IOException, JAXBException {
        StringReader reader = new StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance( clazz );
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T) unmarshaller.unmarshal( reader );
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}

/*
* Чтобы избежать ошибки
Error: Unable to initialize main class com.javarush.task.task33.task3306.Solution
Caused by: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
 можно воспользоваться таким способом.
Запустить пустой проект, чтобы появилась конфигурация.
В IDEA сверху в меню найти пункт RUN, нажать на него и найти пункт Edit Configurations...
Если вы уже запустили проект, то конфигурацию, которую нужно подправить будет у вас установлена автоматом.
* Переименовываем ее (автоматически будет стоят Solution и если запустить без переименования,
* то будет конфликт имен конфигураций) и в строку VM options вписываем вот такую строку
*
--add-modules java.xml.bind
*
Сохраняем и запускаем наш проект.*/