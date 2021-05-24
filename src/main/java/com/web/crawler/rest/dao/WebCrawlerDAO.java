package com.web.crawler.rest.dao;

import org.springframework.stereotype.Repository;

import com.web.crawler.rest.model.WebCrawlerObject;
import com.web.crawler.rest.model.WebCrawlerObjects;

/**
 * @author bharadwaj
 *
 */
@Repository
public class WebCrawlerDAO 
{
    private static WebCrawlerObjects list = new WebCrawlerObjects();
    
    
    public WebCrawlerObjects getWebCrawlerobjects() 
    {
        return list;
    }
    
    public void addWebCrawlerObject(WebCrawlerObject webCrawlerObject) {
        list.getwebCrawlerList().add(webCrawlerObject);
    }
}
