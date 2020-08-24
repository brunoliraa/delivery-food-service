package com.br.paymentservice.service;

import com.br.paymentservice.dto.TransactionSearchResult;
import com.br.paymentservice.dto.TransactionStatus;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class ConvertXmlToPojo {

    public void convertToTransactioSearchResult(String xml){
        try{
            JAXBContext context = JAXBContext.newInstance(TransactionSearchResult.class);
            Unmarshaller un = context.createUnmarshaller();
            TransactionSearchResult transaction = (TransactionSearchResult) un.unmarshal(new StringReader(xml));
            System.out.println(transaction.toString());
        }catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    public TransactionStatus convertTransaction(String xml){
        try{
            JAXBContext context = JAXBContext.newInstance(TransactionStatus.class);
            Unmarshaller un = context.createUnmarshaller();
            TransactionStatus transaction = (TransactionStatus) un.unmarshal(new StringReader(xml));
//            System.out.println(transaction.toString());
            return transaction;
        }catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
