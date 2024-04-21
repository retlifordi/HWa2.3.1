package ru.netology.test.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }
    static Faker faker = new Faker(new Locale("ru"));




    public static String getRandomCity() {
        String[] cities = {"Москва", "Санкт-Петербург", "Брянск", "Владимир", "Воронеж", "Иваново", "Калуга", "Кострома", "Курск",
                "Липецк", "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула", "Ярославль",
                "Архангельск", "Вологда", "Калининград", "Петрозаводск", "Сыктывкар",
                "Санкт-Петербург", "Мурманск", "Салехард", "Великий Новгород", "Псков", "Уфа",
                "Киров", "Йошкар-Ола", "Саранск", "Нижний Новгород", "Оренбург", "Пенза", "Пермь",
                "Самара", "Саратов", "Казань", "Ижевск", "Ульяновск", "Чебоксары", "Курган",
                "Екатеринбург", "Тюмень", "Челябинск", "Салехард", "Горно-Алтайск", "Барнаул",
                "Улан-Удэ", "Чита", "Иркутск", "Кемерово", "Красноярск", "Хабаровск"};
        Random random = new Random();
        int randomIndex = random.nextInt(cities.length);
        return cities[randomIndex];
        //return cities[new Random().nextInt(cities.length)];
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String generateCity(String locale) {
        return faker.address().cityName();
    }

    public static String generateName(String locale) {
        return faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}