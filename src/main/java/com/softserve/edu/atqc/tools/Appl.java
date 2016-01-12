package com.softserve.edu.atqc.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Appl {
    public static void main(String[] args) throws Exception {
        BrowserRepository browserRepository = BrowserRepository.get();
        Class<?> c = browserRepository.getClass();
        List<String> methods = new ArrayList<String>();
        for (Method method : c.getDeclaredMethods()) {
            //if (method.getAnnotation(PostConstruct.class) != null) {
                System.out.println(method.getName());
                methods.add(method.getName());
            //}
        }
        System.out.println(methods);
        Method method = BrowserRepository.class.getMethod(methods.get(2));
        ABrowser firefox = (ABrowser)method.invoke(browserRepository);
        firefox.loadPage("http://www.google.com.ua");
        Thread.sleep(2000);
        firefox.loadPage("http://www.yahoo.com");
    }
}