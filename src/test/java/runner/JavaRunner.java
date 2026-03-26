package runner;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class JavaRunner {
    public static void main(String[] args) {

//        1.Given a string s, find the length of the longest substring without duplicate characters.        String s = "abcabcbb";
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//
//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//
//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//        2. Create function to count how many words in this sentence "Welcome to Securiport the science of safer nations" and print the words which start with 's' or 'S'.
//
//
//        3.Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//        Each number in candidates may only be used once in the combination.
//        Note: The solution set must not contain duplicate combinations.
//        Example 1:
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//[[1,1,6],[1,2,5],[1,7],[2,6]]
//        Example 2:
//        Input: candidates = [2,5,2,1,2], target = 5
//        Output:
//[[1,2,2],[5]]
//
//
//        4.User logs into eBay, types "Laptop" (type as "Laptop"), searches for the product, and prints the total number of products displayed along with product names.
//

        //Create function to count how many words in this sentence "Welcome to Securiport the science of safer nations" and print the words which start with 's' or 'S'.

//        String s = "Welcome to Securiport the science of safer nations";
//
//        printWords(s);

for(int i =0 ; i <350; i++){
//    String documentNumber = randomDocumentNumber(); // Store the return value
//    String dateOfBirth = generateRandomDOB();
    String randomName = generateRandomWord();
    System.out.println(randomName);
}




    }



    public static String generateRandomWord() {
        Random random = new Random();

        // Generate a random word length between 3 and 10
        int wordLength = 3 + random.nextInt(8);
        StringBuilder word = new StringBuilder();

        // Generate random lowercase letters
        for (int i = 0; i < wordLength; i++) {
            char randomLetter = (char) ('a' + random.nextInt(26));
            word.append(randomLetter);
        }

        return word.toString();
    }

    public static String randomDocumentNumber(){
        Random random = new Random();

        // Generate two random uppercase letters
        char firstLetter = (char) ('A' + random.nextInt(26));
        char secondLetter = (char) ('A' + random.nextInt(26));

        // Generate a random 9-digit number
        int number = 100000000 + random.nextInt(900000000);

        // Combine the letters and number
        return "" + firstLetter + secondLetter + number;
    }

    public static String generateRandomDOB() {
        // Define the start and end dates
        LocalDate startDate = LocalDate.of(1940, 1, 1);
        LocalDate endDate = LocalDate.of(2008, 12, 31);

        // Generate a random date between startDate and endDate
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(), endDate.toEpochDay() + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);

        // Return the date in the format YYYY-MM-DD
        return randomDate.toString();
    }

    public static void printWords(String sentences){
        int count = 0;
        String[] words = sentences.split(" ");
        int result = words.length;

        for (String word: words){
            if((word.length() == 0)  && word.charAt(0) =='S' || word.charAt(0) == 's'){
                System.out.println(word);
                count++;
            }
        }
        System.out.println("Total word count in this sentence : " + result + ", totals words starting with 'S' or 's' + "+count);
    }






}
