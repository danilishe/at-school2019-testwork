#language: ru
Функционал: тестирование категории компьютерная техника сайта market.yandex.ru
  @start
  Сценарий: выбрать произвольный товар в категории компьютерная техника, запомнить название и цену
    Дано открыта страница сайта и отображаются блоки
    Затем выбираем произвольный регион
    Затем выбираем регион автоматически
    Затем выбираем меню все категории
    Затем выбираем категорию Компьютерная техника
    Затем выбираем произвольную категорию второго уровня
    Если присутствуют блоки, запоминаем список подкатегорий
    Если навести курсор на произвольный товар, у товара появляется кнопка добавить в избранное
    Также добавляем товар в избранное
    Затем активируем флажок в продаже если он не активирован
    Затем в блок цена от устанавливаем максимальную цену из блока цена до убеждаемся что присутствует хотя бы один товар и очищаем поле блока цена от
    Затем в блок цена до устанавливаем максимальную цену из блока цена от убеждаемся что присутствует хотя бы один товар и очищаем поле блока цена до
    Затем выбираем произвольного производителя из блока производитель
    Затем выбираем произвольный товар запоминаем его название и цену