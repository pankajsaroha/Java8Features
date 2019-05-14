/*package org.java.practice;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;

import weblogic.utils.encoders.BASE64Decoder;

//import com.sun.net.ssl.internal.www.protocol.https.BASE64Encoder;

public class CryptUtil {
	
	private static final CryptUtil instance = new CryptUtil();

	private static final String DES = "DES";
	
	private CryptUtil() {

	}
	
	public static void main(String args[]) {
		System.out.println("Pwd -"+decryptAES("A24708D65F757CDAFC7D043289D605F6", "cisco123"));
	}

	public static CryptUtil getInstance() {
		return instance;
	}

//	@Deprecated
//    public static String encryptAES(String data, String key) {
//        try {
//			byte[] bt = encrypt(data.getBytes(), key.getBytes());
//			String strs = new BASE64Encoder().encode(bt);
//			return strs;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return data;
//    }
// 
	@Deprecated
    public static String decryptAES(String data, String key)  {
        if (data == null)
            return null;
        try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] buf = decoder.decodeBuffer(data);
			byte[] bt = decrypt(buf,key.getBytes());
			return new String(bt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
    }
 
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
 
        DESKeySpec dks = new DESKeySpec(key);
 
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        Cipher cipher = Cipher.getInstance(DES);
 
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
 
        DESKeySpec dks = new DESKeySpec(key);
 
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        Cipher cipher = Cipher.getInstance(DES);
 
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }

    public static String getMD5Sign(String content){
    	 try { 
    		 MessageDigest md = MessageDigest.getInstance("MD5"); 
    		 md.reset();
             return new String(Hex.encodeHex(md.digest(content.getBytes())));  
         } catch (NoSuchAlgorithmException e) { 
             e.printStackTrace(); 
         }
		return content; 	

    }
//	public static void main(String[] args)  {
//		CryptUtil crypt = CryptUtil.getInstance();		
//		String content = "Czl.2345";
//		System.out.println(crypt.encryptAES(content, Constants.CRYPT_PWD_KEY));
//		String dcontent = crypt.encryptAES(content, Constants.CRYPT_PWD_KEY);
//		System.out.println(crypt.decryptAES(dcontent, Constants.CRYPT_PWD_KEY));
//		
//
//	}
	
}*/