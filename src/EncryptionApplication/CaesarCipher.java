package EncryptionApplication;

public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(encrypt("FREE CAKE IN THE CONFERENCE ROOM!", 17));

    }

    static String encrypt(String words, int key) {
        // Letter string
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabet.toUpperCase();
        // Declare the shiftedAlphabet
        // The alphabet.substring(key) is the letters from the keyth to the last letter
        // The alphabet.substring(0, key) is the letters from 0 to the keyth letter
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        // Declare the newWords
        String newWords = "";
        for (int i = 0; i < words.length(); i++) {
            // Declare the currentCharacter and store the ith character to the currentCharacter
            var currentCharacter = words.charAt(i);
            // Check if the currentCharacter is in the alphabet
            // Check if character in string
            if (alphabet.indexOf(currentCharacter) != -1) {
                // Find the index of currentCharacter in alphabet
                // Add the corresponding character in shiftedAlphabet to newWords
                newWords = newWords + shiftedAlphabet.charAt(alphabet.indexOf(currentCharacter));

            } else {
                newWords = newWords + currentCharacter;

            }

        }

        return newWords;

    }

}

















