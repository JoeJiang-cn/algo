package com.joe.algo.backtrack;

/**
 * @author Joe
 * N皇后问题
 * 2021/8/28 20:00
 */
public class NQueen {
    int solutions = 0;

    public void solve(int row, int[] result) {
        calNQueen(row, result);
        System.out.println("共有" + solutions + "种摆法");
    }

    /**
     * 打印出N皇后的所有解法
     * @param row
     * @param result
     */
    private void calNQueen(int row, int[] result) {
        if (row == result.length) {
            // 计算完毕
            solutions++;
            printQueens(result);
            return;
        }
        for (int column = 0; column < result.length; column++) {
            if (isOk(result, row, column)) {
                // 放法OK
                result[row] = column;
                // 计算下一行
                calNQueen(row + 1, result);
            }
        }
    }

    /**
     * 此时0~row-1的行上已经摆好了棋子
     * @param result
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int[] result, int row, int column) {
        // 左上和右上
        int leftUpColumn = column - 1;
        int rightUpColumn = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            // 同一列不能放
            if (column == result[i]) {
                return false;
            }
            // 左上不能放，注意左上的边界
            if (leftUpColumn >= 0) {
                if (leftUpColumn == result[i]) {
                    return false;
                }
            }
            // 右上不能放
            if (rightUpColumn < result.length) {
                if (rightUpColumn == result[i]) {
                    return false;
                }
            }
            leftUpColumn--;
            rightUpColumn++;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < result.length; row++) {
            // 皇后摆放的位置
            int q = result[row];
            for (int column = 0; column < result.length; column++) {
                if (q == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
