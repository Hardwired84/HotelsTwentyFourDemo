package pageobjects;

public abstract class BasePage {
    public abstract boolean verify();

    public abstract void waitForPageLoaded();
}
