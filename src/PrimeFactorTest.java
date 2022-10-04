package q5;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeFactorTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the number to factor:");
        try {
            int n = in.nextInt();
            PrimeFactorizer prime = new PrimeFactorizer(n);
            System.out.println(prime);
        } catch (InputMismatchException | IllegalArgumentException e){
            System.out.println("Error, must enter positive non-zero integer!");
            System.exit(1);
        } catch (ArithmeticException e){
            System.out.println("1 is neither prime nor composite.");
            System.exit(1);
        }
    }
}
