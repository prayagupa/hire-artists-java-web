hire-artists service
==================

Technologies 
------------

maven, https://maven.apache.org/download.cgi

The project is created using `maven-archetype-webapp`.


Dependency
----------

```
<project>
    [...]
    <!-- jackson mapper -->
    <dependency>
        <groupId>org.codehaus.jackson</groupId>
        <artifactId>jackson-mapper-asl
        </artifactId>
        <version>1.9.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.codehaus.jackson</groupId>
        <artifactId>jackson-core-asl</artifactId>
        <version>1.9.0</version>
    </dependency>
    <!-- jackson mapper -->
    [...]
</project>
```


View Resolver
-------------
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd"
xmlns:p="http://www.springframework.org/schema/p">

        <!-- Root Context: defines shared resources visible to all other web components -->
        <bean
        class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
                <property name="mediaTypes">
                    <map>
                    <entry key="html" value="text/html" />
                    <entry key="json" value="application/json" />
                    </map>
                </property>
                <property name="viewResolvers">
                    <list>
                    <bean id="viewResolver"
                    class="org.springframework.web.servlet.view.InternalResourceViewResolver"
                    p:viewClass="org.springframework.web.servlet.view.JstlView"
                    p:prefix="/WEB-INF/jsp/" p:suffix=".jsp" />
                    </list>
                </property>
                <property name="defaultViews">
                    <list>
                    <bean
                    class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
                    </list>
                </property>
        </bean>
        
        <import resource="classpath:/WEB-INF/rest-layers.xml" />
</beans>
```


run-app
-------

change `db.properties`

```bash
$ mvn jetty:run

## check url
## http://localhost:8080/hire-artists/artist/list
```

FIXME
----

```bash
11:48:23.150 [main] ERROR o.h.proxy.pojo.BasicLazyInitializer - Javassist Enhancement failed: com.hireartists.domain.Artist
java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @741741d0
	at java.base/java.lang.reflect.AccessibleObject.throwInaccessibleObjectException(AccessibleObject.java:388) ~[na:na]
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:364) ~[na:na]
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:312) ~[na:na]
	at java.base/java.lang.reflect.Method.checkCanSetAccessible(Method.java:203) ~[na:na]
	at java.base/java.lang.reflect.Method.setAccessible(Method.java:197) ~[na:na]
	at javassist.util.proxy.SecurityActions.setAccessible(SecurityActions.java:102) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.FactoryHelper.toClass2(FactoryHelper.java:180) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.FactoryHelper.toClass(FactoryHelper.java:163) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.ProxyFactory.createClass3(ProxyFactory.java:501) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.ProxyFactory.createClass2(ProxyFactory.java:486) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.ProxyFactory.createClass1(ProxyFactory.java:422) ~[javassist-3.12.0.GA.jar:na]
	at javassist.util.proxy.ProxyFactory.createClass(ProxyFactory.java:394) ~[javassist-3.12.0.GA.jar:na]
	at org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer.getProxyFactory(JavassistLazyInitializer.java:162) ~[hibernate-core-3.6.6.Final.jar:3.6.6.Final]
```