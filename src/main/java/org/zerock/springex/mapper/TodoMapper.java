package org.zerock.springex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

@Mapper
public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);
	
	/* 페이징 관련 */
	List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
	
	int getCount(PageRequestDTO pageRequestDTO);
}
