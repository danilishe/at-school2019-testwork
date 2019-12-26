package pages.yandex.market.product;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static pages.yandex.intrface.Methods.*;

public class YandexMarketProduct {
    private static Logger log = LogManager.getLogger("Яндекс маркет продукт");
    List<SelenideElement> productList;
    SelenideElement product;
    SelenideElement manufacturer;
    String manufacturerNameText;
    public static String productPrice;
    public static String productName;
    boolean flag;

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();//getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    public void blockPriceLimit() {
        thisElementIsVisible($x("//fieldset[@class='_38PayafmjD']"));
        log.info("Проверяем что отображается  лимит цены");
    }

    public void checkboxOnSale() {
        thisElementIsVisible($x("//label[@class='_1e7iX1B2oW'][@for='onstock']"));
        log.info("Проверяем что отображается чекбокс \"В продаже\"");

    }

    public void blockManufacturer() {
        thisElementIsVisible($x("//fieldset[@data-autotest-id='7893318']"));
        log.info("Проверяем что отображается производитель");
    }

    public void blockStoreRating() {
        thisElementIsVisible($x("//fieldset[@class='_2uSu7TQsMO']"));
        log.info("Проверяем что отображается  рейтинг магазина");
    }

    public void blockDeliveryMethod() {
        thisElementIsVisible($x("//fieldset[@class='_2qWuY12N6f']"));
        log.info("Проверяем что отображается способо доставки ");
    }

    public void blockPaymentMethod() {
        thisElementIsVisible($x("//fieldset[@data-autotest-id='payments']"));
        log.info("Проверяем что отображается способ оплаты");
    }

    public void blockShops() {
        thisElementIsVisible($x("//fieldset[@data-autotest-id='fesh']"));
        log.info("Проверяем что отображается ссылка \"предложений\" ");
    }

    public void checkBlocksProductPrice() {
        checkBlocksProduct(".//div[@class='n-snippet-card2__main-price-wrapper']//div[@class='price']");
        log.info("Проверяем что у каждого продукта отображается цена");
    }

    public void checkBlocksProductOffer() {
        checkBlocksProduct(".//div[@class='n-snippet-card2__more-prices-link']");
        log.info("Проверяем что у каждого продукта отображается ссылка \"предложений\"");
    }

    public void checkBlocksProductComment() {
        checkBlocksProduct(".//a[@class='n-badge-review__link']");
        log.info("Проверяем что у каждого продукта отображается отзыв");

    }

    public void hoverProduct() {
        product = randomElement($$(By.xpath("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*")));
        product.scrollTo().hover();
        log.info("Наводим курсор нна продукт");
    }

    public void blockAddFavorite() {
        thisElementIsVisible($x("//div[@class='n-snippet-card2__hover']"));
        log.info("Проверяем что у продукта отображается кнопка \"добавить в избранное\"");
    }

    public void clickButtonFavorite() {
        $x("//i[@class='image image_name_favorite']").click();
        log.info("Кликаем на кнопку \"добавить в избранное\"");
    }

    public void noticeOfAdditionFavorites() {
        thisElementIsVisible($x(".//div[@class='popup-informer__text']"));
        log.info("Проверяем что в верхней части появилось уведомление");
    }

    public void noticeOfAdditionFavoritesClose() {
        $x("//div[@class='popup-informer__close image image_name_close']").click();
        log.info("Закрываем уведомление");
    }

    public void setMinPrice() throws InterruptedException {
        SelenideElement maxPrice = $x("//input[@id='glpriceto']");
        $x("//input[@id='glpricefrom']").setValue(maxPrice.getAttribute("placeholder"));
        flag = true;
        log.info("В поле \"от\" устанавливаем значение {}", maxPrice.getText());
        Thread.sleep(3000);
    }

    public void setMinPriceClear() throws InterruptedException {
        $x("(//button[@class='_3DiWbCQOB8 _27wQJuRAwM'])[1]").click();
        log.info("Очищаем поле \"от\"");
        Thread.sleep(2000);
    }

    public void setMaxPrice() throws InterruptedException {
        SelenideElement minPrice = $x("//input[@id='glpricefrom']");
        $x("//input[@id='glpriceto']")
                .setValue(minPrice.getAttribute("placeholder"));
        flag = false;
        log.info("В поле \"от\" устанавливаем значение {}", minPrice.getText());
        Thread.sleep(3000);

    }

    public void setMaxPriceClear() throws InterruptedException {
        $x("//button[@aria-label='Очистить поле Цена до']").click();
        log.info("Очищаем поле \"до\"");
        Thread.sleep(5000);
    }
    @Attachment
    public void selectBrand() {
        log.info("Выбираем случайного производителя");
        try {
            manufacturer = randomElement($$(By.xpath("//legend[text()='Производитель']/..//label")));
            manufacturerNameText = manufacturer.getText();
            log.info("Кликаем на чекбокс {}", manufacturerNameText);
            manufacturer.click();
            Thread.sleep(3000);
        } catch (ElementNotFound | InterruptedException e) {
            log.error("производитель не найден");
          
        }
    }

    public void searchProductBrandText() throws InterruptedException {
        int count = 1;
        productList = $$(By.xpath("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*"));
        for (SelenideElement brandProduct : productList) {
            log.info("{} - {}", count, brandProduct.find(By.xpath(".//a[contains(text(),'" + manufacturerNameText + "')]")));
            thisElementIsVisible(brandProduct.find(By.xpath(".//a[contains(text(),'" + manufacturerNameText + "')]")));
            count++;
        }
        Thread.sleep(3000);
    }

    public void selectProduct() throws InterruptedException {
        log.info("Выбираем рандомный продукт");
        productList = $$(By.xpath("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*"));
        product = randomElement(productList);
        log.info(product.getText());
        Thread.sleep(5000);
        productPrice = product.find(By.xpath(".//div[@class='price']")).getText();
        log.info("Запоминаем цену продукта {}", productPrice);
        productName = product.find(By.xpath(".//h3[@class='n-snippet-card2__title']")).getText();
        log.info("Запоминаем название продукта {}", productName);
        Thread.sleep(3000);

    }

    public void goToStore() throws InterruptedException {
        log.info("Кликаем по ссылки \"предложений\" продукта {}", productName);
        product.find(By.xpath(".//div[@class='n-snippet-card2__more-prices-link']/a")).click();
        Thread.sleep(5000);
        log.info("Переходим в магазин");
        $x("//span[contains(text(), 'магазин')]").click();
        Thread.sleep(10000);


    }

    public void productVisibleOnPage() {
        String s = null;
        String s2 = null;
        productList = $$(By.xpath("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*"));
        if (productList.size() > 0) {
            for (SelenideElement product : productList) {
                s = (product.find(By.xpath(".//div[@class='price']")).getText());
                s2 = removeLastChar(s);
            }
            if (flag) {
                System.out.println("макс цена----" + $x("//input[@id='glpriceto']").getAttribute("placeholder"));
                Assert.assertEquals($x("//input[@id='glpriceto']").getAttribute("placeholder"), s2);

            } else {
                System.out.println("мин - цена" + $x("//input[@id='glpricefrom']").getAttribute("placeholder"));
                Assert.assertEquals($x("//input[@id='glpricefrom']").getAttribute("placeholder"), s2);

            }
        } else
            System.out.println("Продукт с такой ценой не найден");
    }

    public void checkBlocksProduct(String blockXpath) {
        try {
            productList = $$(By.xpath("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/*"));
            for (SelenideElement product : productList) {
                thisElementIsVisible(product.find(By.xpath(blockXpath)));
            }
        } catch (NoSuchElementException | ElementNotFound e) {
            System.out.println("Ошибка, нет такого элемента\n" + e);

        }
    }


}


