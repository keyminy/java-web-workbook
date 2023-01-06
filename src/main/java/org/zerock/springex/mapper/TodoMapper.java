package org.zerock.springex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.springex.domain.TodoVO;

@Mapper
public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);
}
