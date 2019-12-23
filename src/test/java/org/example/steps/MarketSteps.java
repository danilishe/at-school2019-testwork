package org.example.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.Category;
import org.example.pages.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class MarketSteps {
    private Logger log = LogManager.getLogger(MarketSteps.class);
    StartPage startPage;

    @Дано("страница Яндекс Маркета")
    public void страницаЯндексМаркета() {
        log.trace("Открыта страница Яндекс Маркета");
        open("https://market.yandex.ru/");
        startPage = new StartPage();
    }

    @То("сменить {string}")
    public void сменить(String city) {
        startPage.setLocation().changeLocation(city);
    }

    @То("проверяем страницу Яндекс Маркета")
    public void сноваПроверяемСтраницуЯндексМаркета() {
        new StartPage();
    }

    @Когда("выбираем определение местоположения автоматически")
    public void выбираемОпределениеМестоположенияАвтоматически() {
        startPage.setLocation().autoLocation();
    }

    @То("подтверждаем местоположение")
    public void подтверждаемМестоположение() {
        startPage.locationIsOk();
    }

    @Если("нажать на Выбор категории")
    public void нажатьНаВыборКатегории() {
        startPage.openCategory();
    }

    @То("выбрать Продукты")
    public void выбратьПродукты() {
        new Category().selectItem();
    }
}
