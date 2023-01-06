package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {
	
	@Qualifier("event")
	private final SampleDAO sampleDAO;

}
