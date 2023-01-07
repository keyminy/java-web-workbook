package org.zerock.springex.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1; //현재 페이지


    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10; //한 페이지당 보여줄 데이터 수
    
    private String link;
    
    //limit구문에서 사용하는 건너뛰기(skip)의 수
    public int getSkip() {
    	return (page-1) * 10;
    }
    
    public String getLink() {
    	if(link == null) {
    		StringBuilder builder = new StringBuilder();
    		builder.append("page=" + this.page);
    		builder.append("&size=" + this.size);
    		link = builder.toString();
    	}
    	return link;
    }
}