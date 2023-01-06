package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.springex.domain.TodoVO;

@Mapper
public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);
}
