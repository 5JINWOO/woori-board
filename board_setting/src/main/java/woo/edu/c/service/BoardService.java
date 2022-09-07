package woo.edu.c.service;

import java.util.List;

import woo.edu.c.vo.boardVo;
import woo.edu.c.vo.testVo;

public interface BoardService {

	List<testVo> test();
	
	
	//게시글 목록
	List<boardVo> boardList();
	
	//게시글 등록
//	int boardSave(boardVo vo);
	
	//게시글 상세화면
	boardVo boardDetail(int boardNo);
	
	//게시글 수정
//	int boardUpdate(boardVo vo);
	
	//게시글 MERGE ===========!
	int boardMerge(boardVo vo);
	
	//게시글 삭제
	int boardDelete(int boardNo);
	
	//--------------------------------------------
	//게시글 목록 Ajax
	List<boardVo> ajaxList();
	
	//게시글 삭제 Ajax
	int ajaxDelete(int boardNo);
	
	//게시글 등록 Ajax
	int ajaxSave(boardVo vo);
	
	//게시글 상세화면  Ajax
	boardVo ajaxDetail(int boardNo);
	

}
