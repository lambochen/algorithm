package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 17:28
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 **/
public class IsValidSudoku {

    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        return checkColumn(board) && checkLine(board) && checkOther(board);
    }

    // 行
    private boolean checkLine(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                }
                if (checkChar(board[i][j])) {
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    // 列
    private boolean checkColumn(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (set.contains(board[j][i])) {
                    return false;
                }
                if (checkChar(board[j][i])) {
                    set.add(board[j][i]);
                }
            }
        }
        return true;
    }

    // 其他
    private boolean checkOther(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<>();
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        int line = i * 3 + a;
                        int column = j * 3 + b;
                        if (set.contains(board[line][column])) {
                            return false;
                        }
                        if (checkChar(board[line][column])) {
                            set.add(board[line][column]);
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean checkChar(char data) {
        return data >= '1' && data <= '9';
    }

    public static void main(String[] args) {
        char[][] boards = new char[][] {
            {
                '5', '3', '.', '.', '7', '.', '.', '.', '.'
            },
            {
                '6', '.', '.', '1', '9', '5', '.', '.', '.'
            },
            {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'
            },
            {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'
            },
            {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'
            },
            {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'
            },
            {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'
            },
            {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'
            },
            {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'
            }
        } ;

        IsValidSudoku handler = new IsValidSudoku();

        System.out.println(handler.isValidSudoku(boards));

    }

}
