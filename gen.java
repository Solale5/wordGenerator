import java.io.File;
import java.util.*;

public class gen{

   static Set<String> hs;
  static  int wordsMade;
  static int wordsTried;
    public static void main(String[] args) {
          wordsMade = 0;
          wordsTried = 0;
          hs = new HashSet<>();
         readFromFile(hs);
         System.out.println(hs.size());


        // char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String letters= "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = letters.toCharArray();
       StringBuilder sb = new StringBuilder();
       int n = 0;
        try{
            n = Integer.parseInt(args[0]);

        }catch (Exception e){
               n = 3;
        }
      generate(alphabet, 1, sb, n);
           System.out.println(wordsMade + " actual words found of length " + n + " out of " + wordsTried +" attempted combos of the characters " + letters); }


     /**
      * runtime O(26^N) lol
      * @param alphabet 
      * @param depth how deep we are in the recursion / how long our word is
      * @param sb string builder
      * @param n how long the word will be
      */
     public static void generate(char[] alphabet, int depth, StringBuilder sb, int n){
         //if the length of the word about to be made is larger than what we specified
         wordsTried++;
         if(depth > n){
                if(hs.contains(sb.toString())){
                    System.out.println(sb.toString());
                    wordsMade++;
                }
                if(sb.toString().equals("solo")){
                    System.out.println("****************");
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