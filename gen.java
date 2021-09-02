import java.io.File;
import java.util.*;

public class gen{

   static Set<String> hs;
  static  int wordsMade;

    public static void main(String[] args) {
          wordsMade = 0;
          hs = new HashSet<>();
         readFromFile(hs);
         System.out.println(hs.size());


        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
       StringBuilder sb = new StringBuilder();
        int n = 5;
      generate(alphabet, 1, sb, n);
           System.out.println(wordsMade + " words of length " + n);

    }
     /**
      * runtime O(26^N) lol
      * @param alphabet 
      * @param depth how deep we are in the recursion / how long our word is
      * @param sb string builder
      * @param n how long the word will be
      */
     public static void generate(char[] alphabet, int depth, StringBuilder sb, int n){
        

        if(depth == n+1){
                if(hs.contains(sb.toString())){
                    System.out.println(sb.toString());
                    wordsMade++;
                }
                return;

        }
        for(int i = 0; i < alphabet.length; i++){
            sb.append(alphabet[i]);
            generate(alphabet, depth+1, sb, n);
            sb.deleteCharAt(sb.length()-1);

        }



     }

     public static void readFromFile(Set<String> hs) {
       

        try {
            // File myObj = new File("dictionary.txt");
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String word= myReader.nextLine();
                // String[] format = word.split(" ");
                
                hs.add(word);
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Loading Complete");
    }






}