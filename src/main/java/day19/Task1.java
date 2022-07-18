package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */
public class Task1 {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "D:" + separator + "Java" + separator + "JavaMarathon2021" + separator + "JavaMarathon2021" +
                separator + "src" + separator + "main" + separator + "resources" + separator + "dushi.txt";
        File dushi = new File(path);
        System.out.println(mostUsed100Words(dushi));
    }

    public static Map<String, Integer> mostUsed100Words(File file) {
        Map<String, Integer> sorted100WordAndCount = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[.,:;()?!\"\\s–]+");
            Map<String, Integer> unsortedWordAndCount = new HashMap<>();    // Получение HashMap ключ-слово,значение-количество
            while (scanner.hasNextLine()) {
                String key = scanner.next().toLowerCase();
                if (!prepositionsAndConjunctions().contains(key)) {         // Сравнение слова с HashSet предлоги,союзы
                    if (!unsortedWordAndCount.containsKey(key)) {
                        unsortedWordAndCount.put(key, 1);
                    } else {
                        unsortedWordAndCount.replace(key, unsortedWordAndCount.get(key) + 1);
                    }
                }
            }
            List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedWordAndCount.entrySet());  // Для сортировки HashMap переносим в LinkedList
            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            int count = 0;      // Перенос 100 первых объектов отсортированной LinkedList в LinkedHashMap
            for (Map.Entry<String, Integer> entry : list) {
                sorted100WordAndCount.put(entry.getKey(), entry.getValue());
                count++;
                if (count == 100) {
                    break;
                }
            }
            System.out.println("Чичиков - " + sorted100WordAndCount.get("чичиков"));   // чичиков - 601.
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
        }
        return sorted100WordAndCount;
    }

    public static Set<String> prepositionsAndConjunctions() {       // Возврат HashSet предлоги-союзы
        File file = new File("prepositionsAndConjunctions.txt");
        Set<String> prepositionsAndConjunctions = new HashSet<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                prepositionsAndConjunctions.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File prepositionsAndConjunctions.txt not found");
        }
        return prepositionsAndConjunctions;
    }
}
