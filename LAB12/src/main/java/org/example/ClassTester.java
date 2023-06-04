package org.example;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassTester {
    Class clazz;
    ClassLoader loader;
    public ClassTester(String string) {
            //splitting the path
        string = string.replace("\\","/");
        String[] folders= string.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        int length= folders.length;
        boolean ok = false;
        for(int i=0;i<length;i++){
            if(ok){
                if(i==length-1){
                    folders[i] = folders[i].replace(".class","");
                    stringBuilder.append(folders[i]);
                }
                else{
                    stringBuilder.append(folders[i]);
                    stringBuilder.append(".");
                }
            }
            if(folders[i].compareTo("classes")==0){
                ok= true;
            }
        }
        string = stringBuilder.toString();
            try{
                clazz = Class.forName(string);
                loader = this.getClass().getClassLoader();
                loader.loadClass(string);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    public Method[] getClassMethods(){
        return clazz.getMethods();
    }

    public void invokingMethod(){
        try{
            Method method = clazz.getMethod("getNumber");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
