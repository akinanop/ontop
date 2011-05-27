/***
 * Copyright (c) 2008, Mariano Rodriguez-Muro. All rights reserved.
 *
 * The OBDA-API is licensed under the terms of the Lesser General Public License
 * v.3 (see OBDAAPI_LICENSE.txt for details). The components of this work
 * include:
 *
 * a) The OBDA-API developed by the author and licensed under the LGPL; and, b)
 * third-party components licensed under terms that may be different from those
 * of the LGPL. Information about such licenses can be found in the file named
 * OBDAAPI_3DPARTY-LICENSES.txt.
 */
package inf.unibz.it.obda.model;

import inf.unibz.it.obda.queryanswering.QueryControllerGroup;
import inf.unibz.it.obda.queryanswering.QueryControllerQuery;

import java.util.Iterator;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Controller for the query manager
 */
public class QueryController {

	private Vector<QueryControllerEntity>	collection		= null;
	private Vector<QueryControllerListener>	listeners		= null;
	private boolean							eventDisabled	= false;

	/** The logger */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public QueryController() {
		collection = new Vector<QueryControllerEntity>();
		listeners = new Vector<QueryControllerListener>();
	}

	public void addListener(QueryControllerListener listener) {
		if (listeners.contains(listener))
			return;
		listeners.add(listener);
	}

