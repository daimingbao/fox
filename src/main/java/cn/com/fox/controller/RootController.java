package cn.com.fox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class RootController {

    public RootController() {
        log.info("init RootController");
    }

    @RequestMapping("/")
    public String index() {
        return "hello world ";
    }

}
