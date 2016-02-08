package crypto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Scanner;








public class Test
{
// -------------------------------------------------
// Attributes
// -------------------------------------------------
	private static final String	clearTextDir		= "resource/clearText/";
	private static final String	cipheredTextDir		= "resource/cipheredText/";

// -------------------------------------------------
// Main method
// -------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		if (args.length < 3)
		{
			System.out.println("Usage: <clear text name> <cyphered text name> <key>");
			System.exit(0);
		}

		String clearFileName	= clearTextDir + args[0];
		String cipheredFileName	= cipheredTextDir + args[1];
		String key				= args[2];
		Scanner sc = null;
		Writer cipheredFile = null;

		try
		{
			sc				= new Scanner (new File(clearFileName));
			cipheredFile	= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cipheredFileName), "utf-8"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Usage: <clear text name> <cyphered text name> <key>");
			System.exit(0);
		}
		LinkedList<Integer> cipheredText = Vigenere.cipher(sc, key);
		for (Integer i:cipheredText)
		{
			cipheredFile.write(i);
		}
		sc.close();
		cipheredFile.close();
	}
}