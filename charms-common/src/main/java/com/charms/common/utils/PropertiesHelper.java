package com.charms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesHelper {
    private final static Logger log = LoggerFactory.getLogger(PropertiesHelper.class);
    private  final Properties loadProps = new Properties();
    private final static String defaultCharsetName = "UTF-8";


    public PropertiesHelper(String fileName) {
        loadFromResources(fileName);
    }

    public boolean loadFromResources(String fileName){
        try{
            InputStream resourceAsStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(fileName);
            return loadStream(resourceAsStream,null);
        }catch (Exception e){
            e.printStackTrace();
            log.info("load resources error filename={} {}",fileName,e);
        }

        return false;
    }


    public boolean loadFile(String fileName,String encoding){
        try {
            FileInputStream in = new FileInputStream(fileName);
            return loadStream(in,encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean loadStream(InputStream stream, String encoding){
        if(encoding == null){
            encoding = defaultCharsetName;
        }
        try {
            Reader reader = new InputStreamReader(stream,encoding);
            return loadReader(reader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.info("loadStream error {}",e);
            return false;
        }
    }


    public synchronized boolean loadReader(Reader reader){
        try {
            loadProps.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public Properties getAllProperty(){

        return loadProps;
    }


    public String getString(String key){

        return loadProps.getProperty(key);
    }


    public String getString(String key,String defaultValue){

        return loadProps.getProperty(key, defaultValue);
    }


    public String [] getStrings(String key,String regex){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        return str.split(regex);
    }


    public Character getCharacter(String key){
        String str = loadProps.getProperty(key);
        if(str == null || str.length() != 1){
            return null;
        }
        return str.charAt(0);
    }


    public Boolean getBoolean(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        //这里比较"true"时，使用了不区分大小写的比较
        if("true".equalsIgnoreCase(str) || "1".equals(str)){
            return true;
        }
        return false;
    }


    public Integer getInteger(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Integer value = null;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Long getLong(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Long value = null;
        try {
            value = Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Short getShort(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Short value = null;
        try {
            value = Short.parseShort(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Byte getByte(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Byte value = null;
        try {
            value = Byte.parseByte(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Double getDouble(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Double value = null;
        try {
            value = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Float getFloat(String key){
        String str = loadProps.getProperty(key);
        if(str == null){
            return null;
        }
        Float value = null;
        try {
            value = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }


    public boolean containsKey(String key){
        return loadProps.containsKey(key);
    }


    public boolean containsValue(String value){
        return loadProps.containsValue(value);
    }


    public Set<Object> getKeySet(){
        return loadProps.keySet();
    }


    public Set<Map.Entry<Object,Object>> getEntrySet(){
        return loadProps.entrySet();
    }


    public void setValue(String key,String value){
        loadProps.setProperty(key, value);
    }


    public boolean writeToFile(String filename){
        return writeToFile(filename,System.getProperty("file.encoding"));
    }



    public boolean writeToFile(String filename,String encoding){
        //检查该文件是否存在，如果没有则创建
        File file = new File(filename);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        //创建输出流
        try {
            FileOutputStream stream = new FileOutputStream(file);
            return writeToStream(stream,encoding);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean writeToStream(OutputStream stream,String encoding){
        try {
            OutputStreamWriter writer = new OutputStreamWriter(stream,encoding);
            return writeToWriter(writer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean writeToStream(OutputStream stream){
        return writeToStream(stream,System.getProperty("file.encoding"));
    }


    public boolean writeToWriter(Writer writer){
        try {
            loadProps.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
