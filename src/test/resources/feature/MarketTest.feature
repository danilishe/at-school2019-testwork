#language: ru

Функциональность: Тестирование Яндекс Маркета
  @all @region @city @market
  Структура сценария: выбор региона
    Дано страница Яндекс Маркета
    Если сменить "<Город>"
    То проверяем страницу Яндекс Маркета
    Затем выбираем определение местоположения автоматически
    Затем выбираем категорию Продукты
    Примеры:
      | Город           |
      | Санкт-Петербург |

