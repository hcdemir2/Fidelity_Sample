package com.fidelity.pages;

import com.fidelity.utils.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public abstract class BasePage {

    // Initialize elements in BasePage constructor
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // A small sample of elements common to all pages on fidelity.com
    @FindBy(xpath = "//a[@href='https://www.fidelity.com/?bar=p']")
    private WebElement fidelityLogo;

    @FindBy(linkText = "Customer Service")
    private WebElement customerServiceLink;

    @FindBy(linkText = "Profile")
    private WebElement profileLink;

    @FindBy(linkText = "Open an Account")
    private WebElement openAnAccountLink;

    @FindBy(linkText = "Virtual Assistant")
    private WebElement virtualAssistantLink;

    @FindBy(linkText = "Log In")
    private WebElement logInLink;

    @FindBy(linkText = "Accounts & Trade")
    private WebElement accountsAndTradeHeader;

    @FindBy(xpath = "//div[@class='pnsh']/a[.='Planning & Advice']")
    private WebElement planningAndAdviceHeader;

    @FindBy(linkText = "News & Research")
    private WebElement newsAndResearchHeader;

    @FindBy(linkText = "Products")
    private WebElement productsHeader;

    @FindBy(linkText = "Why Fidelity")
    private WebElement whyFidelityHeader;

    // Common methods to be used across all pages
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    // Navigates to header link that has same text the parameter string
    public void navigateToHeaderLink(String linkText){
        String linkXpath = "(//ul[@class='pntl pnlogout'])[1]//a[contains(. , '" + linkText + "')]";

        WebElement linkElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(linkElement)).click();
    }

    public WebElement getHeader(String headerText){
        String headerXpath = "//div[@role='navigation']//div/a[contains(. , '" + headerText + "')]";
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerXpath)));
    }

    public WebElement getMenuItem(String menuItemText){
        String menuItemXpath = "//div[@role='navigation']//li/a[contains(. , '" + menuItemText + "')]";
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuItemXpath)));
    }

    // Navigates to WebElement, does not wait Explicitly after click
    public void navigateTo(WebElement elementToClick){
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
    }

    // Navigates to WebElement, waits Explicitly for second WebElement
    public void navigateTo(WebElement elementToClick, WebElement elementToBeLoaded){
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
        wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
    }
}
