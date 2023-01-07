package org.zerock.springex.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

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
    
    private String[] types;

    private String keyword;

    private boolean finished;

    private LocalDate from;

    private LocalDate to;

    
    //limit구문에서 사용하는 건너뛰기(skip)의 수
    public int getSkip() {
    	return (page-1) * 10;
    }
    
    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if(finished){
            builder.append("&finished=on");
        }
        if(types != null && types.length > 0){
            for (int i = 0; i < types.length ; i++) {
                builder.append("&types=" + types[i]);
            }
        }
        if(keyword != null){
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(from != null){
            builder.append("&from=" + from.toString());
        }
        if(to != null){
            builder.append("&to=" + to.toString());
        }
        return builder.toString();
    }
    
    public boolean checkType(String type) {
    	if(types == null || types.length == 0) {
    		return false;
    	}
    	return Arrays.stream(types).anyMatch(t -> type.equals(t)); 
    	//return Arrays.stream(types).anyMatch(type::equals); 
    }
}