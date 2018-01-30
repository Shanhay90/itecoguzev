# language: ru

Функционал: аутентификация в автоматизированную систему

  @11111
  Структура сценария: Вход с правильным логином/паролем, проверка наличия счета 2-го порядка
    Дано открыт браузер
    * открыта ссылка "http://172.26.25.86:8081/sua/login"
    * открыта страница с формой "Вход в систему"
    Когда пользователь вводит в поле "Имя пользователя" значение "<логин>"
    И пользователь вводит в поле "Пароль" значение "<пароль>"
    И пользователь нажимает кнопку "Войти"
    Тогда открыта страница с формой "Выбор финансовой организации"
    И пользователь выбирает строку организации с названием "10"
    И пользователь нажимает кнопку "Выбрать"
    Тогда появляется страница с логотипом "Агентство по страхованию вкладов"
    И пользователь нажимает кнопку c выпадающем списком Настройки
    И пользователь выбирает пункт "Справочники"
    * открыта страница с таблицей "Справочники"
    * пользователь нажимает на ссылку "План счетов  по КО" в столбце "Краткое наименование"
    * пользователь нажимает кнопку "Поиск" в верхней панели таблицы
    * открыта форма "Поиск..."
    * пользователь выбирает выпадающем списке "ID плана счетов" пункт "Номер счёта 2-го порядка"
    * пользователь выбирает выпадающем списке "содержит" пункт "начинается с"
    * пользователь вводит в поле значение "202"
    Когда пользователь нажимает кнопку "Найти"
    Тогда отображается(ются) "Номер счета 2-го порятка" содержащий значение "202"
    Когда пользователь нажимает кнопку "Права  Все"
    И пользователь нажимает "ссылка" "Выход"
    Примеры:
      | логин   | пароль   |
      | sua_all | Q1w2e3r4 |

