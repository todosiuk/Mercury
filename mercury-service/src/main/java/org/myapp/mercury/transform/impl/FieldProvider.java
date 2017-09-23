package org.myapp.mercury.transform.impl;

import java.util.List;

import org.myapp.mercury.app.infrastructure.util.ReflectionUtil;

/**
 * Base functionality of the field preparation
 * 
 * @author todosuk
 *
 */
public class FieldProvider {
	public List<String> getFieldNames(Class<?> source, Class<?> dest) {
		return ReflectionUtil.findSimilarFields(source, dest);
	}
}
