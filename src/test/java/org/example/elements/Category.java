package org.example.elements;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class Category {
    private Logger log = LogManager.getLogger(Category.class);

    private static SelenideElement category = $x("//*[@data-apiary-widget-name='@MarketNode/TopMenuTabs']//*[@aria-orientation='vertical']");
    private static SelenideElement navigation = $x("//*[@data-apiary-widget-name='@MarketNode/TopMenuTabs']//*[@data" +
            "-apiary-widget-name=\"@MarketNode/NavigationTree\"]");
    private static SelenideElement banners = $x("//*[@data-apiary-widget-name='@MarketNode/TopMenuTabs']//*[@data" +
            "-apiary-widget-name=\"@MarketNode/Showcase\"]");
    private static SelenideElement productItem = $x("//*[text()='Продукты']/preceding-sibling::*//..");

    public Category() {
        category.isDisplayed();
        navigation.isDisplayed();
        banners.isDisplayed();
    }

    public void selectItem() {
        log.trace("Выбираем категорию Продукты");
        productItem.click();
    }
}
