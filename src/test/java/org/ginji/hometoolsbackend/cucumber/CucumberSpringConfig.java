
package org.ginji.hometoolsbackend.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.ginji.hometoolsbackend.util.WireMockUtilProduct;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//you must explicitly configure WireMock as a Spring Bean, otherwise the WireMock server will not be injected when using the Cucumber runner.
@EnableWireMock(@ConfigureWireMock(port = 8080))
public class CucumberSpringConfig {
}
