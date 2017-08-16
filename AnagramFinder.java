import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;
import java.util.Map;
public class AnagramFinder {

	public static void main(String[] args)
	{
   		double count = 0,countBuffer=0;
		String lineNumber = "";
		BufferedReader lr;
		String inputSearch = "";
		Map wordSet=createHashmap();
		System.out.print("Enter your word: ");
		lr = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputSearch = (lr.readLine()).toLowerCase();
			int i=(createHashmap().size());
			for( ;i>0;i--){
			//System.out.println(createHashmap().get(i));
			 if (areAnagrams(inputSearch,(createHashmap().get(i)).toString())) {
				  
                    count++;
                    countBuffer++;
					System.out.println(createHashmap().get(i));
                  }
				   
                }
			
			
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		System.out.println("Times found at--"+count);
		System.out.println("Word found at--"+lineNumber);
	}
	public static Map  createHashmap(){
		int countLine=0;
		String filePath = "words_anagram.txt";
		String line = "";
		BufferedReader br;
		Map<Integer,String> words = new Hashtable<Integer, String>();
		try{
		br = new BufferedReader(new FileReader(filePath));
		   
    
		try {
			
				while((line = br.readLine()) != null)
				{
				countLine++;
				 words.put(countLine,line);  
				}
				
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words; 
	}
	public static boolean areAnagrams(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		return Arrays.equals(ch1,ch2);
	}
}
