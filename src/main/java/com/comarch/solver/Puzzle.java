package com.comarch.solver;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Puzzle {
    private int[][] values = new int[9][9];

    public Puzzle(int[][] values) {
        this.values = values;
    }

    public void setValue(int x, int y, int value) {
        values[x][y] = value;
    }

    public boolean canSet(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (values[x][i] == value || values[i][y] == value) {
                return false;
            }
        }
        int xbase = (x / 3) * 3;
        int ybase = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (values[i + xbase][j + ybase] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear(int x, int y) {
        values[x][y] = 0;
    }

    public boolean isEmpty(int x, int y) {
        return values[x][y] == 0;
    }
}
