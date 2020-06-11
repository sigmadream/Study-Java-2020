package com.sangkon.inaction.chapter02;

import java.util.Arrays;
import java.util.List;

import static com.sangkon.inaction.chapter02.Color.GREEN;
import static com.sangkon.inaction.chapter02.Color.RED;

public class PrinterApplication {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(
                new Apple(RED, 130),
                new Apple(GREEN, 160));

        Printer.prettyPrintApple(appleList, new AppleFancyFormatter());
        Printer.prettyPrintApple(appleList, new AppleSimpleFormatter());
    }

}
