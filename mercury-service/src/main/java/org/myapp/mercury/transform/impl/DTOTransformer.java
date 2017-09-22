package org.myapp.mercury.transform.impl;

import org.myapp.mercury.app.infrastructure.util.Checks;
import org.myapp.mercury.app.infrastructure.util.ReflectionUtil;
import org.myapp.mercury.app.model.entity.base.AbstractEntity;
import org.myapp.mercury.app.rest.dto.base.BaseDTO;
import org.myapp.mercury.transform.Transformer;

/**
 * Default transformation engine that uses reflection to transform objects
 * 
 * @author todosuk
 *
 */
public class DTOTransformer implements Transformer {

	@Override
	public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(final T entity, final Class<P> clz) {
		checkParams(entity, clz);

		P dto = ReflectionUtil.createInstance(clz);
		// Now just copy all the similar fields
		ReflectionUtil.copyFields(entity, dto, ReflectionUtil.findSimilarFields(entity.getClass(), clz));
		dto.transform(entity);

		return dto;
	}

	private void checkParams(final Object param, final Class<?> clz) {
		Checks.checkParameter(param != null, "Source transformation object is not initialized");
		Checks.checkParameter(clz != null, "No class is defined for transformation");
	}

	@Override
	public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(final P dto, final Class<T> clz) {
		checkParams(dto, clz);

		T entity = ReflectionUtil.createInstance(clz);

		ReflectionUtil.copyFields(dto, entity, ReflectionUtil.findSimilarFields(dto.getClass(), clz));
		dto.untransform(entity);

		return entity;
	}
}
