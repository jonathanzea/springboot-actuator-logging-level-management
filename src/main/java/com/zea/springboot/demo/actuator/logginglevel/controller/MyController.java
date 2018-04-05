package com.zea.springboot.demo.actuator.logginglevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @RequestMapping("/helloworld")
    public String demoEndpoint(){
        LOGGER.error("ERROR: AH! ERROR!! RUN FOR YOUR LIVES!I'm an e33or");

        LOGGER.warn("WARNING: Hey! IM warning you...!");

        LOGGER.info("INFO: Hi my friend! I'm just information...");

        LOGGER.debug("DEBUG: Howdy! I'm an debug -o-");

        LOGGER.trace("TRACE: Salutes Mister! I'm an t r a c e .");

        return "hello";
    }
}
