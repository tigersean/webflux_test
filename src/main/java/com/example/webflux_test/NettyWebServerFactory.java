package com.example.webflux_test;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import reactor.netty.http.HttpProtocol;

@Component
public class NettyWebServerFactory implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.addServerCustomizers(httpServer -> httpServer.protocol(HttpProtocol.H2C, HttpProtocol.HTTP11)
                .http2Settings(h2Settings -> h2Settings.maxConcurrentStreams(500)));
    }
}
