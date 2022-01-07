package com.ivoronline.test2;

import com.ivoronline.test2.utils.UtilSOAP;
import com.ivoronline.test2.utils.UtilXML;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController
public class controllers {

  @RequestMapping("Test")
  Document test(@RequestBody String requestSOAP) throws Exception {
    //Document requestDocument = UtilSOAP.extractSOAPBody(requestSOAP);
    //Document requestDocument = UtilSOAP.extractSOAPBody(requestSOAP);

    InputStream inputStream      = new ByteArrayInputStream(requestSOAP.getBytes());
    SOAPMessage responseXML = MessageFactory.newInstance().createMessage(null, inputStream);
    Node        node        = responseXML.getSOAPBody().getElementsByTagName("CustomerDataRequest").item(0);
    //Node        node2 = node.("CustomerDataRequest").item(0);

    Document newDocument = UtilXML.nodeToDocument(node);



    //Document    responseDocument = responseXML.getSOAPPart().getContent().;

    return newDocument;
  }

}
