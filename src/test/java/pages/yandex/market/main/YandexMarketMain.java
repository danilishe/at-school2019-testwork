package pages.yandex.market.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static pages.yandex.intrface.Methods.thisElementIsVisible;

public class YandexMarketMain  {

    int time = 7000;
    private static Logger log = LogManager.getLogger("Яндекс маркет");

    public void openUrl() throws IOException {
        log.info("Открываем страницу Яндекс маркет");
        open("https://market.yandex.ru/");
    }

    public void blockSearchString() {
        log.info("Проверяем что отображается строка поиска");
        thisElementIsVisible($x("//input[@id='header-search']"));
    }

    public void topStockBanner(){
        log.info("Проверяем что отображается вверхний баннер с акциями");
        thisElementIsVisible($x("//a[@class='_2qvOOvezty _19m_jhLgZR _1TFGF7RAta']"));
    }

    public void mainStockBanner() {
        log.info("Проверяем что отображается основной баннер с акциями");
        thisElementIsVisible($x("//img[@class='_10KRGrktZR']"));
    }

    public void blockRecommendedProducts() {
        log.info("проверяем что отображается блок рекомендуемые товары");
        thisElementIsVisible($x("(//div[@data-12934f64])[2]"));
    }

    public void blockJournalMarket() {
        log.info("проверяем что отображается блок журнал маркета");
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb _2Q-c7mbjYB qUW8qep9Rv _2n8U4OismH'])[1]"));
    }

    public void blockSubscription() {
        log.info("проверяем что отображается блок для подписки");
        thisElementIsVisible($x("//div[@class='lqAHp6x91f']"));
    }

    public void blockPopularBrands() {
        log.info("проверяем что отображается блок популярные товары");
        thisElementIsVisible($x("(//div[@class='eDeStLBs54'])[2]"));
    }

    public void blockReviewsTheBestProduct() {
        log.info("проверяем что отображается блок популярные отзывы");
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb _2Q-c7mbjYB qUW8qep9Rv _2n8U4OismH'])[2]"));
    }

    public void blockFooter() {
        log.info("проверяем что отображается блок подвала");
        thisElementIsVisible($x("//div[@class='_2UK6LnxjkG']"));
    }

    public void blocksSideBar() {
        log.info("проверяем что отображается первый рекламный баннер");
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[1]"));
        log.info("проверяем что отображается второй рекламный баннер");
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[2]"));
        log.info("проверяем что отображается третий рекламный баннер");
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[3]"));
    }

    public void clickHeaderBtnCity() {
        log.info("Клик на ссылку сменить регион");
        $x("//span[@class='link header2-menu__item header2-menu__item_type_region header2-region region-form-opener i-bem n-region-popup-opener _popup2-destructor _popup2-destructor_js_inited']//span[@class='header2-menu__text']")
                .waitUntil(visible, time).click();
    }

    public void inputCity(String city) {
        log.info("Вводим город {} в поле",city);
        $x("//input[@placeholder='Укажите другой регион']")
                .setValue(city).pressEnter().pressEnter();
    }

    public void detectAutomatically() {
        log.info("Клик на определять город автоматически");
        $x("//a[@class='link region-select-form__auto-definition']").waitUntil(visible,time).click();
    }

    public void clickYesThankYou() throws InterruptedException {
        log.info("Клик в попапе, \"Да спасибо\"");
        $x("//div[@class='n-region-notification__actions layout layout_display_flex']//div[1]").waitUntil(visible,time).click();
    }

    public void clickAllCategories() {
        log.info("Клик на все категории");
        $x("//span[text()='Все категории']").waitUntil(visible, time).click();
    }

    public void blockAllCategories() {
        log.info("проверяем что отображается блок все категории");
        thisElementIsVisible($x("//div[@class='n-w-tabs__vertical-tabs']"));
    }

    public void hoverBtnCategoriesCar() {
        log.info("наводим курсор на категорию \"Авто\"");
        $x("(//div//*[text()='Авто'])[1]").waitUntil(visible, time).hover();
    }

    public void blockCarCategories() {
        log.info("проверяем что отображается блок \"Авто\"");
        thisElementIsVisible($x("//div[@class='n-w-tabs__content-column']"));
    }

    public void clickBtnCategoriesCar() {
        log.info("кликаем на категорию \"Авто\"");
        $x("(//div//*[text()='Авто'])[1]").waitUntil(visible, time).click();
    }

    public void clickCategoriesTwo() {
        log.info("кликаем на категорию \"Аудио- и видеотехника\"");
        $x("//a[@data-712821aa][text()='Аудио- и видеотехника']").waitUntil(visible, time).click();
    }
}

