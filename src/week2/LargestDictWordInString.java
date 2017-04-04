/*
Dictionary given:
{“car”, “bar”, “door”, “geekforgeeks”}
String given:
“Bageekareforbbgeeks” 
Find the largest word in the dictionary present in the string*/

/*
String length => m
No. of words in dict => n
Complexity => O(m . n)
*/

package week2;

import java.util.List;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner; 


public class LargestDictWordInString {
	
	public LargestDictWordInString() {
		// TODO Auto-generated constructor stub
		wordDict = new ArrayList<String>();

		for(String w:words ){
			wordDict.add(w);
		}
		
	}

	List<String> wordDict;
	String words[] = {"car","bar","galaxy", "door","geekforgeeks"};
	ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();

	
	private void preProcessDictBasedOnIpStrLen(int slen) {
		//based on desc order of length
		ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
		for(int i =0; i< slen; i++){
			ArrayList<String> arrList = new  ArrayList<String>();
			listOLists.add(arrList);
		}
		for(String w: wordDict){
			int wlen = w.length();
			if( wlen > slen){
				continue;
			}else{
				listOLists.get(wlen-1).add(w);
			}
		}
		this.listOLists = listOLists;
	}

	
	private String findLargestWord(String ip) {
		for(int i = this.listOLists.size() -1 ; i> -1 ; i--){
			ArrayList<String> wordsList = this.listOLists.get(i);
			for(String word: wordsList){
				int j , k;
				int wlen = word.length();
				for(j = 0, k = 0; j < wlen && k < ip.length();){
					if(word.charAt(j) == ip.charAt(k)){
						j++;
						k++;
					}else{
						k++;
					}
				}
				if(j == wlen){
					return word;
				}
			}
		}
		return null;
	}

	
	public static void main(String args[]) {
		LargestDictWordInString obj = new LargestDictWordInString();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a String: ");
		String ip = reader.nextLine();
		if(ip == null || ip.isEmpty()){
			System.out.println("Enter proper word.");			
			return;
		}
		int slen = ip.length();
		obj.preProcessDictBasedOnIpStrLen(slen);
		String output = obj.findLargestWord(ip);
		if( output != null){
			System.out.println("Largest word = "+ output);
		}else{
			System.out.println("No word found");			
		}
		
		
	}
}
