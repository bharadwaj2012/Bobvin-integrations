mvn springboot:run

Webcrowler service exposed to - http://localhost:8080/WebCrawler

Input - {"webCrawlerList":[{"url":"https://camel.apache.org","id":1,"searchText":"Camel Spring Boot"},{"url":"https://activemq.apache.org","id":2,"searchText":"ActiveMQ Artemis"}]}

input description: 

url - website url 

id - url sequence id (to identify in case of multiple urls)

searchText - search the word from website content