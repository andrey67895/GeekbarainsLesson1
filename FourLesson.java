import java.util.Random;
import java.util.Scanner;

public class FourLesson {

    private static final int DOTS_TO_WIN = 4;
    private static final int X_LENGTH = 5;
    private static final int Y_WIDTH = 5;
    private static final char EMPTY_DOT = '*';
    private static final char X_DOT = 'X';
    private static final char O_DOT = '0';
    public static Scanner scanner = new Scanner(System.in);
    private static char[][] gameMap;
    private static int count = 0;

    public static void main(String[] args) {

        unitTest();
        gameOnePlayer();

    }


    private static void gameOnePlayer() {
        generatGameMap();
        paintGameMap();
        count = 0;
        while (true) {
            humanTurn(X_DOT);
            count++;
            paintGameMap();
            if (chekWin(X_DOT)) {
                System.out.println("YOU WIN !!!");
                break;
            }
            if (((X_LENGTH * Y_WIDTH) % 2) != 0) {
                if (count == (X_LENGTH * Y_WIDTH)) {
                    System.out.println(":))) FRENDLY WIN :)))");
                    break;
                }
            }
            System.out.println("");
            compTurn(O_DOT);
            count++;
            paintGameMap();
            if (chekWin(O_DOT)) {
                System.out.println("Sorry but you looser, computer WIN (((");
                break;
            }

            if (((X_LENGTH * Y_WIDTH) % 2) == 0) {
                if (count == (X_LENGTH * Y_WIDTH)) {
                    System.out.println(":))) FRENDLY WIN :)))");
                    break;
                }
            }

        }
    }


    private static void unitTest() {
        for (int i = 0; i < 8; i++) {
            generatGameMap();
            count = 0;
            while (true) {
                compTurn(X_DOT);
                count++;
                if (chekWin(X_DOT)) {
                    break;
                }
                if (((X_LENGTH * Y_WIDTH) % 2) != 0) {
                    if (count == (X_LENGTH * Y_WIDTH)) {
                        break;
                    }
                }
                compTurn(O_DOT);
                count++;
                if (chekWin(O_DOT)) {
                    break;
                }
                if (((X_LENGTH * Y_WIDTH) % 2) == 0) {
                    if (count == (X_LENGTH * Y_WIDTH)) {
                        break;
                    }
                }
            }

        }
    }


    private static boolean chekWin(char c) {
        int win = 0;
        for (int i = 0; i < X_LENGTH; i++) {
            for (int j = 0; j < Y_WIDTH; j++) {

                if (gameMap[i][j] == c) {
                    win++;
                    if (win == DOTS_TO_WIN) {
                        return true;
                    }
                } else if (gameMap[i][j] != c) {
                    win = 0;
                }
            }
            win = 0;
        }
        for (int i = 0; i < Y_WIDTH; i++) {
            for (int j = 0; j < X_LENGTH; j++) {

                if (gameMap[j][i] == c) {
                    win++;
                    if (win == DOTS_TO_WIN) {
                        return true;
                    }
                } else if (gameMap[j][i] != c) {
                    win = 0;
                }
            }
            win = 0;
        }
        for (int i = 0; i < X_LENGTH && i < Y_WIDTH; i++) {
            if (gameMap[i][i] == c) {
                win++;
                if (win == DOTS_TO_WIN) {
                    return true;
                }
            } else if (gameMap[i][i] != c) {
                win = 0;
            }
        }
        win = 0;
        for (int i = 0; i < X_LENGTH && i < Y_WIDTH; i++) {
            if (gameMap[i][Y_WIDTH - 1 - i] == c) {
                win++;
                if (win == DOTS_TO_WIN) {
                    return true;
                }
            } else if (gameMap[i][Y_WIDTH - 1 - i] != c) {
                win = 0;
            }
        }
        return false;
    }


    private static void compTurn(char DOTS) {
        int x, y;
        boolean checkCell = false;
        Random random = new Random();
        do {

            x = random.nextInt(gameMap.length);
            y = random.nextInt(gameMap.length);

            checkCell = isValidCellKomp(x, y);
        } while (!checkCell);
        gameMap[x][y] = DOTS;
    }

    private static void humanTurn(char DOTS) {
        int x = 0;
        int y = 0;
        boolean checkCell = false;
        do {
            System.out.println("Введите пожалуйста координату в формате X Y");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
            }
            if (scanner.hasNextInt()) {
                y = scanner.nextInt() - 1;
            }
            checkCell = isValidCell(x, y);
        } while (!checkCell);
        gameMap[x][y] = DOTS;
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > gameMap.length || y > gameMap.length) {
            return false;
        }
        return gameMap[x][y] == EMPTY_DOT;
    }

    private static boolean isValidCellKomp(int x, int y) {
        return gameMap[x][y] == EMPTY_DOT;
    }

    private static void paintGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void generatGameMap() {
        gameMap = new char[X_LENGTH][Y_WIDTH];

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = EMPTY_DOT;
            }
        }
    }


}
