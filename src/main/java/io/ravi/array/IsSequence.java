package io.ravi.array;

public class IsSequence {

    public static void main(String[] args) {

        String word = "azybczx";
        String sequence = "zab";

        System.out.println(isSequence1(word, sequence));

    }

    private static boolean isSequence1(String word, String sequence){

        int wordLength = word.length();
        int sequenceLength = sequence.length();
        int sequenceIndex = 0;

        for(int i = 0; i < wordLength; i++){
            if(sequenceIndex == sequenceLength) return true;
            if(word.charAt(i) == sequence.charAt(sequenceIndex)){
                sequenceIndex++;
            }
        }

        return sequenceIndex == sequenceLength;
    }

    private static boolean isSequence(String word, String sequence) {

        int wIndex = 0;
        int sIndex = 0;
       StringBuilder result = new StringBuilder();

        while (wIndex < word.length() && sIndex < sequence.length()) {
             char sequenceChar = sequence.charAt(sIndex);
             char wordChar = word.charAt(wIndex);
             while(wIndex < word.length()-1 && sequenceChar != wordChar) {
                 wIndex++;
                 wordChar = word.charAt(wIndex);
             }
            result.append(wordChar);
            sIndex++;
            wIndex++;
        }

        if(sequence.equals(result.toString())) {
            return true;
        }

        return false;
    }
}
