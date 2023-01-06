package org.zerock.springex.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoMapper todoMapper;
	//DTO -> VO로 변환하는거 의존성 주입
	private final ModelMapper modelMapper;
	
	@Override
	public void register(TodoDTO todoDTO) {
		log.info(modelMapper);
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		log.info(todoVO);
		todoMapper.insert(todoVO);
	}

}
