# cloud-config
cloud-config is a multi-tenant-aware configuaration center based on Zookeeper and tightly integrated with Spring framework which is inspired by [Centralized Application Configuration with Spring and Apache ZooKeeper](http://www.infoq.com/presentations/spring-apache-zookeeper).

## How to Start
1. Run following scripts to build entire project after sync the latest code  
   cd cloud-config-ui && npm install && cd .. && mvn clean install
2. Install & Start Zookeeper server
3. Start cloud-config-server application  
   java -Dnamespace={namespace} -Dconfig.center.url={zk.url} -jar cloud-config-server/target/cloud-config-server-1.0.0-SNAPSHOT.jar  
4. Go to http://localhost:8001/ in browser

## How to Use
1. import cloud-config-client as your project maven dependency  
2. simple usage configuration:  

	```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:cc="http://www.squirrelframework.org/schema/config"
       xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.squirrelframework.org/schema/config
            http://www.squirrelframework.org/schema/config/cloud-config.xsd">
    	<!-- config zookeeper client -->
    	<cc:zk-client connection-string="127.0.0.1:2181"/>
		<!-- config as property place holder -->
		<cc:zk-property-placeholder path="/mail, /query" location="classpath:query-server.properties"/>
    	<!-- config as jdbc dataSource -->
    	<cc:zk-jdbc-datasource id="dataSource" path="/database/mydb" resource-type="C3P0"/>
	</beans>
	```

## Features  
1. System properties config and lookup    
2. Single or Multi-tenant-aware DataSource config and lookup    
3. Custom resource object config and lookup  

## Rencent Goal
1. Integrate with Docker to provide live demo
2. Enhance UI and documentation