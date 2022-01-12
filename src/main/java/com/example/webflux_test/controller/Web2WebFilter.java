/*
 * ----------------------------------------------------------------------
 * COPYRIGHT Ericsson 2021
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 * ----------------------------------------------------------------------
 */

package com.example.webflux_test.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


import java.nio.charset.StandardCharsets;

@Component
public class Web2WebFilter implements WebFilter {

  private final String oomString = "oom messagess";

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    String path = exchange.getRequest().getPath().value();

    if (path.startsWith("/reject")) {
      ServerHttpResponse response = exchange.getResponse();
      response.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
      return response.writeWith(
              Mono.just(response.bufferFactory().wrap(oomString.getBytes(StandardCharsets.UTF_8))));
    }else {
     return chain.filter(exchange);
    }

   }
}
