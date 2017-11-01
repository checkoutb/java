package com.wb.service;

import com.wb.dao.Dao;

/**
 */
public class BaseServiceImpl implements BaseService {

	private Dao dao;
	
	@Override
	public Object findByClassAndId(Class<?> clazz, int id) {
		/*Object result;
		if(null == clazz)
		{
			return null;
		}
		else
		{
			result = dao.findByClassAndId(clazz, id);
		}
		return result;*/
		
		//the following is above's decompile
	    /*if (clazz == null)		//111
	    {
	      return null;
	    }

	    Object result = this.dao.findByClassAndId(clazz, id);

	    return result;*/
		if(clazz == null || id <= 0)
		{
			return null;
		}
		else
		{
//			Object result = this.dao.findByClassAndId(clazz, id);
			/*if(result == null)
			{
				return null;
			}
			else
			{
				return result;
			}*/
			return this.dao.findByClassAndId(clazz, id);
		}
	}

	/**
	 * @return the dao
	 */
	public Dao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
