package com.javarush.task.task33.task3309;


import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml

Может быть поможет, один из вариантов решения:
1. javax.xml.bind.JAXBContext: Создаем новый инстанс JAXBContext.
2. javax.xml.bind.Marshaller: Из инстанса контекста получаем marshaller.
   У marshaller устанавливаем свойство Marshaller.JAXB_FORMATTED_OUTPUT в истину,
   чтобы вывод был разбит по строчкам.
3. javax.xml.parsers.DocumentBuilderFactory: Создаем фабрику DocumentBuilderFactory.
   Для преобразования CDATA узлов в текст устанавливаем factory.setCoalescing(true).
4. javax.xml.parsers.DocumentBuilder: Создаем новый DocumentBuilder.
5. org.w3c.dom.Document: С помощью билдера создаем новый документ.
7. Маршализуем объект в документ.
-- Документ (дерево) получили, теперь его необходимо обработать --
8. org.w3c.dom.NodeList: из документа получаем список узлов.
9. Обрабатываем список узлов в цикле:
9.1. Если имя узла соответствует заданному, то вставляем перед ним комментарий
     node.getParentNode( ).insertBefore( document.createComment( comment ), node)
9.2. Если тип первого дочернего узла node.getFirstChild() равен Node.TEXT_NODE и контекст
     подходит под firstChild.getTextContent().matches(".*[<>&\'\"].*"),
     то заменяем node.replaceChild(cdataSection, firstChild).
     объект org.w3c.dom.CDATASection необходимо предварительно создать из контекста  firstChild.
-- Документ готов! Получаем из документа строку. --
10. javax.xml.transform.TransformerFactory: Получаем инстанс TransformerFactory.
11. javax.xml.transform.Transformer: С помощью инсттанса TransformerFactory получаем transformer -а.
    Устанавливаем свойства вывода: transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
     ...ENCODING, "UTF-8", STANDALONE, "no"
12. Получаем StringWriter.
13. Трансформируем данные transformer.transform(new DOMSource(document), new StreamResult(writer)).
14. Все, из stringWriter получаем строку.
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws Exception {

        //Создаем новый инстанс JAXBContext.
        JAXBContext context = JAXBContext.newInstance( obj.getClass() );
        //Создаем Marshaller Из инстанса контекста получаем marshaller.
        Marshaller marshaller = context.createMarshaller();
        //У marshaller устанавливаем свойство Marshaller.JAXB_FORMATTED_OUTPUT в истину,
        //   чтобы вывод был разбит по строчкам.
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

        //Создаем документ с помощью DocumentBuilderFactory.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setCoalescing( true );
        //Создаем новый DocumentBuilder.
        DocumentBuilder builder = factory.newDocumentBuilder();
        //С помощью билдера создаем новый документ.
        Document document = builder.newDocument();
        //Маршализуем объект в документ.
        marshaller.marshal( obj, document );

        //Документ (дерево) получили, теперь его необходимо обработать
        //из документа получаем список узлов
        NodeList nodes = document.getElementsByTagName( "*" );
        //Обрабатываем список узлов в цикле:
        if (nodes.getLength() > 0) {
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item( i );
                if (node.getNodeName().equals( tagName )) {
                    //Если имя узла соответствует заданному, то вставляем перед ним комментарий
                    node.getParentNode().insertBefore( document.createComment( comment ), node );
                }
                //Если тип первого дочернего узла node.getFirstChild() равен Node.TEXT_NODE и контекст
                //подходит под firstChild.getTextContent().matches(".*[<>&\'\"].*")
                if (node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                    Node currentNode = node.getFirstChild();
                    if (currentNode.getTextContent().matches( ".*[<>&\'\"].*" )) {

                        String content = currentNode.getTextContent();
                        CDATASection cdataSection = document.createCDATASection( content );
                        //то заменяем node
                        node.replaceChild( cdataSection, currentNode );

                    }
                }
            }
        }

        //Получаем инстанс TransformerFactory.С помощью инстанса TransformerFactory получаем transformer -а.
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //Устанавливаем свойства вывода:
        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty( OutputKeys.ENCODING, "UTF-8" );
        transformer.setOutputProperty( OutputKeys.STANDALONE, "no" );

        //Получаем StringWriter.
        StringWriter writer = new StringWriter();
        //Трансформируем данные
        transformer.transform( new DOMSource( document ), new StreamResult( writer ) );
        return writer.toString();
    }

    public static void main(String[] args) throws Exception {

        //Запускаем так:
       System.out.println(Solution.toXmlWithComment
               (new First(), "second", "it's a comment"));
    }

    //Для тестирования можно воспользоваться следующими классами:
    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4 = "second2";
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}

/*   Вывод в консоль:

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of <second>]]></second>
    <!--it's a comment-->
    <second/>
    <forth>
        <!--it's a comment-->
        <second>some string</second>
        <!--it's a comment-->
        <second><![CDATA[need CDATA because of <second>]]></second>
    </forth>
    <fifth><![CDATA[need CDATA because of "]]></fifth>
</first>
*/