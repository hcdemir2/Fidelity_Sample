package com.fidelity.pages;

import com.fidelity.utils.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Getter
public class HomePage extends BasePage{

    @FindBy(xpath = "//h3[.='From our experts']/../..//a")
    private List<WebElement> fromOurExpertsLinks;

    @FindBy(xpath = "//h3[.='Top news']/../..//a")
    private List<WebElement> topNewsLinks;

    public void hoverHeaderItem(String headerText){
        wait.until(ExpectedConditions.visibilityOf(getHeader(headerText)));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(getHeader(headerText)).perform();
        wait.until(ExpectedConditions.attributeToBe(getHeader(headerText), "aria-expanded", "true"));
    }

    public boolean isMenuItemVisible(String menuItemText){
        wait.until(ExpectedConditions.visibilityOf(getMenuItem(menuItemText)));
        return getMenuItem(menuItemText).isDisplayed();
    }
}
