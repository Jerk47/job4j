package ru.job4j.max;

public class Max {

    public int max(int first, int second) {
        int maxNumber = first > second ? first : second;
        return maxNumber;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        int maxNumber = this.max(temp, third);
        return maxNumber;
    }
}
