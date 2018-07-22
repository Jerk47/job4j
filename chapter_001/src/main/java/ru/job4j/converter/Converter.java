package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        int oneEuro = 70;
        return value / oneEuro;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        int oneDollar = 60;
        return value / oneDollar;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        int oneEuro = 70;
        return value * oneEuro;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value рубли.
     * @return Доллары.
     */
    public int dollarToRuble(int value) {
        int oneDollar = 60;
        return value * oneDollar;
    }
}