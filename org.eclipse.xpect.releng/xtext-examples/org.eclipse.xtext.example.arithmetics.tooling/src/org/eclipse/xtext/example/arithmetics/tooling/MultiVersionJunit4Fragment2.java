package org.eclipse.xtext.example.arithmetics.tooling;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.xtext.xtext.generator.junit.Junit4Fragment2;

/**
 * patched fragment that works with older and new xtext versions
 *
 */
public class MultiVersionJunit4Fragment2 extends Junit4Fragment2 {
	
	public MultiVersionJunit4Fragment2() {
		super();
		try {
			Method setUseDeprecatedClasses = Junit4Fragment2.class.getMethod("setUseDeprecatedClasses", boolean.class);
			setUseDeprecatedClasses.invoke(this, true);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// ok, we are on old xtext version
		}
	}

}
