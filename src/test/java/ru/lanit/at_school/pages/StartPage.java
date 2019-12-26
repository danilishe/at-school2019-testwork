package ru.lanit.at_school.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.lanit.at_school.pages.Randomizer.random;

public class StartPage {
    public StartPage open() {
        Selenide.open("https://market.yandex.ru");
        return this;
    }

    public StartPage pagecheck() throws AWTException {
        Logger log = LogManager.getLogger();
// Проверка отображения строки поиска
        try {
            $x("//input[@id=\"header-search\"]").shouldBe(Condition.visible);
// Проверка отображения верхнего баннера с акциями
            $x("//div[@data-zone-name=\"HeadBanner\"]").shouldBe(Condition.visible);
// Проверка отображения основного баннера с акциями
            $x("(//div[@data-zone-name=\"Banner\"])[1]").shouldBe(Condition.visible);
// Проверка отображения рекомендуемые товары
            $x("(//div[@class=\"theme_light\"])[1]").shouldBe(Condition.visible);
//      Костыли для скролла динамического отображения блоков
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_PAGE_UP);
// Проверка отображения блока Журнала маркета
            $x("(//div[@class=\"theme_light\"])[7]").shouldBe(Condition.visible);
// Проверка отображения отзывов на лучшие товары
            $x("(//div[@class=\"theme_light\"])[8]").shouldBe(Condition.visible);
// Проверка отображения блока популярных брендов
            $x("(//div[@class=\"theme_light\"])[9]").shouldBe(Condition.visible);
// Проверка отображения блока подписки
            $x("//div[@data-zone-name=\"footerSubscription\"]").shouldBe(Condition.visible);
// Проверка отображения блока подвал
            $x("//div[@data-zone-name=\"footer\"]").shouldBe(Condition.visible);
// Проверка отображения боковых баннеров на подборки
            $x("(//div[@data-zone-name=\"Banner\"])[4] | (//div[@data-zone-name=\"Banner\"])[5] | (//div[@data-zone-name=\"Banner\"])[6]").shouldBe(Condition.visible);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        log.info("Все блоки отображаются корректно");
        return new StartPage();
    }

