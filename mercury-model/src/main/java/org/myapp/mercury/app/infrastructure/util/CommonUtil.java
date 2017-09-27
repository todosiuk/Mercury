package org.myapp.mercury.app.infrastructure.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains utility functions of the general purpose
 * 
 * @author todosuk
 *
 */

public class CommonUtil {
	private CommonUtil() {

	}

	/**
	 * Retutns not-null unmodifiable copy of the source set
	 * 
	 * @param source
	 * @return
	 */
	public static <T> Set<T> getSafeSet(Set<T> source) {
		return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
	}

	/**
	 * Returns not-null unmodifiable copy of the source list
	 * 
	 * @param source
	 * @return
	 */
	public static <T> List<T> getSafeList(List<T> source) {
		return Collections.unmodifiableList(Optional.ofNullable(source).orElse(Collections.emptyList()));
	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}

	/**
	 * Dynamically converts param into string representation using all object state
	 * 
	 * @param param
	 * @return
	 */
	public static String toString(Object param) {
		return ReflectionToStringBuilder.toString(param, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
