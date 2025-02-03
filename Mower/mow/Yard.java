package mow;

import java.util.Scanner;

public class Yard {
    private char[][] yard;
    private int width;
    private int height;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void yardCreator(int x, int y) {
        yard = new char[y + 2][x + 2];
        width = x;
        height = y;
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x + 2; j++) {
                if (i == 0 || i == y + 1 || j == 0 || j == x + 1) {
                    yard[i][j] = 'R';
                } else {
                    yard[i][j] = '+';
                }
            }
        }
    }

    public char yardGetter(int x, int y) {
        return yard[y][x];
    }

    public void mowTile(int x, int y) {
        yard[y][x] = ' ';
    }

    public int widthGetter() {
        return width;
    }

    public int heightGetter() {
        return height;
    }

    public void printYard() {
        clearScreen();
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (j == width + 1) {
                    System.out.println(yard[i][j]);
                } else {
                    System.out.print(yard[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Yard yard = new Yard();
        System.out.println("Enter the height of the yard: ");
        int height = in.nextInt();
        System.out.println("Enter the width of the yard: ");
        int width = in.nextInt();
        yard.yardCreator(width, height);
        yard.mowTile(width, height);
        yard.printYard();

    }
}
