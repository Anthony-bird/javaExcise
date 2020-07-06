package com.kuang.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统内的加载对象
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的分类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器--》根加载器(C/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类的是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.kuang.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试jdk内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制
          //java.lang.String ->

        /*C:\Program Files\Java\jdk1.8.0_111\jre\lib\charsets.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\deploy.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\access-bridge-64.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\cldrdata.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\dnsns.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jaccess.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jfxrt.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\localedata.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\nashorn.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunec.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunjce_provider.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunmscapi.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunpkcs11.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\zipfs.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\javaws.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\jce.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfr.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfxswt.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\jsse.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\management-agent.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\plugin.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\resources.jar;
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\rt.jar;
        F:\Program Files (x86)\注解\out\production\注解;
        D:\Program Files (x86)\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar
         */
    }
}
