package org.ginji.hometoolsbackend;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("features")
//@SelectClasspathResource("cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.ginji.hometoolsbackend.cucumber.steps")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @IGNORE")
public class cucumberTestRunner {
}
