package com.example.demo.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
    public  static List<User> list(){
        List<User> list=new ArrayList();
        User user1=new User("1","uer1");
        User user2=new User("2","uer2");
        User user3=new User("3","uer3");
        User user4=new User("4","uer4");
        User user5=new User("5","uer5");
        list.add(user1);
        list.add(user2);
        list.add(user3);list.add(user4);list.add(user5);
        return list;

    }
    public  static void demo(Map<String,Object> map){
        map.keySet().stream().forEach(k-> System.out.println(k+":"+map.get(k)));
    }
    public static void main(String[] args) {
       /* List<User> list=list();
        list.stream().collect(Collectors.toMap(k->k.getName(),v->v));
        Map<String,Object> map=list.stream().collect(Collectors.toMap(k->(k.getId()),v->v.getName()));
        List<String> list2=list.stream().map(User::getId).collect(Collectors.toList());
        list2.stream().forEach(k-> System.out.println(k));
        demo(map);*/
        print(str());
    }
    public static String GetBatchShippingLabel(List<Long> orderId,String token,String code){
        StringBuffer a=new StringBuffer();
        a.append("<GetBatchShippingLabel xmlns=\"http://diqisoft.com/\">");
        orderId.stream().forEach(k->a.append("<long>"+k+"</long>"));
        a.append(tokenXml(token,code));
        a.append("</GetBatchShippingLabel>");
        return "";
    }
    public static String xmlHeader(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                " <soap:Body>";
    }
    public static String tokenXml(String token,String code){
        StringBuffer a=new StringBuffer();
        a.append("<xml>");
        a.append("<code>");
        a.append(code);
        a.append("</code>");
        a.append("<token>");
        a.append(token);
        a.append("</token>");
        a.append("</xml>");
        org.dom4j.io.SAXReader saxReader= new SAXReader();
        try {
            Document doc = DocumentHelper.parseText(a.toString());
            Element rootElt = doc.getRootElement();
            Iterator iter=rootElt.elementIterator("token");
            while (iter.hasNext()){
                Element recordEle = (Element) iter.next();
                System.out.println(recordEle.getData()); ;
            }

        }
        catch (Exception e){

        }
        return  a.toString();
    }
    public static  void print(String str){
        try {
            Document doc = DocumentHelper.parseText(str);
            Element rootElt = doc.getRootElement();
            Iterator iter=rootElt.elementIterator("token");
            while (iter.hasNext()){
                Element recordEle = (Element) iter.next();
                System.out.println(recordEle.getData()); ;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static  String str(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "  <soap:Body>" +
                "    <GetBatchShippingLabel xmlns=\"http://diqisoft.com/\">" +
                "      <orderIdList>" +
                "        <long>long</long>" +
                "        <long>long</long>" +
                "      </orderIdList>" +
                "      <paper>int</paper>" +
                "      <declare>boolean</declare>" +
                "      <code>string</code>" +
                "      <token>string</token>" +
                "    </GetBatchShippingLabel>" +
                "  </soap:Body>" +
                "</soap:Envelope>";
    }
}
