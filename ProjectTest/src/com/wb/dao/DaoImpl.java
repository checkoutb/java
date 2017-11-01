package com.wb.dao;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * hibernate 5
 */
public class DaoImpl extends HibernateDaoSupport implements Dao {

	/* (non-Javadoc)
	 * @see com.wb.dao.Dao#findByClassAndId(java.lang.Class, int)
	 */
	@Override
	public Object findByClassAndId(Class<?> clazz, int id) {
//		if(null == clazz)		//
//		{
//			return null;
//		}
//		
		Object result;
		result = getHibernateTemplate().get(clazz, id);		//不一定要Long型。
//		if(null == result)
//		{
//			throw new ObjectRetrievalFailureException(clazz, new Long(id));
//		}
		return result;
	}

}
