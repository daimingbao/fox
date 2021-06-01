package cn.supfox.webservices;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/*
 * DES加解密工具类
 */
public class DESHelper  {
	
	/**
	  *   右补位，左对齐
	 * 
	 * @param oriStr 原字符串
	 * @param len    目标字符串长度
	 * @param pad    补位字符
	 * @return 目标字符串
	 */
	public static String padRight(String oriStr, int len, char pad) {
		StringBuffer result = new StringBuffer(oriStr);
		int strlen = oriStr.length();
		if (strlen < len) {
			for (int i = 0; i < len - strlen; i++) {
				result.append(pad);
			}
		}
		return result.substring(0, len);
	}
	
	/**
    * DES加密解密
    * @param data 原始字符串
    * @param secretKey 解密密钥
    * @return 加密字符串
	 * @throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, GeneralSecurityException 
    * @throws Exception
    */
   public static String encryptDES(byte[] data, String secretKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, GeneralSecurityException  {
       Cipher cipher = null;
       try {
           cipher = Cipher.getInstance("DES/ECB/NoPadding");
           cipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey));
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
           throw e;
       } catch (NoSuchPaddingException e) {
           e.printStackTrace();
           throw e;
       } catch (InvalidKeyException e) {
           e.printStackTrace();
           throw e;
       } catch (InvalidKeySpecException e) {
           e.printStackTrace();
           throw e;
       }
       int len= data.length;
       if(len%8!=0){
    	   len = len+(8-len%8);
       }
       byte[] fixData = new byte[len];
       for(int i = 0; i < data.length; i ++) {
    	   fixData[i] = data[i];
       }
       try {
    	   
           byte[] buf = cipher.doFinal(fixData);
           
           return Base64.getEncoder().encodeToString(buf);

       } catch(IllegalBlockSizeException e) {
           e.printStackTrace();
           throw e;
       } catch (GeneralSecurityException e) {
			e.printStackTrace();
	        throw e;
       }
   }
	
	/**
    * DES解密
    * @param secretData 密码字符串
    * @param secretKey 解密密钥
    * @return 原始字符串
	 * @throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, GeneralSecurityException, UnsupportedEncodingException 
    * @throws Exception
    */
   public static String decryptDES(byte[] secretData, String secretKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, GeneralSecurityException, UnsupportedEncodingException {
       Cipher cipher = null;
       try {
           cipher = Cipher.getInstance("DES/ECB/NoPadding");
           cipher.init(Cipher.DECRYPT_MODE, generateKey(secretKey));
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
           throw e;
       } catch (NoSuchPaddingException e) {
           e.printStackTrace();
           throw e;
       } catch (InvalidKeyException e) {
           e.printStackTrace();
           throw e;
       } catch (InvalidKeySpecException e) {
           e.printStackTrace();
           throw e;
       }
       try {
    	   
           byte[] buf = cipher.doFinal(secretData);

           return new String(buf,"utf-8");

       } catch(IllegalBlockSizeException e) {
           e.printStackTrace();
           throw e;
       } catch (GeneralSecurityException e) {
			e.printStackTrace();
	        throw e;
       } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
	        throw e;
		}
   }
   
   public static byte[] hexStr2Bytes(String src){  
       /*对输入值进行规范化整理*/  
       src = src.trim().replace(" ", "").toUpperCase(Locale.US);  
       //处理值初始化  
       int m=0,n=0;  
       int iLen=src.length()/2; //计算长度  
       byte[] ret = new byte[iLen]; //分配存储空间  

       for (int i = 0; i < iLen; i++){  
           m=i*2+1;  
           n=m+1;  
           ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);  
       }  
       return ret;  
   }
   
   public static String byteArrayToHexString(byte b[]){
       StringBuffer resultSb = new StringBuffer();
       for(int i = 0; i < b.length; i++){
           resultSb.append(byteToHexString(b[i]));
       }
       return resultSb.toString();
   }
   
   private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
   public static String byteToHexString(byte b){
       int n = b;
       if(n < 0){
           n += 256;
       }
       int d1 = n / 16;
       int d2 = n % 16;
       return hexDigIts[d1] + hexDigIts[d2];
   }

   
   private static final String DES_ALGORITHM = "DES";
   /**
    * 获得秘密密钥
    * 
    * @param secretKey
    * @return
    * @throws NoSuchAlgorithmException
    * @throws InvalidKeySpecException
    * @throws InvalidKeyException
    */
   private static SecretKey generateKey(String secretKey)
           throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
       DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
       keyFactory.generateSecret(keySpec);
       return keyFactory.generateSecret(keySpec);
   }
   
   public static String MD5Encode(String origin, String charsetname){
       String resultString = null;
       try{
           resultString = new String(origin);
           MessageDigest md = MessageDigest.getInstance("MD5");
           if(null == charsetname || "".equals(charsetname)){
               resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
           }else{
               resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
           }
       }catch (Exception e){
       }
       return resultString;
   }
   
   public static void main(String[] args) throws Exception {
//   	String captcha = "0694";
//   	String key = padRight(captcha, 8, '0');
//   	String desAccount = "6adYE0zrD9T5QhnMdKVjoA==";
//   	byte[] base64DecodeAccount = Base64.getDecoder().decode(desAccount);
//   	String desDecodeAccount = decryptDES(base64DecodeAccount, key).trim();
//   	System.out.println(desDecodeAccount);
//   	
//   	String desKey = "gb.token";
//   	String token = "zFmKNgt05kINqvm5wKjvsRKlkososHaC9AJMqgxa2Ns=";
//   	byte[] base64token = Base64.getDecoder().decode(token);
//   	String desDecodetoken = decryptDES(base64token, desKey).trim();
//   	System.out.println(desDecodetoken);
//   	
//   	System.out.println(encryptDES("testItf".getBytes(), "15912719"));
   	
   	System.out.println(
   			DESHelper.decryptDES(Base64.getDecoder().decode("iEpaBUhQHxJpPmJYp3c45w=="),
					"1602486309".substring(0, 8))
   			);
   	System.out.println(
   			DESHelper.decryptDES(Base64.getDecoder().decode("r0eQbMMxUKk="),
					"16093976".substring(0, 8))
   			);
   }
  
 
}
