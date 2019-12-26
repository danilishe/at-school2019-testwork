package pages.yandex.market.avto;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.yandex.intrface.Methods.*;

public class YandexMarketAvto  {
    private static Logger log = LogManager.getLogger("Яндекс маркет авто");
    List<SelenideElement> categoriesList;

    public void blockPopularCategories() {
        log.info("Проверяем что отображается блок популярные категории");
        thisElementIsVisible($x("//div[@class='_1jFQqaVTVd']"));
    }

    public void blockPopularProduct() {
        log.info("Проверяем что отображается блок популярный продукт");
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb ej2vn2CdLz qUW8qep9Rv _2n8U4OismH'])[1]"));
    }

    public void blockDiscount() {
        log.info("Проверяем что отображается блок скидок");
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb ej2vn2CdLz qUW8qep9Rv _2n8U4OismH'])[3]"));
    }

    public void blockPopularReviews() {
        log.info("Проверяем что отображается блок популярные отзывы");
        thisElementIsVisible($x("//*[contains(text(),'Популярные отзывы')]/../../.."));
    }

    public void blockPopularReviewsCategories() {
        log.info("Проверяем что отображается подкатегории блока популярные отзывы");
        thisElementIsVisible($x("//div[@class='pHw5WzirzZ _3i3Ue8KMNy']"));
    }

    public void randomCategories() {
        categoriesList = $$(By.xpath("//div[@data-452ecda2=\"true\"]/div"));
//      randomElement(categoriesList).click();
        categoriesList.get(1).click();
        log.info("Выбираем произвольну категорию");
    }
}
