# Actuator Management Endpoints - Spring Boot (1.5.10)
This project exposes an endpoint that in its controller have diferents loggers at diferents levels so you can test the actuator managament loggers endpoints to see how it works

## Management Endpoints

You'll also find a configuration in ```src/main/resources``` to easily enter those endpoints

## How to run (IntelliJ)?

Create a new running configuration (Application type) and just add the main class `Application.java` and run it!

## How does it work?
 In spring boot, from version 1.5.x, the ACTUATOR DEPENDENCY includes some other management Endpoints
a part from the normal spring boot ones like /health and /metrics

### Adding the propper dependencies
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
Note that I have a parent that gives me the parent version for every dependency
The ...starter-actuator it activates this new Endpoints

- Your application, in src/resources, must have an application.properties, and
this should be its content

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

As you can see theres a custimized configuration for the MANAGEMENT ENDPOINTS 
With this configuration, you can LIMIT the management endpoints to expose
just HEALTH AND LOGGER endpoints. But if u comment from line 44 to 55
you'll see the complete list of MANAGEMENT ENDPOINTS

- Finally with your normal (Basic Spring Boot web) application, you would be able
to access these endpoints;

Check the current log levels
    GET
    http://localhost:8080/loggers

Change the log levels
    POST
    http://localhost:8080/loggers{package name}
    {"configuredLevel": "TRACE"}


Further information
*How to enable Spring Boot 1.5.x new Management Actuator Loggers endpoint?*
`http://blog.codeleak.pl/2017/03/spring-boot-configure-log-level-in.html`



MANUAL CUSTOMIZE LOG LEVEL
https://rogerwelin.github.io/java/springboot/logback/2017/03/11/change-loglevel-at-runtime-springboot.html
