import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        //frequensi kata
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        //sortir
        return freqMap.entrySet().stream().sorted((e1, e2) -> {
            int cmp = e2.getValue().compareTo(e1.getValue());
            if (cmp == 0) {
                return e1.getKey().compareTo(String.valueOf(e2.getValue()));
            }
            return cmp;
        }).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        String[] words = {"phyton", "java", "golang", "java", "phyton", "phyton"};
        int k = 1;
        List<String> topWords = topKFrequent(words, k);
        System.out.println("top " + k + " words " + topWords);
    }
}
