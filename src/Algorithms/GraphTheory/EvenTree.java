/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.GraphTheory;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Chanaka
 */
public class EvenTree {

    public static void main(String[] args) {
        int tree[];
        int count[];

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        tree = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < M; i++) {
            int u1 = scan.nextInt();
            int v1 = scan.nextInt();

            tree[u1 - 1] = v1;
            count[v1 - 1] += count[u1 - 1];
            int root = tree[v1 - 1];

            while (root != 0) {
                count[root - 1] += count[u1 - 1];
                root = tree[root - 1];
            }
        }

        int counter = -1;
        for (int i = 0; i < N; i++) {
            if (count[i] % 2 == 0) {
                counter++;
            }
        }

        System.out.print(counter);

    }
}
