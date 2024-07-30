
/**
 * Exercise 7: Financial Forecasting
 *
 * Scenario:
 * Developing a financial forecasting tool that predicts future values based on past data.
 *
 * 1. Understand Recursive Algorithms:
 *
 * Recursion:
 * - A method calls itself to solve a smaller instance of the same problem.
 * - Useful for problems that can be broken down into similar subproblems.
 * - Base case: Stops the recursion to avoid infinite loops.
 * - Recursive case: The part of the method that includes the recursive call.
 *
 * 2. Setup:
 * - Create a method to calculate the future value using a recursive approach.
 *
 * 3. Implementation:
 * - Implement a recursive algorithm to predict future values based on past growth rates.
 *
 * 4. Analysis:
 * - Discuss the time complexity of your recursive algorithm.
 * - Explain how to optimize the recursive solution to avoid excessive computation.
 *
 * Time Complexity Analysis:
 * - The time complexity of the basic recursive approach is O(n), where n is the number of years to predict.
 * - Optimization using memoization can reduce redundant calculations, improving efficiency.
 */

public class Exercise7 {

    /**
     * Predict future value using a recursive approach.
     *
     * @param initialValue The initial value.
     * @param growthRate   The growth rate (as a decimal, e.g., 0.05 for 5%).
     * @param years        The number of years to predict.
     * @return The predicted future value.
     */
    public static double predictFutureValueRecursive(double initialValue, double growthRate, int years) {
        // Base case: if years is 0, the future value is the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: calculate the future value for the remaining years
        return predictFutureValueRecursive(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    /**
     * Optimized prediction using memoization to avoid excessive computation.
     *
     * @param initialValue The initial value.
     * @param growthRate   The growth rate (as a decimal).
     * @param years        The number of years to predict.
     * @param memo         Memoization array to store previously computed values.
     * @return The predicted future value.
     */
    public static double predictFutureValueMemo(double initialValue, double growthRate, int years, Double[] memo) {
        // Base case: if years is 0, the future value is the initial value
        if (years == 0) {
            return initialValue;
        }
        // Check if the value has already been computed
        if (memo[years] != null) {
            return memo[years];
        }
        // Compute the value and store it in the memoization array
        memo[years] = predictFutureValueMemo(initialValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        // Predict future value using the basic recursive approach
        double futureValueRecursive = predictFutureValueRecursive(initialValue, growthRate, years);
        System.out.println("Predicted Future Value (Recursive): " + futureValueRecursive);

        // Predict future value using the optimized recursive approach with memoization
        Double[] memo = new Double[years + 1];
        double futureValueMemo = predictFutureValueMemo(initialValue, growthRate, years, memo);
        System.out.println("Predicted Future Value (Memoization): " + futureValueMemo);
    }
}

/**
 * Analysis:
 *
 * Time Complexity:
 * - The time complexity of the basic recursive approach is O(n), where n is the number of years to predict.
 * - The time complexity of the memoized recursive approach is also O(n), but it avoids redundant calculations, making it more efficient in practice.
 *
 * Optimization:
 * - Memoization: Store previously computed values in an array to avoid recomputation, reducing the number of recursive calls.
 * - This technique ensures that each value is computed only once, improving efficiency and reducing the overall computation time.
 */
/*
Expected Output:
Predicted Future Value (Recursive): 1276.2815625000003
Predicted Future Value (Memoization): 1276.2815625000003
 */
