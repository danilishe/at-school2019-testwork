package pages.yandex.market.avto;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.yandex.intrface.Methods.*;

public class YandexMarketAvto  {
    private static Logger log = LogManager.getLogger("Яндекс маркет авто");
    List<SelenideElement> categoriesList;
    SelenideElement categories;

    public void blockPopularCategories() {
        thisElementIsVisible($x("//div[@class='_1jFQqaVTVd']"));
        log.info("Проверяем что отображается блок популярные категории");
    }

    public void blockPopularProduct() {
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb ej2vn2CdLz qUW8qep9Rv _2n8U4OismH'])[1]"));
        log.info("Проверяем что отображается блок популярный продукт");
    }

    public void blockDiscount() {
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb ej2vn2CdLz qUW8qep9Rv _2n8U4OismH'])[3]"));
        log.info("Проверяем что отображается блок скидок");
    }

    public void blockPopularReviews() {
        thisElementIsVisible($x("//*[contains(text(),'Популярные отзывы')]/../../.."));
        log.info("Проверяем что отображается блок популярные отзывы");
    }

    public void blockPopularReviewsCategories() {
        thisElementIsVisible($x("//div[@class='pHw5WzirzZ _3i3Ue8KMNy']"));
        log.info("Проверяем что отображается подкатегории блока популярные отзывы");
    }

    public void randomCategories() {
        categoriesList = $$(By.xpath("//a[@class='_2qvOOvezty SvBTI5gwNn _9qbcyI_fyS']"));
//        categories = randomElement(categoriesList);
        categories = categoriesList.get(1);
        categories.waitUntil(visible, Time()).click();
        log.info("выбираем произвольну категорию - {}",categories.getText());
    }

}
