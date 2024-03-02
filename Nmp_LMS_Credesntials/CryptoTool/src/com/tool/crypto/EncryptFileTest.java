package com.tool.crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptFileTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		//Generate Key to use for encryption
		Key key1 = CryptoUtils.getKeyFromKeyGenerator( "AES", 128);
		//Location of original Credentials file obtained from Google
		File inputfile = new File("/Users/Demo/Demo_Credesntials/credentials.json");
		
		//Location of encrypted file
		File encrypFile = new File("/Users/Demo/Demo_Credesntials/credentials.encrypted");
		
		//Store the encoded key in a file to use for decryption
		byte[] encodedKey = key1.getEncoded();
		File f = new File("/Users/Demo/Demo_Credesntials/encodedKey");
		if(!f.exists()){
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(encodedKey);
		fos.close();
		try {
			CryptoUtils.encrypt(key1, inputfile, encrypFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
