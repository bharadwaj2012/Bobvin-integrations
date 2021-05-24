package com.web.crawler.rest.webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@SpringBootApplication
/**
 * @author bharadwaj
 *
 */
public class WebCrawlerAppRunnableExecutor implements Runnable{

	private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerAppRunnableExecutor.class);
	//private static final int MAX_DEPTH =3;
	private Thread thread;
	private String url;
	private ArrayList<String> visitedLinks = new ArrayList<String>();
	private int id;
	private String searchText;
	ExecutorService executor = null;
	
	/**
	 * @param link
	 * @param num
	 * @param value
	 */
	public WebCrawlerAppRunnableExecutor(String link, int num, String value) {
		LOGGER.info("webcrawler BOT Created");
		url=link;
		id = num;
		searchText =value;
		executor = Executors.newFixedThreadPool(10);
		executor.execute(this);
		executor.shutdown();
		/*thread = new Thread(this);
		thread.start();*/
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		crawl(url);
	}
	
	/**
	 * @param url
	 */
	private void crawl( String url) {
		//if(level <= MAX_DEPTH) {
			Document doc= request(url);
			if(doc !=null && !visitedLinks.contains(url)) {
				for(Element link : doc.select("a[href]")) {
					String next_link=link.absUrl("href");
					if(visitedLinks.contains(next_link)) {
						crawl(next_link);
					}
				}
			}
		//}
	}

	/**
	 * @param url
	 * @return
	 */
	private Document request(String url) {
		try {
			Connection con=Jsoup.connect(url);
			Document doc= con.get();
			if(con.response().statusCode() ==200) {
				LOGGER.info("\n**Web spider BOT Id -->" +id+ " Received webpage from --> {}", url);
				String title = doc.title();
				LOGGER.info("\n**Web spider BOT Id -->" +id+ " document title --> {}", title);
				LOGGER.info("\n**Web spider BOT Id -->" +id+ " document matching text --> {}",doc.getElementsMatchingOwnText(searchText));
				visitedLinks.add(url);
				return doc;
			}
			return null;
		}
		catch(IOException e) {
			return null;
		}
	}
	
	/**
	 * @return
	 */
	public Thread getThread() {
		
		return thread;
	}
	
	/*public static void main(String[] args) {
		
		ArrayList<WebCrawlerTransferObject> inputList =new ArrayList<>();
		Map<String, String> inputMap=ReadInputPrameters.getInput(args);
		
		
		//for(int i=0; i<=inputMap.size(); i++) {
		if(inputMap.containsKey("link") && inputMap.containsKey("searchText")) {
			StringTokenizer tokenizer = new StringTokenizer(inputMap.get("link"), ";");
			
			 while (tokenizer.hasMoreElements()) {
				 inputList.set(index, element)
				 new WebCrawlerAppMain(tokenizer.nextToken(), tokenizer.countTokens(), inputMap.get("searchText"));
			    }
			
			
		}
		//}
		
		bots.add(new WebCrawlerAppMain("https://camel.apache.org",1,"Camel Spring Boot"));
		bots.add(new WebCrawlerAppMain("https://camel.apache.org/components/latest/eips/enterprise-integration-patterns.html",2,"Components"));
		bots.add(new WebCrawlerAppMain("https://activemq.apache.org",3,"ActiveMQ Artemis"));
		bots.add(new WebCrawlerAppMain("https://cxf.apache.org/",4,"Download"));
		
		for(WebCrawlerAppMain web: bots) {
			try {
				
				web.getThread().join();
			}catch(InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
		}
		
	}*/
	
}
