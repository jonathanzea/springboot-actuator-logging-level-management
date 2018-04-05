# Actuator Management Endpoints - Spring Boot (1.5.10)
   This project exposes an endpoint that in its controller has some loggers in different logging levels diferents loggers so you can test the actuator managament loggers endpoints to see how does it works.

   In spring boot, from version 1.5.x, the ACTUATOR DEPENDENCY includes some other management Endpoints
a part from the normal spring boot ones like /health or /metrics

You'll also find a particular configuration in ```src/main/resources``` to easily access to those endpoint without needing to configure the http security for this management (internal) services.

## How to run (IntelliJ)?

Create a new running configuration (Application type) and just add the main class `Application.java` and run it!

## How does it work?
   Adding the propper dependencies
```
 <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.10.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
        <prom.version>0.2.0</prom.version>
        <micrometer.version>1.0.2</micrometer.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
    </dependencies>
```
Note that I have a parent **with a version specifiedd** that gives me the version for every son dependency

The ...starter-actuator it activates this new Endpoints


## Customizing your own management endpoints exposing
   The application.properties in this project is very simple as you can see, but you also can add more configurations in order to limit the exposing of all the management-internal services you have.

This is an example for a configuration that only expose the HEALTH (Spring boot) and the LOGGERS (Actuator) endpoints.
```
        management.endpoints.web.expose=health
        management.endpoint.health.show-details=never
        management.security.enabled=false
        management.metrics.web.server.auto-time-requests=true
        management.health.defaults.enabled=false
        #Disable all internal default endpoints
        endpoints.enabled=false
        #Enable Health endpoints
        endpoints.health.enabled=true
        #Enable Prometeus Endpoints
        endpoints.prometheus.enabled=true
        endpoints.prometheus.id=metrics
        #Enable  Actuator Loggers Endpoints
        endpoints.loggers.enabled=true
        endpoints.loggers.id=loggers
        management.endpoint.loggers.enabled=true
```

## How to access the endpoints?
- Finally with your normal (Basic Spring Boot web) application running, you would be able
to access these endpoints;

**Check the current log levels**

Method: `GET`
    
    ```http://localhost:8080/loggers```

**Change the log levels**

Method: `POST`
    
    ```http://localhost:8080/loggers/{package name}```
    
Body: `{"configuredLevel": "TRACE"}`


## Further information
*How to enable Spring Boot 1.5.x new Management Actuator Loggers endpoint?*
http://blog.codeleak.pl/2017/03/spring-boot-configure-log-level-in.html



## What if want to configure it mannually (without spring boot management endpoints?
https://rogerwelin.github.io/java/springboot/logback/2017/03/11/change-loglevel-at-runtime-springboot.html
