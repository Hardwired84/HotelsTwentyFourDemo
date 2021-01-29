package tests;

import browser.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        Browser.setBrowserPosition();
        Browser.setBrowserSize();
    }

    @After
    public void tearDown() {
        Browser.closeDriver();
    }
}
