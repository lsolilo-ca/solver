package com.comarch.solver;

import java.util.List;

public class Solver {
    public void solve(Puzzle puzzle, List<String> solutions) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (puzzle.isEmpty(x, y)) {
                    for (int value = 1; value <= 9; value++) {
                        if (puzzle.canSet(x, y, value)) {
                            puzzle.setValue(x, y, value);
                            solve(puzzle, solutions);
                            puzzle.clear(x, y);
                        }
                    }
                    return;
                }
            }
        }
        solutions.add(puzzle.toString());
    }
}
