package org.ginji.hometoolsbackend;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.ginji.hometoolsbackend.cucumber.steps")
public class cucumberTestRunner {
}
