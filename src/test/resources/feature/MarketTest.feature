#language: ru

  Функциональность: Тестирование Яндекс Маркета
    Структура сценария: выбор региона и категории
      Дано страница Яндекс Маркета
      Если сменить "<Город>"
      То проверяем страницу Яндекс Маркета
      Когда выбираем определение местоположения автоматически
      То подтверждаем местоположение
      Если нажать на Выбор категории
      То выбрать Продукты

      Примеры:
        |      Город      |
        | Санкт-Петербург |