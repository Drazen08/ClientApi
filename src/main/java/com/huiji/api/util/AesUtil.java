package com.huiji.api.util;

import com.huiji.api.exception.ParseException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yasenagat on 16/7/13 Time 下午11:40.
 */
public class AesUtil {

    public static byte[] decrypt(byte[] byteMi, byte[] byteKey) throws ParseException {
        return aes(byteMi, byteKey, Cipher.DECRYPT_MODE);
    }

    public static byte[] encrypt(byte[] byteMi, byte[] byteKey) throws ParseException {
        return aes(byteMi, byteKey, Cipher.ENCRYPT_MODE);
    }

    private static byte[] aes(byte[] byteData, byte[] byteKey, int opmode) throws ParseException {
        Cipher cipher = null;
        try {
            SecretKeySpec aesKey = new SecretKeySpec(byteKey, "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(opmode, aesKey);
            return cipher.doFinal(byteData);
        } catch (RuntimeException e) {
            throw e;
        }catch (Exception e) {
            throw new ParseException();
        } finally {
            cipher = null;
        }
    }
}
