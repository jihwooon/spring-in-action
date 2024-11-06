package com.example.demo.재귀;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 쿼드압축 {

    private static class Count {

        private final int zero;
        private final int one;

        private Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;

        if (arr[offsetX][offsetY] == 1) {
            return new Count(0, 1);
        }

        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX + h, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY + h, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        return new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    @Test
    void result() {
        assertThat(solution(new int[][]{
            {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        })).isEqualTo(new int[]{4, 9});
    }
}
