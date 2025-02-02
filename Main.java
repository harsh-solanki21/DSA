import java.util.*;

public class Main {

// Example: array = [1,2,3,4]
// Subarray : [1,2],[1,2,3] - is continuous and maintains relative order of elements, Subarrays: n*(n+1)/2
// Subsequence: [1,2,4] - is not continuous but maintains relative order of elements, Subsequences: 2^n-1
// Subset: [1,3,2] - is not continuous and does not maintain relative order of elements, subsets: 2^n


    // with auxiliary array
    static String encryptString1(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                char ch = (char) ('a' + i);
                sb.append(count[i]).append(ch);
            }
        }

        return sb.toString();
    }


    // with Hashmap
    static String encryptString2(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Character, Integer> entry : hm.entrySet()) {
            sb.append(entry.getValue()).append(entry.getKey());
        }

        return sb.toString();
    }


    // with prev count
    static String encryptString3(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(count).append(str.charAt(str.length() - 1));
        return sb.toString();
    }


    public static void main(String[] args) {
//        String str = "aaaabbcdddddeff";
        String str = "aaaabbcdddddef";

        System.out.println(encryptString1(str));
        System.out.println(encryptString2(str));
        System.out.println(encryptString3(str));
    }

}
