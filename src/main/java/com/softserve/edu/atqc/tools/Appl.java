package com.softserve.edu.atqc.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Appl {
    public static void main(String[] args) throws Exception {
        BrowserRepository browserRepository = BrowserRepository.get();
        Class<?> c = browserRepository.getClass();
        List<String> methods = new ArrayList<String>();
        for (Method method : c.getDeclaredMethods()) {
        //for (Method method : c.getMethods()) {
            //if (method.getAnnotation(PostConstruct.class) != null) {
                System.out.println(method.getName());
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers)) {
                    methods.add(method.getName());
                }
            //}
        }
        System.out.println(methods);
        Method method = BrowserRepository.class.getDeclaredMethod("getChromeByTemporaryProfile", String.class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("parameter Name = "+ parameter.getName());
            System.out.println("parameter Type = "+ parameter.getType().getName());
        }
        /*
        System.out.println("indexOf=" + methods.indexOf("getChromeByTemporaryProfile"));
        System.out.println("LastindexOf=" + methods.lastIndexOf("getChromeByTemporaryProfile"));
        Method method = BrowserRepository.class.getMethod(methods.get(1));
        ABrowser firefox = (ABrowser)method.invoke(browserRepository);
        //ABrowser firefox = BrowserRepository.get().getChromeByTemporaryProfile();
        firefox.loadPage("http://www.google.com.ua");
        Thread.sleep(2000);
        firefox.loadPage("http://www.yahoo.com");
        */
    }
}