    public static StartPage regioncheck(String s) {
//      Меняем регион
        SelenideElement x = $x("//input[@placeholder=\"Укажите другой регион\"]");
        $x("//div[@class=\"n-region-notification__actions-cell\"][2]").click();
        x.sendKeys(s);
        try {
            Thread.sleep(2000);
            x.pressEnter();
            x.pressEnter();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return new StartPage();
    }

    public static StartPage regionauto() {
//      Устанавливаем регион автоматически
        $x("(//span[@class=\"header2-menu__text\"])[1]").click();
        try {
            Thread.sleep(2000);
            $x("(//a[@class=\"link region-select-form__auto-definition\"])").click();
            Thread.sleep(2000);
            $x("(//div[@class=\"n-region-notification__actions-cell\"])[1]").click();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return new StartPage();
    }

    public static StartPage allcats() {
        $x("//div[span='Все категории']").click();
        return new StartPage();
    }

    public static StartPage compTechcat() {
        $x("(//a[span='Компьютерная техника'])[2]").click();
        return new StartPage();

    }

    public static StartPage compTech2ndcat() {
//      Ищем произвольную подкатегорию
        Logger log = LogManager.getLogger();
        SelenideElement cat2 = $x("//a[text()=\"Ноутбуки и настольные ПК\"]");
        log.info("Выбрана подкатегория {}", cat2.getText());
        cat2.click();
        try {
            $x("//h3[text()=\"Популярные категории\"]").scrollTo();
            $x("//div[@data-zone-name=\"new-category-snippet\"]").shouldBe(Condition.visible);
        } catch (ElementNotFound e) {
            System.out.println("Нет популярных категорий");
        }
        try {
            $x("//h3[text()=\"Популярные товары\"]").scrollTo();
            $x("//div[@data-zone-name=\"ScrollBox\"][1]").shouldBe(Condition.visible);
        } catch (ElementNotFound e) {
            System.out.println("Нет популярных товаров");
        }
        $x("//div[@data-apiary-widget-name=\"@MarketNode/NavigationTree\"]").shouldBe(Condition.visible);
        return new StartPage();
    }

    public static StartPage memo() {
//      Ищем произвольную категорию
        Logger log = LogManager.getLogger();
        final List<SelenideElement> categories = $$x("//div[@data-zone-name=\"link\"]");
        SelenideElement cat = random(categories);
        log.info("Выбрана категория {}", cat.getText());
        cat.click();
        return new StartPage();
    }

    public static StartPage goodsvisible() {
//      Проверяем видимость блоков фильтров и цен
        try {
            $x("//legend[.]").scrollTo().shouldBe(Condition.visible);
            $x("//div[contains(@class,\"price\")]").shouldBe(Condition.visible);
        } catch (ElementNotFound e) {
            System.out.println("Отсутствуют блоки фильтров");
        }
        return new StartPage();
    }

    public static StartPage randomgoods() {
//      Выбираем произвольный товар
        Logger log = LogManager.getLogger();
        String rnd = $x("//h3[@class=\"n-snippet-card2__title\"]").hover().getText();
        log.info("Выбран товар {}", rnd);
        return new StartPage();
    }

    public static StartPage favourite() {
//      Добавляем в избранное
        Logger log = LogManager.getLogger();
        $x("//i[@class=\"image image_name_favorite\"]").click();
        $x("//div[@class=\"popup-informer__title\"]").shouldBe(Condition.visible);
        log.info("Отобразилось окно избранных товаров");
        return new StartPage();
    }

    public static StartPage onsale() {
//      Проверяем чекбокс "в продаже"
        $x("//legend[1]").scrollTo();
        SelenideElement onsale = $x("//input[@type=\"checkbox\" and @name=\"В продаже\"]");
        if (!onsale.isSelected()) {
            onsale.click();
        } else {
            return new StartPage();
        }
        return new StartPage();
    }

    public static StartPage pricemin() {
//      В поле цена от устанавливаем значение поля цена до, очищаем поле.
        SelenideElement priceto = $x("//input[@id='glpriceto']");
        $x("//span[text()=\"Категории\"]").scrollTo();
        SelenideElement pricefrom = $x("//input[@id='glpricefrom']");
        pricefrom.setValue(priceto.getAttribute("placeholder"));
        pricefrom.pressEnter();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        $x("//span[text()=\"Категории\"]").scrollTo();
        $x("//button[@aria-label=\"Очистить поле Цена от\"]").click();
        return new StartPage();
    }

    public static StartPage pricemax() {
//      В поле цена до устанавливаем значение поля цена от, очищаем поле
        SelenideElement priceto = $x("//input[@id='glpriceto']");
        SelenideElement pricefrom = $x("//input[@id='glpricefrom']");
        priceto.setValue(pricefrom.getAttribute("placeholder"));
        priceto.pressEnter();
        try {
            Thread.sleep(2000);
            $x("//button[@aria-label=\"Очистить поле Цена до\"]").click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return new StartPage();
    }

    public static StartPage randproducer() {
//      Выбираем произвольного производителя
        Logger log = LogManager.getLogger();
        final List<SelenideElement> producer = $$x("//legend[@class='ShXb4FpS5R'][text()='Производитель']/..//input[@type=\"checkbox\"]");
        SelenideElement rndprod = random(producer);
        log.info("Выбран производитель {}", rndprod.parent().getText());
        try {
            Thread.sleep(2000);
            rndprod.parent().click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return new StartPage();
    }

    public static StartPage randgood() throws AWTException {
//      Выбираем товар, запоминаем название и цену, переходим в магазин и сверяем название и цену в магазине
        Logger log = LogManager.getLogger();
        final List<SelenideElement> rndgoods = $$x("//h3[@class=\"n-snippet-card2__title\"]");
        SelenideElement rndgood = random(rndgoods);
        log.info("Выбран товар {}", rndgood.getText());
        try {
            Thread.sleep(3000);
            rndgood.scrollIntoView(true);
            rndgood.click();
            Thread.sleep(5000);
            String price = $x("(//div/span[@class=\"price\"])[1]").scrollTo().getText();
            log.info("Запомнена цена {}", price);
            String title = rndgood.getText();
            log.info("Запомнено название {}", title);
            Thread.sleep(3000);
//          Костыль с Pagedown
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            Thread.sleep(2000);
            $x("(//div/a[@role=\"button\"])[3]").scrollTo().parent().click();
            Thread.sleep(5000);
            $x("//*[contains(text(),'" + price + "')]").shouldBe(Condition.visible);
            $x("//*[contains(text(),'" + title + "')]").shouldBe(Condition.visible);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return new StartPage();
    }
}