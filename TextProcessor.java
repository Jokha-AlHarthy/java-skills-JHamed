public class TextProcessor {
    // Count words in a sentence
    public static int countWords(String sentence) {
        if(sentence == null || sentence.trim().isEmpty()){
            return 0;
        }
        String [] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null){
            return "";
        }
        return text.replace(oldWord,newWord);
    }

    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";
        int wordCount = countWords(sentence);
        System.out.println("Word count: "+wordCount);
        String newSentence = replaceWord(sentence, "Java", "Programming");
        System.out.println("Replaced sentence: "+newSentence);
    }
}
