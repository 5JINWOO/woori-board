package woo.edu.c.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import woo.edu.c.controller.HomeController;
import woo.edu.c.vo.boardVo;
import woo.edu.c.vo.testVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// mybatis
	@Inject //필드 생성자 setter
	private SqlSession sql;
	
	private static String namespace = "boardMapper";

	@Override
	public List<testVo> test() {
		return sql.selectList(namespace + ".test"); //id에 대한 select문을 실행한 후 레코드를 List로 반환
	}
	
	//board 글목록
	@Override
	public List<boardVo> boardList() {
		return sql.selectList(namespace + ".boardList");
	}
	
	//board 글등록
//	@Override
//	public int boardSave(boardVo vo) {
//		return sql.insert(namespace + ".boardSave", vo);
//	}
	
	//board MERGE ========!!!1
	@Override
	public int boardMerge(boardVo vo) {
		return sql.insert(namespace + ".boardMerge", vo);
	}
	
	//board 상세화면
	@Override
	public boardVo boardDetail(int boardNo) {
		return sql.selectOne(namespace + ".boardDetail", boardNo);
	}
	
	//board 글 수정
//	@Override
//	public int boardUpdate(boardVo vo) {
//		return sql.update(namespace + ".boardUpdate", vo);
//	}
	
	//board 글삭제
	@Override
	public int boardDelete(int boardNo) {
		return sql.delete(namespace + ".boardDelete", boardNo);
	}
	//-----------------------------------------------------
	
	//board 글목록 Ajax
	@Override
	public List<boardVo> ajaxList() {
		return sql.selectList(namespace + ".ajaxList");
	}
	
	//board 글삭제 Ajax
	@Override
	public int ajaxDelete(int boardNo) {
		return sql.delete(namespace + ".ajaxDelete", boardNo);
	}
	
	//board 글등록
	@Override
	public int ajaxSave(boardVo vo) {
		return sql.insert(namespace + ".ajaxSave", vo);
	}
	
	//board 상세화면
	@Override
	public boardVo ajaxDetail(int boardNo) {
		return sql.selectOne(namespace + ".ajaxDetail", boardNo);
	}
	
}
