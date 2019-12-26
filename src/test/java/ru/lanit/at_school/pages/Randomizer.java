package ru.lanit.at_school.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

public class Randomizer {
    static SelenideElement random(List<SelenideElement> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
