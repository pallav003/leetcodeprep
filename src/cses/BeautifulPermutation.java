package cses;


import java.util.Scanner;

/**
 * A permutation of integers 1,2,\ldots,n is called beautiful if there are no adjacent elements whose difference is 1.
 * Given n, construct a beautiful permutation if such a permutation exists.
 * Input
 * The only input line contains an integer n.
 * Output
 * Print a beautiful permutation of integers 1,2,\ldots,n. If there are several solutions, you may print any of them. If there are no solutions, print "NO SOLUTION".
 * Constraints
 * <p>
 * 1 \le n \le 10^6
 * <p>
 * Example 1
 * Input:
 * 5
 * <p>
 * Output:
 * 4 2 5 3 1
 * Example 2
 * Input:
 * 3
 * <p>
 * Output:
 * NO SOLUTION
 */
public class BeautifulPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 1) {
            System.out.println("1");
        } else if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i += 2) {
                sb.append(i).append(" ");
            }
            for (int i = 1; i <= n; i += 2) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
