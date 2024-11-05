package bitcamp.myapp.vo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Data // 기본 생성자 + Getter및 Setter 포함 다 적용
//@Builder //board builder 객체 자동 생성
//@AllArgsConstructor // 전체 값을 다 받는 애노테이션
//@RequiredArgsConstructor // final로 선언한 객체는 반드시 값을 넣어야 



  public class Board implements Serializable {

    private static final long serialVersionUID = 1L;
    // private String test; //테스트용 final로 선언된 객체는 반드시 값을 넣어야한다.
    private int no;
    private String title;
    private String content;
    private User writer;
    private Date createdDate;
    private int viewCount;
    private List<AttachedFile> attachedFiles;
  }
