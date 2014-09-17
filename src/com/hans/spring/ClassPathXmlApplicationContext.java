package com.hans.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> map = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sax = new SAXBuilder();
		Document doc = sax.build(ClassPathXmlApplicationContext.class
				.getClassLoader().getResourceAsStream("beans.xml"));
		Element element = doc.detachRootElement();
		List<Element> list = element.getChildren("bean");
		for (Element ele : list) {
			String className = ele.getAttributeValue("class");
			String id = ele.getAttributeValue("id");
			Object o = Class.forName(className).newInstance();
			map.put(id, o);
		}
		for (Element ele : list) {
			List<Element> listProperty = ele.getChildren("property");
			String id = ele.getAttributeValue("id");
			Object o = map.get(id);
			for (Element elementProperty : listProperty) {
				String iocClassName = elementProperty.getAttributeValue("bean");

				String methodName = "set"
						+ iocClassName.substring(0, 1).toUpperCase()
						+ iocClassName.substring(1);
				System.out.println(methodName);
				Method method = o.getClass().getMethod(
						methodName,
						map.get(elementProperty.getAttributeValue("bean"))
								.getClass().getInterfaces()[0]);
				method.invoke(o,
						map.get(elementProperty.getAttributeValue("bean")));
			}
		}

	}

	@Override
	public Object getBean(String id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

}
