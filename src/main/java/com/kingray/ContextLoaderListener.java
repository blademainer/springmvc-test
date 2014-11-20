package com.kingray;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by xiongyingqi on 14-3-2.
 */
public class ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        Package[] pakages = Package.getPackages();
//        for (int i = 0; i < pakages.length; i++) {
//            Package pkg = pakages[i];
//			if(pkg.getName().startsWith("com.kingray")){
//                EntityHelper.print(pkg);
//            }
//			Set<Class<?>> classes = PackageUtil.getclass(pkg);
//			for (Class<?> class1 : classes) {
//				System.out.println(class1);
//			}
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
