package step;

import io.cucumber.java.ru.*;
import pages.magazine.Magazine;
import pages.yandex.market.avto.YandexMarketAvto;
import pages.yandex.market.product.YandexMarketProduct;
import pages.yandex.market.main.YandexMarketMain;

import java.io.IOException;

public class YandexStep {
    YandexMarketMain yandexMain = new YandexMarketMain();
    YandexMarketAvto yandexAvto = new YandexMarketAvto();
    YandexMarketProduct yandexCategories = new YandexMarketProduct();
    Magazine magazine = new Magazine();

    @Дано("страница яндекс маркет")
    public void страницаЯндексМаркет() throws IOException {
        yandexMain.openUrl();
    }

    @Также("проверяем что отображается строка поиска")
    public void проверяемЧтоОтображаетсяСтрокаПоиска() {
        yandexMain.blockSearchString();
    }

    @Также("проверяем что отображается верхний баннер с акциями")
    public void проверяемЧтоОтображаетсяВерхнийБаннерСАкциями() {
        yandexMain.topStockBanner();
    }

    @Также("проверяем что отображается основной баннер с акциями")
    public void проверяемЧтоОтображаетсяОсновнойБаннерСАкциями() {
        yandexMain.mainStockBanner();
    }

    @Также("проверяем что отображается блок рекомендуемые товары")
    public void проверяемЧтоОтображаетсяБлокРекомендуемыеТовары() {
        yandexMain.blockRecommendedProducts();
    }

    @Также("проверяем что отображается блок Журнал маркета")
    public void проверяемЧтоОтображаетсяБлокЖурналМаркета() {
        yandexMain.blockJournalMarket();
    }

    @Также("проверяем что отображается блок отзывы на лучшие товары")
    public void проверяемЧтоОтображаетсяБлокОтзывыНаЛучшиеТовары() {
        yandexMain.blockReviewsTheBestProduct();
    }

    @Также("проверяем что отображается блок популярные бренды")
    public void проверяемЧтоОтображаетсяБлокПопулярныеБренды() {
        yandexMain.blockPopularBrands();
    }

    @Также("проверяем что отображается блок для подписки")
    public void проверяемЧтоОтображаетсяБлокДляПодписки() {
        yandexMain.blockSubscription();
    }

    @Также("проверяем что отображается подвал")
    public void проверяемЧтоОтображаетсяПодвал() {
        yandexMain.blockFooter();
    }

    @Также("проверяем что отображаются боковые баннеры")
    public void проверяемЧтоОтображаютсяБоковыеБаннеры() {
        yandexMain.blocksSideBar();
    }

    @Затем("кликнем на регион")
    public void кликнемНаРегион() {
        yandexMain.clickHeaderBtnCity();
    }

    @И("во всплывающем окне вводим город {string}")
    public void воВсплывающемОкнеВводимГород(String city) {
        yandexMain.inputCity(city);
    }

    @Затем("кликаем на регион")
    public void кликаемНаРегион() {
        yandexMain.clickHeaderBtnCity();
    }

    @И("меняем на определять автоматически")
    public void меняемНаОпределятьАвтоматически() {
        yandexMain.detectAutomatically();
    }

    @Также("кликаем на попап да спасибо")
    public void кликаемНаПопапДаСпасибо() throws InterruptedException {
        yandexMain.clickYesThankYou();
    }

    @Если("кликаем на все категории")
    public void кликаемНаВсеКатегории() {
        yandexMain.clickAllCategories();
    }

    @То("отображается меню с категориями")
    public void отображаетсяМенюСКатегориями() {
        yandexMain.blockAllCategories();
    }

    @Если("наводим на категорию авто")
    public void наводимНаКатегориюАвто() {
        yandexMain.hoverBtnCategoriesCar();
    }

    @Тогда("отображается меню с подкатегориями")
    public void отображаетсяМенюСПодкатегориями() {
        yandexMain.blockCarCategories();
    }

    @Затем("выбираем категорию авто")
    public void выбираемКатегориюАвто() {
        yandexMain.clickBtnCategoriesCar();
    }

    @Также("выбираем категорию второго уровня")
    public void выбираемКатегориюВторогоУровня() {
        yandexMain.clickCategoriesTwo();
    }

    @Затем("проверяем что отображается блок популярные категории")
    public void проверяемЧтоОтображаетсяБлокПопулярныеКатегории() {
        yandexAvto.blockPopularCategories();
    }

    @Затем("проверяем что отображается блок популярные товары")
    public void проверяемЧтоОтображаетсяБлокПопулярныеТовары() {
        yandexAvto.blockPopularProduct();
    }

    @Затем("проверяем что отображается блок скидки")
    public void проверяемЧтоОтображаетсяБлокСкидки() {
        yandexAvto.blockDiscount();
    }

