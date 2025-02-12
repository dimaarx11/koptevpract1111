import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userString = getValidString(scanner);

        while (true) {

            System.out.println("Оберіть дію:");
            System.out.println("1 - Перевернути весь рядок");
            System.out.println("2 - Перевернути кожне слово");
            System.out.println("3 - Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Результат: " + reverseString(userString));
            } else if (choice.equals("2")) {
                System.out.println("Результат: " + reverseEachWord(userString));
            } else if (choice.equals("3")) {
                System.out.println("Програма завершена.");
                break;
            } else {
                System.out.println("Некоректний вибір, спробуйте ще раз.");
            }
        }

        scanner.close();
    }

    private static String getValidString(Scanner scanner) {
        while (true) {
            System.out.print("Введіть рядок (мінімум 2 слова, кожне не менше 3 символів): ");
            String input = scanner.nextLine().trim();
            String[] words = input.split("\\s+");

            if (words.length >= 2) {
                boolean isValid = true;

                for (String word : words) {
                    if (word.length() < 3) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    return input;
                }
            }

            System.out.println("Некоректний ввід! Спробуйте ще раз.");
        }
    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }


    private static String reverseEachWord(String s) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }
}
