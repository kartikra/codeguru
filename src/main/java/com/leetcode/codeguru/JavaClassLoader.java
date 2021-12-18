package com.leetcode.codeguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class JavaClassLoader extends ClassLoader {

    static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public void invokeClassMethod(String classBinName, String methodName){

        try {

            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class<?> loadedMyClass = classLoader.loadClass(classBinName);

            logger.info("Loaded class name: " + loadedMyClass.getName());

            // Create a new instance from the loaded class
            Constructor<?> constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            logger.info("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}