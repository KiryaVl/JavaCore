package main.java.ru.geekbrains.Lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][] field; // Игровое поле

    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Победил компьютер."))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initField() {
        fieldSizeX = 4;
        fieldSizeY = 4;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Распечатать игровое поле
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print((y + 1) + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел >>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;

    }

    /**
     * TODO: 3. Компьютер должен мешать игроку
     * Ход игрока (компьютер)
     */
    private static void aiTurn() {
        int x, y;

        // Попытка блокировать ход игрока
        if (blockPlayerWin(DOT_HUMAN)) {
            return;
        }

        // Иначе, случайный ход
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean blockPlayerWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) {
                    field[y][x] = dot;
                    if (checkWin(dot)) {
                        field[y][x] = DOT_AI;
                        return true;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return false;
    }


    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка корректности координат хода
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param dot    фишка игрока
     * @param winStr победный слоган
     * @return признак завершения игры (true)
     */
    private static boolean gameCheck(char dot, String winStr) {
        if (checkWin(dot)) {
            System.out.println(winStr);
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью (все ячейки игрового поля заполнены)
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * TODO: 2. Переработать в рамках домашней работы, метод должен быть универсальным
     * Проверка победы
     *
     * @param dot фишка игрока (X или 0)
     * @return
     */
    private static boolean checkWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkDirection(dot, x, y, 1, 0) || // Горизонталь
                        checkDirection(dot, x, y, 0, 1) || // Вертикаль
                        checkDirection(dot, x, y, 1, 1) || // Диагональ \
                        checkDirection(dot, x, y, 1, -1)) { // Диагональ /
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDirection(char dot, int x, int y, int dx, int dy) {
        int count = 0;
        for (int i = 0; i < WIN_COUNT; i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;
            if (newX >= 0 && newX < fieldSizeX && newY >= 0 && newY < fieldSizeY && field[newY][newX] == dot) {
                count++;
            }
        }
        return count == WIN_COUNT;
    }


    private boolean check1(int x, int y, char dot, int winCount) {
        return false;
    }

}
