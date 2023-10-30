package com.example.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		WireMockServer wireMockServer = new WireMockServer(8081);
		wireMockServer.stubFor(get(urlEqualTo("/values/id1")).willReturn(okJson("{\"value\": \"value1\"}")));
		wireMockServer.stubFor(get(urlEqualTo("/values/id2")).willReturn(okJson("{\"value\": \"value2\"}")));
		wireMockServer.start();

		SpringApplication.run(DemoApplication.class, args);
	}

}
