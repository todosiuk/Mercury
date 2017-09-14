package org.myapp.mercury.app.model.search.criteria.range;

import org.myapp.mercury.app.infrastructure.util.Checks;

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
		Checks.checkParameter(page >= 0, "Incorrect page index:" + page);
		Checks.checkParameter(rowCount >= 0, "Incorrect row count:" + rowCount);

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
