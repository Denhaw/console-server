package org.denhaw.self.console.server.util;

import java.io.*;

public class SerializeUtil {

    private static byte[] getSerializedObjectByteArray(Object object){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes;
        try{
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            bytes=byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes;
    }
    public static String serializeObject(Object object){
        byte[] bytes=SerializeUtil.getSerializedObjectByteArray(object);
        StringBuilder builder=new StringBuilder();
        for(byte b:bytes){
            builder.append((char)b);
        }
        return builder.toString();
    }
    private static <T> T getObjectFromByteArray(byte[] bytes,Class<T> convertClass){
        Object object;
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
            object=objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return convertClass.cast(object);
    }
    public static <T> T getObject(String objectString,Class<T> convertClass){
        byte[] bytes=new byte[objectString.length()];
        for(int i=0;i<objectString.length();i++){
            bytes[i]=(byte) objectString.charAt(i);
        }
        return SerializeUtil.getObjectFromByteArray(bytes,convertClass);
    }
}
