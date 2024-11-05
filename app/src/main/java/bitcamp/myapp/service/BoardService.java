package bitcamp.myapp.service;

import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;

import java.util.List;

public interface BoardService {

  void add(Board board) throws Exception;

  List<Board> list(int pageNo, int pageSize) throws Exception; //page넘버랑 page 사이즈를 달라. 업무 로직 관점에서 본다. row 넘버 x

  Board get(int boardNo) throws Exception;

  void increaseViewCount(int boardNo) throws Exception;

  int countAll() throws Exception; //controller에서 페이징 할때 그 정보를 jsp도 알아야 하기 때문에 넣어주는 것

  boolean update(Board board) throws Exception;

  void delete(int boardNo) throws Exception;

  AttachedFile getAttachedFile(int fileNo) throws Exception;

  boolean deleteAttachedFile(int fileNo) throws Exception;

}

