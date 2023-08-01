import java.util.Scanner;

public class MainFooBar {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        int number;
        int version; // version of the program implementation
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter number: ");
            number = scanner.nextInt();
            System.out.println("Choose the version, from 1 to 4: ");
            version = scanner.nextInt();
        } while (!fooBar.processed(number, version));
    }
}
