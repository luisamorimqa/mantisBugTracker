package com.mantis.api.utils;

import com.github.javafaker.Faker;

import java.util.List;

public class DataFaker {

    static Faker faker = new Faker();

    public static String getRandomString() {
        return faker.hacker().noun() + " " + faker.color().name();
    }

    public static String getRandomParagraph() {
        return faker.lorem().paragraph();
    }

    public static String getProjectStatus() {
        List<String> status = List.of("planning", "development", "release", "stable", "obsolete");
        return status.get(faker.random().nextInt(0, 4));
    }
}