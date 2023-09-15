package io.ravi.programs;

public class RemoveIfUpperLowerPairAdjacent {
    public static void main(String[] args) {

        //Example 1 :  "aAcbBadEFCcaa" -> "cadEFaa"
        //Example 2 : "dDHcbBdEF" -> "HcdEF"
        System.out.println( removePairIfUpperLower("CaAcCbBcadEFCcaa"));
        System.out.println( removePairIfUpperLower("dDHcbBdEF"));
        System.out.println(removePairIfUpperLower("CbAaBcA"));
    }

    private static String removePairIfUpperLower(String s) {
        int i = 0;
        int j = 0;
        char[] r = new char[s.length()];
        while (i < s.length() - 1) {
            if (s.charAt(i) - 'a' == s.charAt(i + 1) - 'A') {
                i = i + 2;
                continue;
            }
            if (s.charAt(i) - 'A' == s.charAt(i + 1) - 'a') {
                i = i + 2;
                continue;
            }

            if (j < s.length()) {
                r[j] = s.charAt(i);
                j++;
            }

            if(j>=2) {
                if (r[j-2] - 'a' == r[j-1] - 'A' || r[j-2] - 'A' == r[j-1] - 'a') {
                    j = j -2;
                }
            }
            i++;
        }
        if (i < s.length()) {
            while (i < s.length()) {
                r[j] = s.charAt(i);
                j++;
                i++;
            }
        }
        StringBuilder fr = new StringBuilder();
        for (int index = 0; index < j; index++) {
            fr.append(r[index]);
        }
        return fr.toString();
    }
}
