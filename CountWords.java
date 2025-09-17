import java.util.LinkedHashMap;
import java.util.Map;

public class CountWords {
    public static void countWords(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("Teks kosong");
            return;
        }

        String[] words = text.split("\\s+");
        LinkedHashMap<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            String lower = word.toLowerCase();
            freqMap.put(lower, freqMap.getOrDefault(lower, 0) + 1);

        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

    }


    public static void main(String[] args) {
        String text = "This is a test . This Is only a test";
        countWords(text);

    }
}
