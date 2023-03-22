import java.util.Scanner;

public class FooBar {
    public void fooBarVersion1(int n) {
        int from = 1;
        for (int num = from; num <= n; num++) {
            if (num % 15 == 0) {
                System.out.println("FooBar");
            } else if (num % 3 == 0) {
                System.out.println("Foo");
            } else if (num % 5 == 0) {
                System.out.println("Bar");
            } else {
                System.out.println(num);
            }
        }
    }

    public void fooBarVersion2(int n) {
        int from = 1;
        for (int num = from; num <= n; num++) {
           var result = "";
            if (num % 3 == 0) {
                result += "Foo";
            }
            if (num % 5 == 0) {
                result += "Bar";
            }
            System.out.println(result.equals("") ? num : result);
        }
    }

    public void fooBarVersion3(int n) {
        int num = n;
        var result = "";

        if (num > 1) {
            fooBarVersion3(--n);
        }
        if (num % 15 == 0) {
            result = "FooBar";
        } else if (num % 3 == 0) {
            result = "Foo";
        } else if (num % 5 == 0) {
            result = "Bar";
        } else {
            result = String.valueOf(num);
        }

        System.out.println(result);
    }

    public void fooBarVersion4(int n) {
        int from = 1;
        int count;
        boolean foo, bar;
        String result;
        for (int num = from; num <= n; num++) {
            count = 0;
            foo = num % 3 == 0;
            bar = num % 5 == 0;

            if (foo) count++;
            if (bar) count++;
            switch (count){
                case 1:
                    result = foo ? "Foo" : "Bar";
                    break;
                case 2:
                    result = "FooBar";
                    break;
                default:
                    result = String.valueOf(num);
                    break;
            }
            System.out.println(result);
        }
    }
}

class FooBarMain {
    public static void main(String[] args) {
        FooBar fB = new FooBar();
        int number;
        int version; // version of the program implementation
        boolean run = true;

        do {
            System.out.println("Enter version: ");
            version = new Scanner(System.in).nextInt();
            if (version >= 0 && version <= 4) {
                System.out.println("Enter number: ");
                number = new Scanner(System.in).nextInt();
                if (number > 0) {
                    switch (version){
                        case 1:
                            fB.fooBarVersion1(number);
                            run = false;
                            break;
                        case 2:
                            fB.fooBarVersion2(number);
                            run = false;
                            break;
                        case 3:
                            fB.fooBarVersion3(number);
                            run = false;
                            break;
                        case 4:
                            fB.fooBarVersion4(number);
                            run = false;
                            break;
                    }
                } else System.out.println("Number less or equal 0. Try again.");
            }else System.out.println("Value is 'version' invalid. Please choice value from 1 to 4.");
        } while (run);
    }
}
