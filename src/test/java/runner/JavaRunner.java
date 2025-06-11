package runner;



import java.util.ArrayList;

public class JavaRunner {
    public static void main(String[] args) {

        //    Create function to count how many words in this sentence "Welcome to Securiport the science of safer nations" and print the words which start with 's' or 'S'

        String sentence = "Welcome to Securiport the science of safer nations";




    }


    public static String wordCount(String sentence){
        String words[] = sentence.split(" ");
        int count = 0;
        ArrayList<String> wording = new ArrayList<>();

        for(int i = 0 ; i < words.length ; i++){
            if(words[i].toLowerCase().startsWith("s")){
                count++;
                wording.add(words[i]);
            }
        }

        return ("The number of words is " + count +  "\nThe words start with S are " + wording);
    }

}
