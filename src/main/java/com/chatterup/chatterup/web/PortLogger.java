package com.chatterup.chatterup.web;

import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortLogger implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        System.out.println("========== SERVER IS LISTENING ==========");
        System.out.println("PORT = " + event.getWebServer().getPort());
    }
}