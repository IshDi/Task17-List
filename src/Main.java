import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> basket = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить покупку \n2. Показать покупки \n3. Удалить из покупки");
            String input = scanner.nextLine();
            System.out.println();
            if (input.equals("end")) {
                if (basket.size() == 0) {
                    System.out.println("Корзина пуста!");
                    System.out.println();
                } else {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < basket.size(); i++) {
                        System.out.println((i + 1) + ". " + basket.get(i));
                    }
                }
                System.out.println("Спасибо за покупку!");
                break;
            }
            int numberOption = Integer.parseInt(input);
            switch (numberOption - 1) {
                case 0 -> {
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.nextLine();
                    basket.add(product);
                    System.out.println("Итого в списке покупок: " + basket.size());
                    System.out.println();
                }
                case 1 -> {
                    System.out.println("Список покупок:");
                    if (basket.size() == 0) {
                        System.out.println("Корзина пуста!");
                        System.out.println();
                        continue;
                    } else {
                        for (int i = 0; i < basket.size(); i++) {
                            System.out.println((i + 1) + ". " + basket.get(i));
                        }
                        System.out.println();
                    }
                }
                case 2 -> {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < basket.size(); i++) {
                        System.out.println((i + 1) + ". " + basket.get(i));
                    }
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    System.out.println();
                    String productName = scanner.nextLine();
                    String textOption;
                    try {
                        int productNumber = Integer.parseInt(productName) - 1;
                        textOption = basket.get(productNumber);
                        basket.remove(productNumber);
                    } catch (NumberFormatException e) {
                        textOption = productName;
                        basket.remove(productName);
                    }

                    System.out.println();
                    System.out.println("Покупка \"" + textOption + "\" удалена, список покупок:");
                    if (basket.size() == 0) {
                        System.out.println("Покупок нет!");
                    }
                    for (int i = 0; i < basket.size(); i++) {
                        System.out.println((i + 1) + ". " + basket.get(i));
                    }
                }
                case 3 -> {
                    System.out.println("Введите текст для поиска:");
                    String queryLower = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < basket.size(); i++) {
                        if (basket.get(i).toLowerCase().contains(queryLower)) {
                            System.out.println((i + 1) + ". " + basket.get(i));
                        }
                    }
                }
            }
        }
    }
}
