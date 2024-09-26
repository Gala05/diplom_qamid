# План по проверке и автоматизации мобильного приложения Хоспис

## Описание объекта тестирования

Приложение даёт функционал по работе с новостями хосписа и включает в себя:

- информацию о новостях и функционал для работы с ними;
- тематические цитаты;
- информацию о приложении.

## Список функций и описание системы

1.  При входе в приложение splash screen.
2.  Страница авторизации с полями ввода для логина и пароля. Кнопка "Войти".
3.  На главном экране (раздел "Главная")
    - appbar. Содержит
      - иконку навигации с перечнем перехода по разделам приложения Главная, Новости, О приложении
      - заголовок
      - иконка "Главное - жить любя" для просмотра тематических цитат
      - иконка для последующего выхода из приложения
    - Раздел Новости с разворотом и переходом на просмотр всех новостей (ВСЕ НОВОСТИ). Новость включает в себя поля: Категория (объявление, день рождения, зарплата, профсоюз, праздник, массаж, благодарность, нужна помощь), Заголовок, Дата публикации, Время публикации, Описание, чек-бокс Active/Not active.
4.  Раздел "Новости" содержит

    - заголовок и navigation bar с кнопками  
       - сортировки новости по дате публикации  
       - фильтрации новостей по категории или дате публикации  
       - редактирования новости.
    - текстовые блоки с опубликованными новостями с возможностью свернуть/развернуть.

    При нажатии кнопки для редактирования новости выходит окно, которое содержит

    - заголовок и navigation bar с кнопками  
       - сортировки новостей по дате публикации  
       - фильтрации новостей по категории или дате публикации  
       - добавление/удаление новости. При добавлении новости необходимо заполнить поля и нажать кнопку "Сохранить" для сохранения, или "Закрыть" для выхода из режима добавления.
    - текстовые блоки с новостями. Содержат в себе названиее, дату публикации, дата создания, автор. Также на текстовом блоке есть кнопки удалить, редактировать и свернуть/развернуть, а также сведения об активации.

5.  Раздел "О приложении". Отображается версия, а также две ссылки на Privacy policy (политика конфиденциальности) и Terms of use (пользовательское соглашение).

## Стратегия тестирования (виды тестирования)

Ручное  
Автоматизированное

### Функциональное тестирование

Проверка всех фукнций приложения

### Тестирование GUI&UX

Макет  
Пользовательский опыт

### Тестирование безопасности

SQL-инъекции  
XSS-инъекции

### Тестирование локализации

Проверка на обоснованность использования иностранного языка в приложении

### Нефунциональное тестирование

При различных состояния сети Интернет  
Нехватка памяти  
Нехватка заряда на телефоне

## Последовательность проведения работ

1. Составление плана
2. Составление чек-листа
3. Составление тест-кейсов
4. Ручное тестирование
5. Автоматизация проверки приложения.
6. Составление отчета о тестировании

## Критерий начала тестирования

Приложение можно установить на эмулятор. Оно открывается.

## Критерий окончания тестирования

Проведены все запланированные тесты, получены отчеты.