package com.asmi.cglib;

import java.lang.reflect.Method;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;
import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.proxy.Mixin;
import net.sf.cglib.util.StringSwitcher;

public class CglibDemo {

	@Test(expected = IllegalStateException.class)
	public void testImmutableBean() throws Exception {
		SampleBean bean = new SampleBean("Hello world!");
		SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
		assertEquals("Hello world!", immutableBean.getValue());
		bean.setValue("Hello world, again!");
		assertEquals("Hello world, again!", immutableBean.getValue());
		immutableBean.setCode("Hello cglib!"); // Causes exception.
	}

	@Test
	public void testBeanGenerator() throws Exception {
		BeanGenerator beanGenerator = new BeanGenerator();
		beanGenerator.addProperty("value", String.class);
		beanGenerator.addProperty("code", String.class);

		Object myBean = beanGenerator.create();
		Method setter = myBean.getClass().getMethod("setValue", String.class);
		Method getter = myBean.getClass().getMethod("getValue");

		setter.invoke(myBean, "Hello cglib!");
		assertEquals("Hello cglib!", getter.invoke(myBean));

		myBean.getClass().getMethod("setCode", String.class).invoke(myBean, "code2");
		assertEquals("code2", myBean.getClass().getMethod("getCode").invoke(myBean));
	}

	@Test
	public void testBeanCopier() throws Exception {

		BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);

		SampleBean myBean = new SampleBean("Hello cglib!", "code2");
		OtherSampleBean otherBean = new OtherSampleBean();
		copier.copy(myBean, otherBean, null);
		assertEquals("Hello cglib!", otherBean.getValue());
	}

	@Test
	public void testBulkBean() throws Exception {
		BulkBean bulkBean = BulkBean.create(SampleBean.class, new String[] { "getValue", "getCode" },
				new String[] { "setValue", "setCode" }, new Class[] { String.class, String.class });
		SampleBean bean = new SampleBean("Hello world!", "code");
		assertEquals(2, bulkBean.getPropertyValues(bean).length);
		assertEquals("Hello world!", bulkBean.getPropertyValues(bean)[0]);
		bulkBean.setPropertyValues(bean, new Object[] { "Hello cglib!", "code2" });
		assertEquals("Hello cglib!", bean.getValue());
		assertEquals("code2", bean.getCode());
	}

	@Test
	public void testBeanMap() throws Exception {
		SampleBean bean = new SampleBean();
		BeanMap map = BeanMap.create(bean);
		bean.setValue("Hello cglib");
		assertEquals("Hello cglib", map.get("value"));
	}

	@Test
	public void testKeyFactory() throws Exception {
		SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(SampleKeyFactory.class);
		Object key = keyFactory.newInstance("foo", 42, "test");
		Map<Object, String> map = new HashMap<Object, String>();
		map.put(key, "Hello cglib!");
		assertEquals("Hello cglib!", map.get(keyFactory.newInstance("foo", 42, "test")));
	}
	
	@Test
	public void testMixin() throws Exception {
	  Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class, 
	      MixinInterface.class}, new Object[]{new Class1(), new Class2()});
	  MixinInterface mixinDelegate = (MixinInterface) mixin;
	  assertEquals("first", mixinDelegate.first());
	  assertEquals("second", mixinDelegate.second());
	}
	
	@Test
	public void testStringSwitcher() throws Exception {
	  String[] strings = new String[]{"one", "two"};
	  int[] values = new int[]{10, 20};
	  StringSwitcher stringSwitcher = StringSwitcher.create(strings, values, true);
	  assertEquals(10, stringSwitcher.intValue("one"));
	  assertEquals(20, stringSwitcher.intValue("two"));
	  assertEquals(-1, stringSwitcher.intValue("three"));
	}

	public interface Interface1 {
		String first();
	}

	public interface Interface2 {
		String second();
	}

	public class Class1 implements Interface1 {
		@Override
		public String first() {
			return "first";
		}
	}

	public class Class2 implements Interface2 {
		@Override
		public String second() {
			return "second";
		}
	}

	public interface SampleKeyFactory {
		Object newInstance(String first, int second, String third);
	}
	
	public interface MixinInterface extends Interface1, Interface2 { /* empty */ }


}
