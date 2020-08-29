/*
 *Paul Nguyen
 *CSC.251.0001
 *Unit 11
*/

import java.util.Scanner;

public class SallySpeakSolution extends java.lang.Object{
	
	//Instance Variables
	Scanner tokenizer;
	String token;
	boolean legal = true;
	
	//Constructor
	public SallySpeakSolution(java.lang.String stringToParse) {
		tokenizer = new Scanner(stringToParse);
		nextToken();
	}
	
	//Advance the token
	public void nextToken() {
		if(!legal) {
			return;
		}
		
		if(tokenizer.hasNext()) {
			token = tokenizer.next();
			
		}else {
			token = "bite";
		}
	}
	
	/*
	 * Processes <reaction> ::= earperk{tailwag}
	 * If legal is true, look for "earperk". 
	 * If it's present, look for zero or more "tailwag".
	 */	
	
	public void reaction() {
		if(!legal) {
			return;
		}
		
		if(token.equals("earperk")) {
			nextToken();
			while(token.equals("tailwag")) {
				nextToken();
			}
			
		}else {
			legal = false;
		}
	}
	
	
	/*
	 * Processes <expression> ::= bark <whimpergrowl><reaction>
	 * If legal is true, look for "bark". Upon finding
	 * "bark", advance the token and call whimpergrowl. If legal is still true, call
	 * reaction.
	 */
	
	public void expression() {
		if(!legal) {
			return;
		}
		
		if(token.equals("bark")) {
			nextToken();
			whimpergrowl();
			if(legal == true) {
				reaction();
			}
			
		}else {
			legal = false;
		}
	}
	
	//Processes <whimpergrowl> ::= whimper | growl
	public void whimpergrowl() {
		if(!legal) {
			return;
		}
		
		if(token.equals("whimper")||token.equals("growl")){
			nextToken();
			
		}else {
			legal = false;
		}
	}

	/*
	 * Determines if input is syntactically correct
	 * This method evaluates the sallyspeak production
	 * <sallyspeak> ::= <reaction><expression>{<expression>}
	 * Call the reaction method. if legal is still true, 
	 * call expression method. Then look for more expressions. 
	 * As long as legal is true, and token indicates
	 * that the input isn't exhausted, call expression.
	 * When all of that is over, return the value of legal.
	 */	
	
	public boolean isLegal() {
		if(legal == true) {
			reaction();
			
		}if(legal == true) {
			expression();
			
		}if(legal == true && !token.equals("bite")) {
			expression();
			
		}
		return legal;
	}
}
