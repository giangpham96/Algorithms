package others.recursion;

public class Exponentiation {
    public static void main(String[] args) {
        Exponentiation exponentiation = new Exponentiation();
        System.out.println(exponentiation.slowPower(4, 5));
        System.out.println(exponentiation.fastPower(4, 5));
        System.out.println(exponentiation.slowPower(5, 4));
        System.out.println(exponentiation.fastPower(5, 4));
    }

    /**
     * The slower way to calculate a^x
     * Run-time: O(n)
     *
     * @param base a
     * @param exponent x
     * @return a^x
     */
    public int slowPower(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
    /**
     * The faster way to calculate a^x
     * Run-time: O(lg n)
     *
     * @param base a
     * @param exponent x
     * @return a^x
     */
    public int fastPower(int base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        int x = fastPower(base, exponent/2);
        if(exponent % 2 == 0) {
            return x * x;
        } else {
            return x * x * base;
        }
    }
}
