package com.huiji.api.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

/**
 * Created by yasenagat on 16/7/13 Time 下午11:47.
 */
public class ZipUtil {

    public static byte[] zip(byte[] object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DeflaterOutputStream zos = new DeflaterOutputStream(bos);
        zos.write(object);
        zos.close();
        return bos.toByteArray();
    }

    public static byte[] unzip(byte[] object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InflaterOutputStream zos = new InflaterOutputStream(bos);
        zos.write(object);
        zos.close();
        return bos.toByteArray();
    }
}
