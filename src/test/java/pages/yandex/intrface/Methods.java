package pages.yandex.intrface;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;

public interface Methods {
    
   static Logger log = LogManager.getLogger("Interface");

    static int Time(){
        return 7000;
    }

    static void thisElementIsVisible(SelenideElement element) {
        try {
            element.scrollTo();
            Thread.sleep(3000);
            element.shouldBe(visible);
            log.info("Элемент найден");
        } catch (ElementNotFound | NoSuchElementException | InterruptedException e) {
            log.error("Элемент {} не найден", element);
           
        }
    }

    static SelenideElement randomElement(List<SelenideElement> list) {
        log.info("Вызван рандомный метод");
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));

    }

    static String removeLastChar(String s) {
        return Optional.ofNullable(s)
                .map(str -> str.replaceAll(" ₽", ""))
                .orElse(s);
    }
}
