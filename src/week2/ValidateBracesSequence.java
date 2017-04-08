/*
Check if sequence of braces is valid or not. 
Given a string:  “ (){}[{{]}} “ say if it is valid or not.
Examples:
“ { [ ( ) } ] ” -> invalid
“ { ( () () ) } “ -> Valid
“ { ( { } ( ) ) } “ -> valid
*/

package week2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class ValidateBracesSequence {
	
	public ValidateBracesSequence() {
		// TODO Auto-generated constructor stub
		createValidCharsHashSet();
	}



	HashSet<Character> validCharSet = new HashSet<>();

	HashSet<Character> openBracesSet = new HashSet<>();

	HashSet<Character> closedBracesSet = new HashSet<>();

	private void createValidCharsHashSet() {
		Character validChars[] =  {'{','}','[',']','(',')'};
		for(int i = 0; i< validChars.length; i++){
			char c = validChars[i];
			validCharSet.add(c);
			if(i%2== 0){
				openBracesSet.add(c);
			}else{
				closedBracesSet.add(c);
			}
		}
		System.out.println("openBracesSet");
		for(Character character : openBracesSet){
			System.out.println(character);
		}
	}
	private boolean validateInp(String inp) {
		// TODO Auto-generated method stub
		//check for invalid char. Character other than "{}[]()"
		
		for(int i = 0; i< inp.length(); i++){
			if(!this.validCharSet.contains(inp.charAt(i)) ){
				return false;
			}
		}
		return true;
	}

	Stack<Character> charStack = new Stack<>();
	
	private void printStack() {
		System.out.println("Printing stack");

		for(Character c: charStack){
			System.out.println(c);
			
		}
	}

	private boolean validateSequence(String inp) {
		// TODO Auto-generated method stub
		if(inp.length() % 2 == 1){
			//odd length'
			System.out.println("odd length");
			return false;
		}else{
			charStack.clear();
			System.out.println("stack cleared");

			printStack();
			for(int i = 0; i< inp.length(); i++){
				Character character = inp.charAt(i);
				System.out.println("character = "+character);
				if(openBracesSet.contains(character)){
					charStack.push(character);
					System.out.println("Pushing");
					printStack();
				}else{
					if(charStack.isEmpty()){
						
						System.out.println("stack empty"+i);

						return false;
					}
					System.out.println("Closed braces! stack NOT empty");

					printStack();
					Character peekChar = charStack.peek();
					System.out.println("peekChar "+peekChar);

					switch(peekChar){
					case '{': if(character == '}'){
						charStack.pop();
						System.out.println("Popping");
						printStack();
						break;
					}else {
						System.out.println("wrong braces - }"+i);

						return false;
					}
					case '[':if(character == ']'){
						charStack.pop();
						System.out.println("Popping");
						printStack();
						break;
					}else {
						System.out.println("wrong braces - ]"+i);

						return false;
					}
					case '(':if(character == ')'){
						charStack.pop();
						System.out.println("Popping");
						printStack();
						break;
					}else {
						System.out.println("wrong braces - )"+i);

						return false;
					}
					}
				}
			}
		}
		return charStack.isEmpty();
	}

	private static String getInput() {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter the braces String: ");
		String ip = reader.nextLine();
		if(ip == null || ip.isEmpty() ){
			System.out.println("Invalid Input. Please enter again");
			System.exit(1);
		}
		return ip;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * String getInput()
		 * 
		 */
		ValidateBracesSequence validateBracesSequence = new ValidateBracesSequence();

		String inp = getInput();
		if(validateBracesSequence.validateInp(inp)){
			
			if(validateBracesSequence.validateSequence(inp)){
				System.out.println("Valid Sequence");
			}else{
				System.out.println("Invalid Sequence");
			}
		}else{
			System.out.println("String contains characters other than \"{,},[,],(,)\"");
			return;
		}
	}

}
