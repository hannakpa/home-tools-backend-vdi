package org.ginji.hometoolsbackend.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


//este file tiene métodos para iniciar WireMock si no está corriendo, registra stubs(respuestas falsas) y detiene o
// reinicia el mock server. Desde los steps se llamará a estos métodos (así se evita usar stubFor, okJson, etc.
// dentro de los tests)
//@CucumberContextConfiguration
//@EnableWireMock
//@SpringBootTest
@Component
public class WireMockUtilProduct {

    @Value("${wiremock.server.baseUrl}")
    private String wireMockUrl;

    public void stubProduct(String productName) {
        String jsonResponse = String.format("{\"title\":\"%s\"}", productName);
        stubFor(get("/api/products/" + productName).willReturn(okJson(jsonResponse)));
    }

    public String getBaseUrl() {
        System.out.println(wireMockUrl);
        return wireMockUrl;
    }
}

