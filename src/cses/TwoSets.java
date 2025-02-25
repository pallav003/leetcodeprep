package cses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        long sumOfNNumber =(long)(n*(n+1))/2;
        if (sumOfNNumber %2 == 1) {
            System.out.println("NO");
        }
        else {
            List<Integer> firstSet = new ArrayList<>();
            List<Integer> secondSet = new ArrayList<>();
            long target = sumOfNNumber/2;
            System.out.println("YES");
            long currentSum = 0;
            for (int i = n; i>0;i--) {
                if(currentSum + i <= target) {
                    firstSet.add(i);
                    currentSum += i;
                }
                else {
                    secondSet.add(i);
                }
            }
            System.out.println(firstSet.size());
            for(int x : firstSet) {
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println(secondSet.size());
            for(int y: secondSet) {
                System.out.print(y+" ");
            }

        }



    }
}
