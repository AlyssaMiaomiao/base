package dao.inf;

import java.util.List;



public interface BaseDao {
	
	
	public int insert(Object data) throws Exception;
	
	
	public List<Object> findAll () throws Exception;
	
	
	public Object findOne(Long i) throws Exception;
	
	public int delete(Long id) throws Exception;
	
	public int update(Object object ) throws Exception;
	
	public List<Object> findByCondition (BaseQueryModel queryModel)throws Exception;
	
	public Long findLastAddId()throws Exception;
		
}
