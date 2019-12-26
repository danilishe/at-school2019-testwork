package pages.magazine;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.yandex.market.product.YandexMarketProduct;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;
import static pages.yandex.intrface.Methods.removeLastChar;
import static pages.yandex.intrface.Methods.thisElementIsVisible;

public class Magazine {
    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    private static Logger log = LogManager.getLogger("Магазин");

    @Attachment
    public void checkPriceAndNameProduct() {
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        String nameProduct = YandexMarketProduct.productName.replaceAll(String.valueOf(pattern), "").trim();
        String priceProduct = removeLastChar(YandexMarketProduct.productPrice);

        log.info("Ищем на странице название {}", nameProduct);
        log.info("Ищем на странице цену {}", priceProduct);
        try {
            SelenideElement name = $x("//*[contains(text(),'" + nameProduct + "')]");
            log.info("Название на странице {}", name.getText());
            thisElementIsVisible(name);
            SelenideElement price = $x("//*[contains(text(),'" + priceProduct + "del')]");
            log.info("цена на странице {}", price.getText());
            thisElementIsVisible(price);
        } catch (ElementNotFound e) {
            log.error("не найдено");
        }
    }
}
