package com.web.crawler.rest.model;

public class WebCrawlerObject {

	
	public WebCrawlerObject() {

    }

    public WebCrawlerObject(String url, int id, String searchText) {
        super();
        this.url = url;
        this.id = id;
        this.searchText=searchText;
        
    }
	
	private String url;
	private int id;
	private String searchText;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the searchText
	 */
	public String getSearchText() {
		return searchText;
	}
	/**
	 * @param searchText the searchText to set
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	
}
