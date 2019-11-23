package com.cgi.demo.modify.service;

import com.cgi.demo.modify.publisher.IRecordPublisher;
import com.cgi.demo.modify.util.XmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
public class ModifyAndSendService implements IService{

    @Autowired
    IRecordPublisher<String> publisher;

    @Override
    public void transformAndSend(String message) {

        Document document = XmlConverter.convertStringToXMLDocument(message);

        if (document != null) {

            String  title = document.getElementsByTagName("app").item(0).getFirstChild().getLastChild().getTextContent();

            String replacedString = title.replace("telecom", "telco");

            document.getElementsByTagName("app").item(0).getFirstChild().getLastChild().setTextContent(replacedString);

            String xmlString = XmlConverter.writeXmlDocumentToString(document);

            publisher.publish(xmlString);


        }
    }
}
