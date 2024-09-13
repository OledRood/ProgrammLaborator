public class Palindrome {
    public static void main(String[] args) {
        for (int index = 0; index < args.length; index++) {
            String word = args[index];
            String reversedWord = reverseString(word);

            if (word.equals(reversedWord)) {
                System.out.println("Слово " + word + " является полиндромом");
            } else {
                System.out.println("Слово " + word + " не является полиндромом");
            }
        }
    }

    static String reverseString(String word) {
        String newWord = "";
        for (int letterIndex = (word.length() - 1); letterIndex >= 0; letterIndex--) {
            newWord += word.substring(letterIndex, letterIndex + 1);

        }
        return newWord;

    }
}