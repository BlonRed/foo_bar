public class FooBar {
    public boolean processed(int number, int version) {
        if (!isValid(number)) {
            return false;
        }
        switch (version) {
            case 1:
                fooBarVersion1(number);
                break;
            case 2:
                fooBarVersion2(number);
                break;
            case 3:
                fooBarVersion3(number);
                break;
            case 4:
                fooBarVersion4(number);
                break;
            default:
                System.out.println("Value is 'version' invalid. Please choice value from 1 to 4.");
                return false;
        }
        return true;
    }

    public static boolean isValid(int number){
        if (number <= 0) {
            System.out.println("Number less or equal 0. Try again.");
            return false;
        }
        return true;
    }

    private void fooBarVersion1(int n) {
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

    private void fooBarVersion2(int n) {
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

    private void fooBarVersion3(int n) {
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

    private void fooBarVersion4(int n) {
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
            switch (count) {
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