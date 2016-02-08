package crypto;

import java.util.LinkedList;
import java.util.Scanner;








public class Vigenere
{
	/**=======================================================================
	 * Cipher the hole content of the input file using the Vigenere algorithm.
	 ==========================================================================*/
	public static LinkedList<Integer> cipher(Scanner inputClearText, String key)
	{
		LinkedList<Integer> clearText		= CryptoTools.numerizeText(inputClearText, null);
		LinkedList<Integer> keyNumerical	= CryptoTools.numerizeText(key, null);
		LinkedList<Integer> res				= new LinkedList<Integer>();

		int keyIndex = 0;
		int clearChar, cipheredChar, shift;
		for (int clearTextIndex=0; clearTextIndex<clearText.size(); clearTextIndex++)
		{
			shift			= keyNumerical.get(keyIndex);
			clearChar		= clearText.get(clearTextIndex);
			cipheredChar	= CryptoTools.shiftNumericalChar(clearChar, shift);
			keyIndex		= (keyIndex + 1) % key.length();
			res.add(cipheredChar);
		}
		return res;
	}
}