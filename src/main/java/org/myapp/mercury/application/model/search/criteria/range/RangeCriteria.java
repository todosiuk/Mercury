package org.myapp.mercury.application.model.search.criteria.range;

import org.myapp.mercury.application.infrastructure.exception.flow.InvalidParameterException;

/**
 * Pagination parameters for data retrieval operations
 * 
 * @author todosuk
 *
 */
public class RangeCriteria {

	/**
	 * page index (base page=0)
	 */
	private final int page;

	/**
	 * Number of element per page
	 */
	private final int rowCount;

	public RangeCriteria(final int page, final int rowCount) {
		if (page < 0) {
			throw new InvalidParameterException("Incorrect page index:" + page);
		}
		if (rowCount < 0) {
			throw new InvalidParameterException("Incorrect row count:" + rowCount);
		}
		this.page = page;
		this.rowCount = rowCount;
	}

	public int getPage() {
		return page;
	}

	public int getRowCount() {
		return rowCount;
	}

}
