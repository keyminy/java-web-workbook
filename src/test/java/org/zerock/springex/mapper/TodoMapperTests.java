package org.zerock.springex.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TodoMapperTests {
	
	@Autowired(required=false)
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
    @Test
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트 ")
                .dueDate(LocalDate.of(2022,10,10))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);

    }
    
    @Test
    public void testSelectList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);


        voList.forEach(vo -> log.info(vo));


    }
}