    @Также("проверяем что отображается блок популярные отзывы с подкатегориями")
    public void проверяемЧтоОтображаетсяБлокПопулярныеОтзывыСПодкатегориями() {
        yandexAvto.blockPopularReviews();
        yandexAvto.blockPopularReviewsCategories();
    }

    @Затем("выбираем произвольную категорию")
    public void выбираемПроизвольнуюКатегорию() {
        yandexAvto.randomCategories();
    }

    @Тогда("проверяем что отображается блок ограничение цены")
    public void проверяемЧтоОтображаетсяБлокОграничениеЦены() {
        yandexCategories.blockPriceLimit();
    }

    @Также("проверяем что отображается чекбокс В продаже")
    public void проверяемЧтоОтображаетсяЧекбоксВПродаже() {
        yandexCategories.checkboxOnSale();
    }

    @Также("проверяем что отображается производитель")
    public void проверяемЧтоОтображаетсяПроизводитель() {
        yandexCategories.blockManufacturer();
    }

    @Также("проверяем что отображается рейтинг магазина")
    public void проверяемЧтоОтображаетсяРейтингМагазина() {
        yandexCategories.blockStoreRating();
    }

    @Также("проверяем что отображается способ доставки")
    public void проверяемЧтоОтображаетсяСпособДоставки() {
        yandexCategories.blockDeliveryMethod();
    }

    @Также("проверяем что отображается способ оплаты")
    public void проверяемЧтоОтображаетсяСпособОплаты() {
        yandexCategories.blockPaymentMethod();
    }

    @Также("проверяем что отображается магазины")
    public void проверяемЧтоОтображаетсяМагазины() {
        yandexCategories.blockShops();
    }

    @Также("у каждого товара присутствует цена")
    public void уКаждогоТовараПрисутствуетЦена() {
        yandexCategories.checkBlocksProductPrice();
    }

    @Также("у каждого товара присутствует предложения в список магазинов")
    public void уКаждогоТовараПрисутствуетПредложенияВСписокМагазинов() {
        yandexCategories.checkBlocksProductOffer();
    }

    @Также("у каждого товара присутствует отзыв")
    public void уКаждогоТовараПрисутствуетОтзыв() {
        yandexCategories.checkBlocksProductComment();
    }

    @Если("навести курсор на товар")
    public void навестиКурсорНаТовар() {
        yandexCategories.hoverProduct();
    }

    @То("появиться кнопка добавить в избранное")
    public void появитьсяКнопкаДобавитьВИзбранное() {
        yandexCategories.blockAddFavorite();
    }

    @Если("добавить товар в избранное")
    public void добавитьТоварВИзбранное() {
        yandexCategories.clickButtonFavorite();
    }

    @То("появиться верхней части появиться уведомление")
    public void появитьсяВерхнейЧастиПоявитьсяУведомление() {
        yandexCategories.noticeOfAdditionFavorites();
    }
    @Затем("закроем уведомление")
    public void закроемУведомление() {
        yandexCategories.noticeOfAdditionFavoritesClose();
    }

    @И("флажок")
    public void флажок() {
    }

    @Когда("в блоке цена, в поле от устанавливаем максимальную цену поля до")
    public void вБлокеЦенаВПолеОтУстанавливаемМаксимальнуюЦенуПоляДо() throws InterruptedException {
        yandexCategories.setMinPrice();
    }

    @Тогда("должно присутствовать не менее одного товара")
    public void должноПрисутствоватьНеМенееОдногоТовара() {
        yandexCategories.productVisibleOnPage();
    }

    @И("очищаем поле от")
    public void очищаемПолеОт() throws InterruptedException {
        yandexCategories.setMinPriceClear();
    }

    @Когда("в блоке цена, в поле до устанавливаем минимальную цену поля от")
    public void вБлокеЦенаВПолеДоУстанавливаемМинимальнуюЦенуПоляОт() throws InterruptedException {
        yandexCategories.setMaxPrice();
    }

    @И("очищаем поле до")
    public void очищаемПолеДо() throws InterruptedException {
        yandexCategories.setMaxPriceClear();
    }

    @Если("выбрать произвольного производителя")
    public void выбратьПроизвольногоПроизводителя() throws IOException {
        yandexCategories.selectBrand();
    }

    @Тогда("происходит фильтрация и все товары соответствуют производителю")
    public void происходитФильтрацияИВсеТоварыСоответствуютПроизводителю() throws InterruptedException {
        yandexCategories.searchProductBrandText();
    }

    @Также("выбираем произвольный товар")
    public void выбираемПроизвольныйТовар() throws InterruptedException {
        yandexCategories.selectProduct();
    }

    @И("у выбранного товара нажимаем кнопку В магазин")
    public void уВыбранногоТовараНажимаемКнопкуВМагазин() throws InterruptedException {
        yandexCategories.goToStore();
    }

    @Затем("проверяем наличие названия товара и цены")
    public void проверяемНаличиеНазванияТовараИЦены() {
        magazine.checkPriceAndNameProduct();
    }
}
