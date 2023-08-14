# Звездные войны

Тестовое задание Android разработчика Бусыгина Дмитрия Юрьевича.

## Описание проекта
В данном проекте разработано простое мобильное приложение, которое позволяет пользователям искать ресурсы
"Звездных войн" (персонажей, звездолетов и планет) и сохранять их в избранном. Персонажи сохраняются в 
избранном вместе со списком фильмов. ДЛЯ ПРОСМОТРА СПИСКА ФИЛЬМОВ ЩЕЛКНИТЕ НА ИКОНКУ ПЕРСОНАЖА В ИЗБРАННОМ!

# Стек технологий
Проект выполнен с использованием последней версии Андройд (API 34). 
В качестве фреймворка UI использован Jetpack Compose последней версии с использованием
библиотеки Material 3. В приложении имеется возможность использования темной и светлой темы, а также 
использования динамической схемы цветов Material 3.

Для получения данных из сети используется KTor Client.
Для локального сохранения данных используется библиотека Room.
Для внедрения зависимостей - Dagger Hilt.
Приложение выполнено в стиле "Чистой архитектуры", имеет многомодульную структуру и
тип архитектуры - MVVM. В качестве асинхронного доступа используются корутины (потоки fow 
и suspend функции), а также различные операторы работы с потоками и состояниями (collect, combine и др.)


Выполнен Unit тест маппера персонажа в главном модуле /app. 