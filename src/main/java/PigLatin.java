import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(processword(lines[i]));
	    }
    }
    String[] words = {"beast","dough","happy","question","star","three","eagle","try"};
    String[] vowels = {"a", "e", "i", "o", "u"};


private boolean containsvowel(String s){
  for(String vowel: vowels){
    if(contains(s, vowel)){return true;}
  }
  return false;
}

private boolean contains(String a, String b){
  for(int i=0; i<a.length(); i++){
    if(a.substring(i, i+1).equals(b)){
      return true;
    }
  }
  return false;
}

private String processword(String s){
  boolean flag = false;
  if(!containsvowel(s)){return s+"ay";}
  if(containsvowel(s.substring(0,1))){return s+"way";}
  else{flag = true;}
  if(s.length()>=2&&s.substring(0,2).equals("qu")){return s.substring(2)+"quay";}
  if(flag){return s.substring(1)+s.substring(0,1)+"ay";}
  return new String();
}
}//end PigLatin class
