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

    public static boolean getRandomBoolean() {
        return faker.random().nextBoolean();
    }

    public static String getRandomIssueCategory() {
        List<String> categories = List.of("bugtracker", "General");
        return categories.get(faker.random().nextInt(0, 1));
    }

    public static String getRandomHandler() {
        List<String> handler = List.of("vboctor");
        return handler.get(faker.random().nextInt(0, 0));
    }

    public static String getRandomPriority() {
        List<String> priority = List.of("normal", "high");
        return priority.get(faker.random().nextInt(0,1));
    }

    public static String getRandomSeverity() {
        List<String> severity = List.of("trivial");
        return severity.get(faker.random().nextInt(0, 0));
    }

    public static String getRandomProjectViewState() {
        List<String> viewState = List.of("public", "private");
        return viewState.get(faker.random().nextInt(0, 1));
    }

    public static String getRandomReproducibility() {
        List<String> reproducibility = List.of("always");
        return reproducibility.get(faker.random().nextInt(0, 0));
    }

    public static String getRandomTagName() {
        List<String> tagNames = List.of("mantishub");
        return tagNames.get(faker.random().nextInt(0,0));
    }

    public static String getProjectStatus() {
        List<String> status = List.of("planning", "development", "release", "stable", "obsolete");
        return status.get(faker.random().nextInt(0, 4));
    }

    public static boolean getProjectEnabled() {
        return faker.bool().bool();
    }
}