	public void removeListener(QueryControllerListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Creates a new group and adds it to the vector QueryControllerEntity
	 */
	public void createGroup(String group_name) {
		if (getElementPosition(group_name) == -1) {
			QueryControllerGroup group = new QueryControllerGroup(group_name);
			collection.add(group);
			fireElementAdded(group);
		}
		else {
			log.info("Group already exists!");
		}
	}

	/**
	 * Removes a group from the vector QueryControllerEntity
	 */
	public void removeGroup(String group_name) {
		for (Iterator<QueryControllerEntity> iterator = collection.iterator(); iterator.hasNext();) {
			Object temporal = iterator.next();
			if (!(temporal instanceof QueryControllerGroup))
				continue;
			QueryControllerGroup element = (QueryControllerGroup) temporal;
			if (element instanceof QueryControllerGroup) {
				QueryControllerGroup group = element;
				if (group.getID().equals(group_name)) {
					collection.remove(group);
					fireElementRemoved(group);
					return;
				}
			}
		}
	}

	/**
	 * Creates a new query and adds it to the vector QueryControllerEntity
	 */
	public QueryControllerQuery addQuery(String querystr, String id) {
		QueryControllerQuery query = null;
		if (getElementPosition(id) == -1) {
			query = new QueryControllerQuery(id);
			query.setQuery(querystr);
			collection.add(query);
			fireElementAdded(query);
		}
		else {
			log.warn("Query controler: Query already exists. ID: {}", id);
		}
		return query;
	}

	/**
	 * Removes all the elements from the vector QueryControllerEntity
	 */
	public void removeAllQueriesAndGroups() {
		Vector<QueryControllerEntity> elements = getElements();
		for (QueryControllerEntity treeElement : elements) {
			fireElementRemoved(treeElement);
		}
		collection.removeAllElements();
	}

	/**
	 * Creates a new query into a group and adds it to the vector
	 * QueryControllerEntity
	 */
	public QueryControllerQuery addQuery(String querystr, String id, String groupid) {
		QueryControllerQuery query = null;
		if (getElementPosition(id) == -1) {
			query = new QueryControllerQuery(id);
			query.setQuery(querystr);
			QueryControllerGroup group = getGroup(groupid);
			group.addQuery(query);
			fireElementAdded(query, group);
		}
		else {
			log.info("Query already exists!");
		}
		return query;
	}

	/**
	 * Removes a query from the vector QueryControllerEntity
	 */
	public void removeQuery(String id) {
		int index = getElementPosition(id);
		QueryControllerEntity element = collection.get(index);

		if (element instanceof QueryControllerQuery) {
			collection.remove(index);
			fireElementRemoved(element);
			return;
		} else {
			QueryControllerGroup group = (QueryControllerGroup) element;
			Vector<QueryControllerQuery> queries_ingroup = group.getQueries();
			for (QueryControllerQuery query : queries_ingroup) {
				if (query.getID().equals(id)) {
					fireElementRemoved(group.removeQuery(query.getID()), group);
					return;
				}
			}
		}
	}

	/**
	 * Searches a group and returns the object else returns null
	 */
	public QueryControllerGroup getGroup(String groupid) {
		int index = getElementPosition(groupid);
		if (index == -1)
			return null;
		QueryControllerGroup group = (QueryControllerGroup) collection.get(index);
		return group;
	}

	/***************************************************************************
	 * Returns the index of the element in the vector. If its is a query and the
	 * query is found inside a query group. The position of the group is
	 * returned instead.
	 *
	 * @param element_id
	 * @return
	 */
	public int getElementPosition(String element_id) {
		int index = -1;
		for (int i = 0; i < collection.size(); i++) {
			QueryControllerEntity element = collection.get(i);

			if (element instanceof QueryControllerQuery) {
				QueryControllerQuery query = (QueryControllerQuery) element;
				if (query.getID().equals(element_id)) {
					index = i;
					break;
				}
			}

			if (element instanceof QueryControllerGroup) {
				QueryControllerGroup group = (QueryControllerGroup) element;
				if (group.getID().equals(element_id)) {
					index = i;
					break;
				}
				/***************************************************************
				 * Searching inside the group.
				 */
				else {

					Vector<QueryControllerQuery> queries_ingroup = group.getQueries();
					for (QueryControllerQuery query : queries_ingroup) {
						if (query.getID().equals(element_id)) {
							index = i;
							break;
						}
					}
				}
			}
		}
		return index;
	}

	public Vector<QueryControllerEntity> getElements() {
		return this.collection;
	}

	/**
	 * Returns all the groups added
	 */
	public Vector<QueryControllerGroup> getGroups() {
		Vector<QueryControllerGroup> groups = new Vector<QueryControllerGroup>();
		for (QueryControllerEntity element : collection) {
			if (element instanceof QueryControllerGroup) {
				groups.add((QueryControllerGroup) element);
			}
		}
		return groups;
	}

	public void fireElementAdded(QueryControllerEntity element) {
		if (!eventDisabled) {
			for (QueryControllerListener listener : listeners) {
				listener.elementAdded(element);
			}
		}
	}

	public void fireElementAdded(QueryControllerQuery query, QueryControllerGroup group) {
		if (!eventDisabled) {
			for (QueryControllerListener listener : listeners) {
				listener.elementAdded(query, group);
			}
		}
	}

	public void fireElementRemoved(QueryControllerEntity element) {
		if (element instanceof QueryControllerGroup || element instanceof QueryControllerQuery) {
			if (!eventDisabled) {
				for (QueryControllerListener listener : listeners) {
					listener.elementRemoved(element);
				}
			}
		}
	}

	public void fireElementRemoved(QueryControllerQuery query, QueryControllerGroup group) {
		if (!eventDisabled) {
			for (QueryControllerListener listener : listeners) {
				listener.elementRemoved(query, group);
			}
		}
	}

	public void fireElementChanged(QueryControllerQuery query) {
		if (!eventDisabled) {
			for (QueryControllerListener listener : listeners) {
				listener.elementChanged(query);
			}
		}
	}

	public void fireElementChanged(QueryControllerQuery query, QueryControllerGroup group) {
		if (!eventDisabled) {
			for (QueryControllerListener listener : listeners) {
				listener.elementChanged(query, group);
			}
		}
	}

	public void setEventsDisabled(boolean value) {
		eventDisabled = value;
		return;
	}

	public boolean getEventsDisabled() {
		return eventDisabled;
	}
}
