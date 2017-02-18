package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarCode {
	static String encrypt(String clearText)
	{
//		String cipherText = clearText;
//		for(int i = 0; i < cipherText.size(); i++)
//		{
//			cipherText[i] = cipherText[i] + 4;
//		}
		byte[] bytes = clearText.getBytes();
		for(int i=0; i < clearText.length(); i++)
			bytes[i] = (byte) ((bytes[i] + 3) % 6);
		String cipherText = new String(bytes);
		return cipherText; 
	}
	
	static String decrypt(String cipherText)
	{
		
//		for(int i = 0; i < cipherText.size(); i++)
//		{
//			cipherText[i] = cipherText[i] - 4;
//		}
		byte[] bytes = cipherText.getBytes();
		for(int i=0; i < cipherText.length(); i++)
			bytes[i] = (byte) ('A' + (bytes[i] - 'A' - 3 + 26) % 26);
		String clearText = new String(bytes);
		return clearText;
	}
}
