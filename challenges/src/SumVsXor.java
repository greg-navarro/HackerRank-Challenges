public class SumVsXor {
    public static long sumXor(long n) {
        // Write your code here
        long result = 0;
        long operand = 0;
        while (operand < n) {
            long sum = n + operand;
            long exor = n ^ operand;
            if (sum == exor) result++;
            operand++; 
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}
