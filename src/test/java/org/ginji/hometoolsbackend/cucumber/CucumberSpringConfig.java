
package org.ginji.hometoolsbackend.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@EnableWireMock(
        @ConfigureWireMock(
            port = 8080))
public class CucumberSpringConfig {
}
