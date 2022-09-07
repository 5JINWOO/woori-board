package woo.edu.c.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import woo.edu.c.service.BoardService;
import woo.edu.c.vo.boardVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService boardService;

	//board home
	@RequestMapping(value = "/board/home", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("/board/home");
		return "home";
	}

	// board 목록
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		logger.info("/board/list");
		List<boardVo> boardList = boardService.boardList();
		System.out.println("boardList===" + boardList);
		model.addAttribute("boardList", boardList); // Model addAttribute(변수명, Object value) model에 담은 데이터를 json화
		return "/board/boardlist";
	}
	

	// board 등록화면
	@RequestMapping(value = "/board/saveView", method = RequestMethod.GET)
	public String saveView(Model model) throws Exception {
		logger.info("/board/saveView");
		return "/board/boardsave";
	}
	
	//board Merge (등록 & 수정) =======!
	@RequestMapping(value = "/board/boardMerge", method = RequestMethod.POST)
	public String boardMerge(boardVo vo) throws Exception {
		logger.info("/board/merge");
		System.out.println("vo===="+vo);
		int result = boardService.boardMerge(vo) ;
		if(result == 1) {
			return "redirect:/board/boardList";
		}else {
			
			return "redirect:/board/boardMerge";
		}		
	}
	

//	// board 글 등록하기
//	@RequestMapping(value = "/board/boardSave", method = RequestMethod.POST)
//	public String boardSave(boardVo vo) throws Exception {
//		logger.info("/board/save");
//		System.out.println("vo===="+vo);
//		int result = boardService.boardSave(vo) ;
//		if(result == 1) {
//			return "redirect:/board/boardList";
//		}else {
//			
//			return "redirect:/board/boardSave";
//		}		
//	}
//	
//	// board 글수정하기
//	 @RequestMapping(value = "/board/boardUpdate", method = RequestMethod.POST)
//	 public String boardUpdate(boardVo vo) throws Exception {
//	    logger.info("/board/update");	  
//	  		if(boardService.boardUpdate(vo) == 1) { 
//	  	  		return "redirect:/board/boardList";
//	  	  	}else {	  
//	  	  		return "redirect:/board/updateView"; 
//	  	  	} 
//	 } 
	 
	// board 수정화면
	@RequestMapping(value = "/board/updateView", method = RequestMethod.GET)	
    public String updateView(Model model, HttpServletRequest request) throws Exception { 
		logger.info("/board/updateView");
		boardVo vo = boardService.boardDetail(Integer.parseInt((String)request.getParameter("boardNo")));
	    model.addAttribute("seq", vo);
	    return "/board/boardupdate";
    }
	
	// board 상세화면
	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, HttpServletRequest request) throws Exception {
		logger.info("/board/boardDetail");
		boardVo vo = boardService.boardDetail(Integer.parseInt((String)request.getParameter("boardNo")));		
		model.addAttribute("seq", vo);
		return "/board/boarddetail";
	}
	
	
	
	

	 
	// board 글삭제하기
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String boardDelete(int boardNo) throws Exception {
	    logger.info("/board/delete");	  
	  		if(boardService.boardDelete(boardNo) == 1) { 
	  	  		return "redirect:/board/boardList";
	  	  	}else {
	  	  		return "redirect:/board/boardUpdate"; 
	  	  		} 
	 }
	//test
	@RequestMapping(value = "/board/test", method = RequestMethod.GET)
	public String test(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("/board/test");
		return "/board/test";
	}
	
	
}
