package com.wwwhackcom.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.wwwhackcom.common.DynamicClassLoader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Generated;

@RestController
public class DebugController {

    @RequestMapping(value = "/debug")
    public String excute(@RequestParam(value = "method_name",required = false) String method, @RequestParam(value = "method_params",required = false) String params) throws ClassNotFoundException, IllegalAccessException, IOException, InstantiationException, InvocationTargetException {
        String projectDir = System.getProperty("user.dir");
        String classpath = System.getProperty("java.class.path");
        String testFilePath = projectDir + "/debug";
        String testFileName = "Debug";
        if (!new File(testFilePath + "/" + testFileName + ".java").exists()) {
            testFilePath = projectDir + "/src/main/resources/debug";
            testFileName = "Debug";
        }
        DynamicClassLoader loader = new DynamicClassLoader();
        loader.complier(testFilePath, classpath);
        Class<?> clazz = loader.loadClass(testFilePath, testFileName);
        if (clazz == null)
            return "calss not found in path .";
        if(StringUtils.isEmpty(method))
            method = "defaultMethod";
        if(StringUtils.isEmpty(params)){
            Method methodc = null;
            try {
                methodc = clazz.getMethod(method, null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return "["+method+"] method not found .";
            }
            return methodc.invoke(clazz.newInstance(),null)+"";
        }else{
            Method methodc = null;
            try {
                methodc = clazz.getMethod(method, String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return "["+method+"] method not found .";
            }
            return methodc.invoke(clazz.newInstance(),params)+"";
        }
    }

}
