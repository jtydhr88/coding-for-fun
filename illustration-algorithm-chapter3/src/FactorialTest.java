public class FactorialTest {

    public static void main(String[] args) throws Exception {
        System.out.println(factorial(4));
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}
