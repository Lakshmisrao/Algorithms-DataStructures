import java.io.*;
import java.util.*;

class WordCount {

  public static String[][] wordCountEngine(String document) {

    String trimmedDoc = document.trim();
    String x = trimmedDoc.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    String[] words = x.split(" ");
    HashMap<String, Integer> wordsCountMap = new HashMap<>();
    for(int i =0; i< words.length; i++){
      String word = words[i];
      int cnt = 0;
      if(wordsCountMap.containsKey(word)){
        cnt = wordsCountMap.get(word);
      }
      wordsCountMap.put(word,cnt+1);
      
    }
    
    String[][] op = new String[wordsCountMap.size()][2];

    int i = 0;
    
// 3 approaches to iterate over hashmap
//1. keySet()
//     for(String word: wordsCountMap.keySet()){
//       String cnt = wordsCountMap.get(word).toString();
//       String[] newWord = {word, cnt};
//       op[i] = newWord;
//       //System.out.println(word+" "+cnt);
//       i++;
//     }
//2. Iterator
//     Iterator it = wordsCountMap.entrySet().iterator();
//     while(it.hasNext()){
//       Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>) it.next();
//       System.out.println(pair);
//       //String[] parts = 
//       String[] newWord = {pair.getKey(), pair.getValue().toString()};
//       op[i] = newWord;
//       i++;     
//      }
//3. Using Map.Entry --> the best approach.
    for(Map.Entry<String, Integer> entry: wordsCountMap.entrySet()){
      String[] newWord = {entry.getKey(), entry.getValue().toString()};
      op[i] = newWord;
      i++;
    }
    return op; 
  }

  public static void main(String[] args) {
 
    String[][] op = wordCountEngine("Practice makes man perfect! Women are already perfect!! Ha ha :) Don't you agree?");
    for(int i = 0; i< op.length;i++){
      System.out.println(op[i][0]+" "+op[i][1]);
    }
  }

} 

/*Output
1
practice 1
perfect 2
are 1
already 1
makes 1
ha 2
man 1
agree 1
dont 1
you 1
women 1
*/
