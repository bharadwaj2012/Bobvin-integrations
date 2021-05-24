package com.web.crawler.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.crawler.rest.model.WebCrawlerObjects;
import com.web.crawler.rest.webcrawler.WebCrawlerAppRunnableExecutor;


/**
 * @author bharadwaj
 *
 */
@RestController
@RequestMapping(path = "/WebCrawlerObjects")
public class WebCrawlerController 
{
    
    /**
     * @param webCrawlerObjects
     * @return String
     * @throws Exception
     */
    @PostMapping(path= "/", consumes = "application/json", produces = "application/text")
    public ResponseEntity<String> addWebCrawlerObject(
                        @RequestBody WebCrawlerObjects webCrawlerObjects) 
                 throws Exception 
    {       
        
    	webCrawlerObjects.getwebCrawlerList().forEach(inObj -> {
    	new WebCrawlerAppRunnableExecutor(inObj.getUrl(), inObj.getId(), inObj.getSearchText());
    	});
        
        
        //Send location in response
        return new ResponseEntity<String>("Web crawler processing is successful, Plesae refer to the logs", 
        		   HttpStatus.OK);
    }
}
