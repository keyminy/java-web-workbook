package org.zerock.springex.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TodoServiceTests {
	
    @Autowired
    private TodoService todoService;

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        log.info(responseDTO);

        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }
}
