package com.yeg.servlet3.ext;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

/****
 * 需要该类在文件/META-INF/services/javax.servlet.ServletContainerInitializer配置一下
 * 
 * 
 * @HandlesTypes注解表示 MyWebConfig  可以处理的类，在 onStartup  方法中，可以通过 Set<Class<?>> c  获取得到。
 * 
 */
@HandlesTypes(value = SpringWebInitializer.class)
public class MyWebConfig implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

		System.out.println("************>MyWebConfig.ServletContainerInitializer");

//		
		for (Class<?> clazz : set) {
			SpringWebInitializer o = null;

			try {

				o = (SpringWebInitializer) clazz.newInstance();

//				把ServletContext传递给SpringWeb,以便进行扩展

				o.config(servletContext);


			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}