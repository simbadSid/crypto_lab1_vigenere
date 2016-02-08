package crypto;

import java.util.LinkedList;
import java.util.Scanner;








public class CryptoTools
{
// ------------------------------------------------------
// Attributes:
// ------------------------------------------------------
	public final static int nbrAlphabeticChar	= 25;

// ------------------------------------------------------
// Local methodes
// ------------------------------------------------------
	/**=============================================================
	 * Transform an alphabetic char to an integer between 0 and 25.
	 * If the char is not an alphabetic char, -1 is returned
	 ===============================================================*/
	public static int alphabeticCharToNumerical(char c)
	{
		if		((c >= 'a') && (c <= 'z'))	return (c - 'a');
		else if	((c >= 'A') && (c <= 'Z'))	return (c - 'A');
		else								return -1;
	}

	/**=============================================================
	 * Transform an alphabetic char to an integer between 0 and 25.
	 * If the char is not an alphabetic char, -1 is returned
	 ===============================================================*/
	public static int shiftNumericalChar(int n, int shift)
	{
		if ((n < 0)	|| (n > 25))			throw new RuntimeException("Unhandeled char to shift: " + n);
		if ((shift < -nbrAlphabeticChar) ||
			(shift > nbrAlphabeticChar))	throw new RuntimeException("Unhandeled shift: " + shift);

		if		(shift >= 0)	return ((n + shift) % nbrAlphabeticChar);	// Case positive shift
		else if (shift <= n)	return (n - shift);							// Case neg shift without roll back
		else					return (nbrAlphabeticChar - (shift-n));		// Case neg shift with roll back
	}

	/**=======================================================================
	 * Transform the hole content of the input file into an list of integer.
	 * The non alphabetic char are replaced by the input parameter "nonAlphabeticReplace", or
	 * ignored if the parameter is null.
	 ==========================================================================*/
	public static LinkedList<Integer> numerizeText(Scanner inputClearText, Integer nonAlphabeticReplace)
	{
		LinkedList<Integer> res = new LinkedList<Integer>();

		while(inputClearText.hasNext())
		{
			int i = alphabeticCharToNumerical((char) inputClearText.nextInt());
			if 		(i != -1)						res.add(i);
			else if (nonAlphabeticReplace != null)	res.add(new Integer(nonAlphabeticReplace));
		}
		return res;
	}

	/**=======================================================================
	 * Transform the hole content of the input text into an list of integer.
	 * The non alphabetic char are replaced by the input nonAlphabeticReplace, or
	 * ignored if the parameter is null
	 ==========================================================================*/
	public static LinkedList<Integer> numerizeText(String clearText, Integer nonAlphabeticReplace)
	{
		LinkedList<Integer> res = new LinkedList<Integer>();

		for (int i=0; i<clearText.length(); i++)
		{
			int clearChar = alphabeticCharToNumerical((char) clearText.charAt(i));
			if 		(clearChar != -1)				res.add(clearChar);
			else if (nonAlphabeticReplace != null)	res.add(new Integer(nonAlphabeticReplace));			
		}
		return res;
	}
}
