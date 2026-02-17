package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
                i++;
            }
        }
    }


    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String current = list.get(i);
            list.add(i + 1, current);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();
        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int element = queue.poll();
            stack.push(element);
            queue.offer(element);
        }

        for (int i = 0; i < size; i++) {
            int element = queue.poll();
            int stackElement = stack.pop();
            if (element != stackElement) {
                isPalindrome = false;
            }
            queue.offer(element);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num < 0) {
                stack.push(num);
            } else {
                queue.offer(num);
            }
        }

        int negativeCount = stack.size();

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < size - negativeCount; i++) {
            queue.offer(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.offer(num);
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pollLast());
        }
    }

    public int maxLength(Set<String> set) {
        if (set.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new java.util.HashSet<>(list1);
        Set<Integer> set2 = new java.util.HashSet<>(list2);

        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new java.util.HashSet<>();
        for (String value : map.values()) {
            if (values.contains(value)) {
                return false;
            }
            values.add(value);
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new java.util.HashMap<>();

        for (String key : map1.keySet()) {
            Integer value = map1.get(key);

            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new java.util.HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> frequency = new java.util.HashMap<>();

        for (Integer value : map.values()) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        int rarestValue = Integer.MAX_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();

            if (freq < minFrequency || (freq == minFrequency && value < rarestValue)) {
                minFrequency = freq;
                rarestValue = value;
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> frequency = new java.util.HashMap<>();

        for (Integer num : list) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (Integer count : frequency.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

}
