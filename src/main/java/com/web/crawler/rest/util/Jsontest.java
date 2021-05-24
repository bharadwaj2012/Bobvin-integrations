package com.web.crawler.rest.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.web.crawler.rest.model.WebCrawlerObject;
import com.web.crawler.rest.model.WebCrawlerObjects;

public class Jsontest {

    public static void main(String[] args) throws IOException {

    	WebCrawlerObjects list = new WebCrawlerObjects();
    	
        List<WebCrawlerObject> objlist= new ArrayList<WebCrawlerObject>();
        WebCrawlerObject obj = new WebCrawlerObject();
        obj.setUrl("https://camel.apache.org");
        obj.setId(1);
        obj.setSearchText("Camel Spring Boot");
        objlist.add(obj);
        WebCrawlerObject obj2 = new WebCrawlerObject();
        obj2.setUrl("https://activemq.apache.org");
        obj2.setId(2);
        obj2.setSearchText("ActiveMQ Artemis");
        objlist.add(obj2);
        WebCrawlerObject obj3 = new WebCrawlerObject();
        obj3.setUrl("https://cxf.apache.org");
        obj3.setId(3);
        obj3.setSearchText("Download");
        objlist.add(obj3);
        WebCrawlerObject obj4 = new WebCrawlerObject();
        obj4.setUrl("https://kafka.apache.org");
        obj4.setId(4);
        obj4.setSearchText("HIGH THROUGHPUT");
        objlist.add(obj4);
        WebCrawlerObject obj5 = new WebCrawlerObject();
        obj5.setUrl("https://servicemix.apache.org");
        obj5.setId(5);
        obj5.setSearchText("legacy support for the JBI");
        objlist.add(obj5);
        list.setwebCrawlerList(objlist);
        String json = new Gson().toJson(list);
		System.out.println("Jason input string -->"+json);

    }


}
