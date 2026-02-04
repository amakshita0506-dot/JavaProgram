public class Calculator {

    public int addNums(int a, int b) {
        return a + b;
    }

    public int subNums(int a, int b) {
        return a - b;
    }

    public int multiplyNums(int a, int b) {
        return a * b;
    }

    public double divideNums(int a, int b) {
        if (b == 0) {
            System.out.println("ZeroDivisionError");
            return 0;
        }
        return (double) a / b;
    }

    public int modularNums(int a, int b) {
        if (b == 0) {
            System.out.println("ZeroDivisionError");
            return 0;
        }
        return a % b;
    }
}