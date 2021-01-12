package com.RunnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/src/test/resources/FeatureFiles/HomePage.feature",glue="com.stepDefinationfiles")
public class ZooplaRunnerFile {
	

}
