/*
Number given integer: 123
Find the next number which is a palindrome.
The output should be greater than the given number.
Output: 131

Ex 2: 191(already a palindrome) --> o/p = 202

Some Ex:
Single digits 
ip = 9 op = 11
ip = 6 op = 7

Odd num of digits in ip
ip = 455 op = 464 

Even num of digits in ip
ip = 1224 op = 1331
ip = 2351 op = 2442

Involving 9 Special case
ip = 60997 op = 61016 //back tracking might be needed.
ip = 1999 op = 2002
ip = 22999 op = 23032  
ip = 98999 op = 99099  
ip = 99998 op = 99999  



Only 9's (num of digits increased by in o/p)
ip = 9 op = 11
ip = 999 op = 1001 
*/

package week2;

import java.util.Scanner;

public class FindNearestPalindrome {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * String getInput()
		 * 
		 */

		int inp = getInput();
		FindNearestPalindrome findNearestPalindrome = new FindNearestPalindrome();
		int op = findNearestPalindrome.findNearestPalindromeFor(inp, String.valueOf(inp));
		System.out.println("Next palindrome = "+op);
		
	}
	
	private void  printCharArray(char[] ipChArr) {
		System.out.println("Printing char array");

		for(char c: ipChArr){
			System.out.print(c);
		}System.out.println();
	}

	private int findNearestPalindromeFor(int ipi, String ips) {
		// TODO Auto-generated method stub
		//System.out.println(ipi+"   "+ips);			

		char[] ipChArr = ips.toCharArray();
		//System.out.println("IP : Printing char array");
		//printCharArray(ipChArr);
		
		if(inpHasAll9s(ipi, ips)){
			ipi = ipi+1;
			ips = String.valueOf(ipi+1);
		}
		
		if(ipi < 9){
			System.out.println("Single digit. Next palindrome = ");			
			return(ipi+1);
		}else{
			int carry = 0;
			int weight = 0;
			for (int i = ipChArr.length - 1, j= 0 ; i> -1; i--, j++){
				//Integer.parseInt()
				boolean change = false;
				int orig = Character.getNumericValue(ipChArr[i]);
				int ptr1val = orig  + carry ;
				if(ptr1val > 9){
					carry = 1; //carry + ptr1val%10;//carry += 1
					ptr1val = ptr1val % 10;
				}else{
					carry = 0;
				}
				
				//add
				String tmp = Integer.toString(ptr1val);
				
				ipChArr[i] =tmp.charAt(0);	
				int ptr2val = Character.getNumericValue(ipChArr[j]);
				if( i >= (ipChArr.length/2)){
					//re-check needed
					//System.out.println("i >= len/2 char array below. Carry = "+carry);
					//printCharArray(ipChArr);

					if(ptr1val == ptr2val){
						carry = carry + 0;
					}else if (ptr1val > ptr2val){
						carry = 1;
						if(i != j){
							String temp = Integer.toString(ptr2val);
							
							ipChArr[i] =temp.charAt(0);
						}
					}else if (ptr1val < ptr2val){
						if(i != j){
							String temp = Integer.toString(ptr2val);
							
							ipChArr[i] =temp.charAt(0);	
						}
						carry = carry + 0;
					}
				}else{
					if(ptr1val != orig){
						//System.out.println("Printing ptr1val = "+ptr1val);
						//printCharArray(ipChArr);

						String temp = Integer.toString(ptr1val);
						
						ipChArr[i] =temp.charAt(0);
						ipChArr[j] = temp.charAt(0); 
						//System.out.println("Char val j= "+ipChArr[j]+", i ="+ipChArr[i]);

					}
				}
			}
			//printCharArray(ipChArr);

			String ops = String.valueOf(ipChArr);
			int op = Integer.parseInt(ops);
			return op;
		}
	}

	private boolean inpHasAll9s(int ipi, String ips) {
		// TODO Auto-generated method stub
		int temp = ipi;
		for(int i = 0;  i < ips.length(); i++){
			if(temp % 10 != 9){
				return false;
			}
			temp = temp / 10;
		}
		return true;
	}

	private static int getInput() {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter the number: ");
		int ip = reader.nextInt();
		if(ip < 0){
			System.out.println("Number negative");
			System.exit(1);
		}
		return ip;
	}
}
