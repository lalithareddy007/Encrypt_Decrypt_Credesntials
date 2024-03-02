package com.tool.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DecryptFileTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		File encrypFile = new File("/Users/SamaS/Nmp_LMS_Credesntials/credentials.encrypted");
		File decryptedFile = new File("/Users/SamaS/Nmp_LMS_Credesntials/credentials.decrypted");
		
		File f = new File("/Users/SamaS/Nmp_LMS_Credesntials/encodedKey");
		FileInputStream fos = new FileInputStream(f);
		byte[] key = fos.readAllBytes();
		fos.close();
		
		SecretKey key1= new SecretKeySpec(key, "AES");
		try {
			CryptoUtils.decrypt(key1, encrypFile, decryptedFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
