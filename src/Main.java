import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        char choice;

        do {
            System.out.print("Enter 1st number: ");
            int n1 = sc.nextInt();

            System.out.print("Enter 2nd number: ");
            int n2 = sc.nextInt();

            System.out.print("Enter operation (+ - * / %): ");
            char op = sc.next().charAt(0);

            switch (op) {
                case '+':
                    System.out.println("Result: " + cal.addNums(n1, n2));
                    break;
                case '-':
                    System.out.println("Result: " + cal.subNums(n1, n2));
                    break;
                case '*':
                    System.out.println("Result: " + cal.multiplyNums(n1, n2));
                    break;
                case '/':
                    System.out.println("Result: " + cal.divideNums(n1, n2));
                    break;
                case '%':
                    System.out.println("Result: " + cal.modularNums(n1, n2));
                    break;
                default:
                    System.out.println("Invalid operation");
            }

            System.out.print("Do you want to continue (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
        System.out.println("Program ended.");
    }
}
