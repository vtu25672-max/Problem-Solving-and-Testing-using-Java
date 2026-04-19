import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // 1. Count frequencies
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Use a Max-Heap to store characters based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        // 3. Build the result string
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = counts.get(c);
            for (int i = 0; i < count; i++) {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}
