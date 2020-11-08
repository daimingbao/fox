package com.supfox.dubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class ProviderStarter {


    public static void main(String[] args) throws InterruptedException, IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.in.read();
    }
}
