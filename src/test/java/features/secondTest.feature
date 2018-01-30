# language: ru

Функционал: "Список активов"

  @11112
  Сценарий: Проверка функциональности модуля "Список активов"
    Дано открыт браузер
    * открыта ссылка "http://172.26.25.86:8081/sua/login"
    * пользователь заполняет поля "Имя пользователя" и "Пароль" значениями
      | sua_all | Q1w2e3r4 |
    * пользователь нажимает кнопку "Войти"
    * пользователь выбирает строку организации с названием "10"
    * пользователь нажимает кнопку "Выбрать"

    Когда пользователь нажимает кнопку c выпадающем списком Сбор и ведение данных
    * пользователь нажимает кнопку "Список активов"
    Тогда открыта страница с таблицей "Список активов"

    Когда пользователь нажимает кнопку "Создать"
    Тогда отображается элемент с текстом "Создание актива (первый этап)"
    * отображается элемент с текстом "Наименование ФО "
    * отображается элемент с текстом "Тип актива функциональный "

    Когда пользователь выбирает выпадающем списке "Тип актива функциональный " пункт "Денежные средства"
    * пользователь нажимает кнопку "Далее"
    Тогда отображается элемент с текстом "Создание актива (второй этап)"
    * отображается элемент с текстом "Актив:"

    Когда пользователь заполняет форму значениями
      | Номер счёта                    | 2822222222222 |
      | Начальная балансовая стоимость | 222222        |
      | В валюте счёта                 | 54545         |
      | Текущая балансовая стоимость   | 5464658       |



