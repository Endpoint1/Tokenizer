/* Summary:

	- Tokenizer now doesn't tokenize apostrophes.
	- "O'connor" previously became "oconnor". Now, it's "o'connor".
	- this is almost identical code to TagTokenizer... with a simple change (method Overriding)
	- The idea was copied from yours in class, plus it was easy to implement.
	- Implementation: just commented the apostrophe handling.
	- A proof of concept, if you will.
	- I can do more if requested.
*/ 


package org.galagosearch.exercises;
import org.galagosearch.core.parse.TagTokenizer;

public class Tokenizer extends TagTokenizer {

	@Override
	protected String tokenSimpleFix(String token) {
		/* All that will follow is github copypaste. Might want to know how to @override */
		//I'm going to keep apostrophes because, why not
		
		char[] chars = token.toCharArray();
		int j = 0;

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];
			boolean isAsciiUppercase = (c >= 'A' && c <= 'Z');
			boolean isApostrophe = (c == '\'');

			if (isAsciiUppercase) { 
				
				chars[j] = (char) (chars[i] + 'a' - 'A');
			} 

			/*else if (isApostrophe) {
				
				// if it's an apostrophe, skip it - from galago
				// I actually want the apostrophe, so I'm going to comment this stuff
				j++;
			
			}*/ 

			else {
			
				chars[j] = chars[i];
			}

			j++;
			
		}

		token = new String(chars, 0, j);
		return token;	
	}

}
