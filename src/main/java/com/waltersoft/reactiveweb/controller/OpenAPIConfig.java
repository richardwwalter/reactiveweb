package com.waltersoft.reactiveweb.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =
        @Info(
            title = "ReactiveWeb OpenApi",
            description = "Spring Reactive Web Demo Application",
            contact = @Contact(name = "Richard Walter", email = "mailstorichard@gmail.com"),
            version = "v1.0"),
    servers = @Server(url = "http://localhost:9090"))
public class OpenAPIConfig {}
