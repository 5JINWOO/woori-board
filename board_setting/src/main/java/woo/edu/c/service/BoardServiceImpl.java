package woo.edu.c.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woo.edu.c.controller.HomeController;
import woo.edu.c.dao.BoardDao;
import woo.edu.c.vo.boardVo;
import woo.edu.c.vo.testVo;


@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource  /* java지원 한개의 파라미터인 빈 프로퍼티 setter메소드  @Resource("name="title") */
	private BoardDao boardDao;

	@Override
	public List<testVo> test() {
		return boardDao.test();
	}
	
	//게시글 목록
	@Override
	public List<boardVo> boardList() {
		return boardDao.boardList();
	}
	
	//게시글 등록
//	@Override
//	public int boardSave(boardVo vo) {
//		return boardDao.boardSave(vo);
//	}
	
	//게시글 상세화면
	@Override
	public boardVo boardDetail(int boardNo) {
		return boardDao.boardDetail(boardNo);
	}
	
//	//게시글 수정
//	@Override
//	public int boardUpdate(boardVo vo) {
//		return boardDao.boardUpdate(vo);
//	}
	
	//게시글 MERGE ==============!
	@Override
	public int boardMerge(boardVo vo) {
		return boardDao.boardMerge(vo);
	}
	
	//게시글 삭제
	@Override
	public int boardDelete(int boardNo) {
		return boardDao.boardDelete(boardNo);
	}
	
	//-------------------------------------------------
	//게시글 목록 Ajax
	public List<boardVo> ajaxList()	{		
		return boardDao.ajaxList();
	}
	
	//게시글 삭제 Ajax
	@Override
	public int ajaxDelete(int boardNo) {
		return boardDao.ajaxDelete(boardNo);
	}
	
	//게시글 등록
	@Override
	public int ajaxSave(boardVo vo) {
		return boardDao.ajaxSave(vo);
	}
	
	//게시글 상세화면
	@Override
	public boardVo ajaxDetail(int boardNo) {
		return boardDao.ajaxDetail(boardNo);
	}
	
}
