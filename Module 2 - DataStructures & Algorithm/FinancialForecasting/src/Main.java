/**
 * Basic recursive solution: O(n) <br>
 * DP/Memoization can be applied, but there are no overlapping subproblems, so it provides little benefit.
 */

public class Main {

    public static double FinancialForecasting(double fv, int years, double rate) {

        if (years == 0) {
            return fv;
        }


        return FinancialForecasting(fv * (1 + rate/100), years - 1, rate);
    }


    public static void main(String[] args) {

        System.out.println(FinancialForecasting(20000, 5, 10));

    }

}


