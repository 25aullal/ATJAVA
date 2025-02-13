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

    public void printYard(Mower mower) {
        clearScreen();
        mower.mowUnderneath(this);
        if (mower.getDirection() == 0) {
            yard[mower.getRow()][mower.getColumn()] = '^';
        } else if (mower.getDirection() == 1) {
            yard[mower.getRow()][mower.getColumn()] = '>';
        } else if (mower.getDirection() == 2) {
            yard[mower.getRow()][mower.getColumn()] = 'v';
        } else if (mower.getDirection() == 3) {
            yard[mower.getRow()][mower.getColumn()] = '<';
        }
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

    }
}
