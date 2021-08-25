package com.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductDetailsSteps;
import steps.flowsteps.ProductFlowSteps;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class BaseTest {
    @Managed(uniqueSession = true)
    protected WebDriver driver;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected ProductFlowSteps productFlowSteps;
    @Steps
    protected ProductDetailsSteps productDetailsSteps;
    @Before
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.dev.evozon.com");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
