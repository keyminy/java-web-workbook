package org.zerock.springex.service;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<TodoDTO> getAll() {
		//Service영역에서 vo -> DTO변환 작업
		List<TodoDTO> dtoList = todoMapper.selectAll().stream()
											.map(vo -> modelMapper.map(vo, TodoDTO.class))
											.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public TodoDTO getOne(Long tno) {
		TodoVO todoVO = todoMapper.selectOne(tno);
		TodoDTO todoDto = modelMapper.map(todoVO, TodoDTO.class);
		return todoDto;
	}

	@Override
	public void remove(Long tno) {
		todoMapper.delete(tno);
	}

	@Override
	public void modify(TodoDTO todoDTO) {
		//파라미터의 DTO -> VO로 변환
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		todoMapper.update(todoVO);
	}

}
