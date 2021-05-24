package com.web.crawler.rest.model;

import java.util.ArrayList;
import java.util.List;

public class WebCrawlerObjects 
{
    private List<WebCrawlerObject> webCrawlerList;
    
    public List<WebCrawlerObject> getwebCrawlerList() {
        if(webCrawlerList == null) {
            webCrawlerList = new ArrayList<>();
        }
        return webCrawlerList;
    }
 
    public void setwebCrawlerList(List<WebCrawlerObject> webCrawlerList) {
        this.webCrawlerList = webCrawlerList;
    }
}
