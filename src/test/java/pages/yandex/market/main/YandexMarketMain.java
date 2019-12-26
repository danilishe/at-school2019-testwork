package pages.yandex.market.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.yandex.intrface.Methods;

import static com.codeborne.selenide.Selenide.*;
import static pages.yandex.intrface.Methods.*;
import static com.codeborne.selenide.Condition.visible;

public class YandexMarketMain implements  Methods {
    
    private static Logger log = LogManager.getLogger("Яндекс маркет");

    public void openUrl() {
        open("https://market.yandex.ru/");
    }

    public void blockSearchString() {
        thisElementIsVisible($x("//input[@id='header-search']"));
        log.info("Проверяем что отображается строка поиска");
    }

    public void topStockBanner(){
        thisElementIsVisible($x("//a[@class='_2qvOOvezty _19m_jhLgZR _1TFGF7RAta']"));
        log.info("Проверяем что отображается вверхний баннер с акциями");
    }

    public void mainStockBanner() {
        thisElementIsVisible($x("//img[@class='_10KRGrktZR']"));
        log.info("Проверяем что отображается основной баннер с акциями");
    }

    public void blockRecommendedProducts() {
        thisElementIsVisible($x("(//div[@data-12934f64])[2]"));
        log.info("проверяем что отображается блок рекомендуемые товары");
    }

    public void blockJournalMarket() {
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb _2Q-c7mbjYB qUW8qep9Rv _2n8U4OismH'])[1]"));
        log.info("проверяем что отображается блок журнал маркета");
    }

    public void blockSubscription() {
        thisElementIsVisible($x("//div[@class='lqAHp6x91f']"));
        log.info("проверяем что отображается блок для подписки");
    }

    public void blockPopularBrands() {
        thisElementIsVisible($x("(//div[@class='eDeStLBs54'])[2]"));
        log.info("проверяем что отображается блок популярные товары");
    }

    public void blockReviewsTheBestProduct() {
        thisElementIsVisible($x("(//div[@class='section N9o4gAuSnb _2Q-c7mbjYB qUW8qep9Rv _2n8U4OismH'])[2]"));
        log.info("проверяем что отображается блок популярные отзывы");
    }

    public void blockFooter() {
        thisElementIsVisible($x("//div[@class='_2UK6LnxjkG']"));
        log.info("проверяем что отображается блок подвала");
    }

    public void blocksSideBar() {
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[1]"));
        log.info("проверяем что отображается первый рекламный баннер");
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[2]"));
        log.info("проверяем что отображается второй рекламный баннер");
        thisElementIsVisible($x("(//div[@class='_32MQPGi7g3']//img[@class='mdZZQZuEAL'])[3]"));
        log.info("проверяем что отображается третий рекламный баннер");
    }

    public void clickHeaderBtnCity() {
        $x("//span[@class='link header2-menu__item header2-menu__item_type_region header2-region region-form-opener i-bem n-region-popup-opener _popup2-destructor _popup2-destructor_js_inited']//span[@class='header2-menu__text']")
                .waitUntil(visible, Time()).click();
        log.info("Клик на ссылку сменить регион");
    }

    public void inputCity(String city) {
        $x("//input[@placeholder='Укажите другой регион']")
                .setValue(city).pressEnter().pressEnter();
        log.info("Вводим город {} в поле",city);
    }

    public void detectAutomatically() {
        $x("//a[@class='link region-select-form__auto-definition']").waitUntil(visible,Time()).click();
        log.info("Клик на определять город автоматически");
    }

    public void clickYesThankYou() throws InterruptedException {
        $x("//div[@class='n-region-notification__actions layout layout_display_flex']//div[1]").waitUntil(visible,Time()).click();
        log.info("Клик в попапе, \"Да спасибо\"");
    }

    public void clickAllCategories() {
        $x("//span[text()='Все категории']").waitUntil(visible, Time()).click();
        log.info("Клик на все категории");
    }

    public void blockAllCategories() {
        thisElementIsVisible($x("//div[@class='n-w-tabs__vertical-tabs']"));
        log.info("проверяем что отображается блок все категории");
    }

    public void hoverBtnCategoriesCar() {
        $x("(//div//*[text()='Авто'])[1]").waitUntil(visible, Time()).hover();
        log.info("наводим курсор на категорию \"Авто\"");
    }

    public void blockCarCategories() {
        thisElementIsVisible($x("//div[@class='n-w-tabs__content-column']"));
        log.info("проверяем что отображается блок \"Авто\"");
    }

    public void clickBtnCategoriesCar() {
        $x("(//div//*[text()='Авто'])[1]").waitUntil(visible, Time()).click();
        log.info("кликаем на категорию \"Авто\"");
    }

    public void clickCategoriesTwo() {
        $x("//a[@data-712821aa][text()='Аудио- и видеотехника']").waitUntil(visible, Time()).click();
        log.info("кликаем на категорию \"Аудио- и видеотехника\"");
    }
    
}

//waitUntil(enabled, 20000)