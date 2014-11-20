package com.kingray;
import java.util.Set;

import org.junit.Test;
import com.xiongyingqi.util.PackageUtil;



/**
 * YIXUN_1.5_WEB
 */

/**
 * @author xiongyingqi
 * @version 2014年3月2日 下午6:46:29
 */

public class TestPackage {
	@Test
	public void testPackages(){
		Package[] pakages = Package.getPackages();
		for (int i = 0; i < pakages.length; i++) {
			Package pkg = pakages[i];
//			System.out.println(pkg);
			if(pkg.getName().startsWith("com")){
				System.out.println(pkg);
			}
//			Set<Class<?>> classes = PackageUtil.getclass(pkg);
//			for (Class<?> class1 : classes) {
//				System.out.println(class1);
//			}
		}
	}
}
