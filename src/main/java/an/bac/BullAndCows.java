package an.bac;

import java.util.Random;
import java.util.Scanner;

public class BullAndCows implements Game {
    private final Random random = new Random();
    private final Scanner userInput = new Scanner(System.in);
    private int[] digits;
    private int bulls;
    private int cows;

    @Override
    public void play() {
        digits = new int[askForDigitCount()];
        do {
            generateDigits(digits);
            printDigits(digits);
            askForBullsAndCows();
        } while (isFinish());
    }

    private boolean isFinish() {
        return bulls == digits.length && cows == 0;
    }

    private void generateDigits(int[] digits) {
        if (bulls == 0 && cows == 0) {
            generateRandomDigits(digits);
            return;
        }
        //TODO генерировать новое число на основе быков и коров и предыдущего числа
    }

    private int askForDigitCount() {
        System.out.println("Загадайте число и введите количесвто знаков: ");
        return userInput.nextInt();
    }

    private void generateRandomDigits(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = getNonZeroDigit();
        }
    }

    private int getNonZeroDigit() {
        int digit;
        do {
            digit = random.nextInt(10);
        } while (digit == 0);
        return digit;
    }

    private void printDigits(int[] digits) {
        System.out.println("Угадываю... ");
        for (int digit : digits) {
            System.out.print(digit);
        }
    }

    private void askForBullsAndCows() {
        do {
            System.out.println("Введите колиество быков и коров: ");
            bulls = userInput.nextInt();
            cows = userInput.nextInt();
        } while (bulls < 0 || cows < 0 || bulls + cows > digits.length);
    }
}
