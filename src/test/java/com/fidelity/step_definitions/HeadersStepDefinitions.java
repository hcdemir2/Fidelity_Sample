package com.fidelity.step_definitions;

import com.fidelity.pages.HomePage;
import com.fidelity.utils.ConfigReader;
import com.fidelity.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HeadersStepDefinitions {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();

    // Scenario 1
    @Given("public user is on the home page")
    public void public_user_is_on_the_home_page() {
        driver.get(ConfigReader.getProperty("fidelity.url"));
    }

    @And("user hovers over {string} header")
    public void user_hovers_over_header(String header) {
        homePage.hoverHeaderItem(header);
    }
    @Then("user should see {string} menu item")
    public void user_should_see_menu_item(String menu_item) {
        Assertions.assertThat(homePage.isMenuItemVisible(menu_item));
    }

}
