import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<String, String> phonebook = new TreeMap<>();
        phonebook.put("89024718666", "Вася");
        phonebook.put("89222360855", "Юля");
        phonebook.put("88093451353", "Олег");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя или номер, для отображения всего списка введите LIST");
            String command = scanner.next();


            if (isNumeric(command)) {
                if (!(phonebook.containsKey(command))) {
                    System.out.println("Введите имя");
                    String addName = scanner.next();
                    if (addName.matches("\\D+\\s?\\D+")) {
                        phonebook.put(command, addName);
                    }else {
                        System.out.println("Неверный формат ввода");
                    }
                } else {
                    int index = new ArrayList<>(phonebook.keySet()).indexOf(command);
                    System.out.println(phonebook.values().toArray()[index] + " " + command);
                }
            } else if (command.equals("LIST")) {
                Map<String,String> result = new LinkedHashMap<>();
                phonebook.entrySet().stream()
                        .sorted(Map.Entry.<String,String>comparingByValue())
                        .forEachOrdered( x -> result.put(x.getKey(), x.getValue()));
                for(Map.Entry<String,String> entry : result.entrySet()) {
                    System.out.println(entry.getValue() + " " + entry.getKey());
                }
            } else {
                if (!(phonebook.containsValue(command))) {
                    System.out.println("Введите номер: ");
                    String addNumber = scanner.next();
                    if (addNumber.matches("\\d{5,}")) {//2665299
                        phonebook.put(addNumber, command);
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                } else {
                    int index = new ArrayList<>(phonebook.values()).indexOf(command);
                    System.out.println(command + " " + phonebook.keySet().toArray()[index]);
                }
            }
        }
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}



