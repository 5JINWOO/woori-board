package woo.edu.c.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import woo.edu.c.service.BoardService;
import woo.edu.c.vo.boardVo;

@Controller
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService boardService;	
	
	//ajax home
	@RequestMapping(value = "/board/boardAjaxList", method = RequestMethod.GET)
	public String boardAjaxList(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("/board/boardAjaxList");
		return "/board/ajaxlist";
	}
	
	// ajax 글 목록
	@ResponseBody
	@RequestMapping(value = "/board/ajaxList", method = RequestMethod.GET)
	public List<boardVo> ajaxList()	{
		List<boardVo> list = boardService.ajaxList();
		System.out.println("list===="+list);
		return list;
	}
	
	// ajax 글삭제하기
	@ResponseBody
	@RequestMapping(value = "/board/ajaxDelete", method = RequestMethod.GET)
	public String ajaxDelete(HttpServletRequest request) throws Exception {
		logger.info("/board/ajaxdelete");	
		if(boardService.ajaxDelete(Integer.parseInt((String)request.getParameter("boardNo"))) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	// ajax 선택삭제하기
	@ResponseBody
	@RequestMapping(value = "/board/chkDelete", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String chkDelete(@RequestParam(value="arr[]",required=false)int[] arr) throws Exception {
		logger.info("/board/chkDelete");
		logger.info("========== 배열확인 : "+ arr );
		String reslutStr = "";
		try {
			for( int i=0; i<arr.length; i++) {
				boardService.ajaxDelete(arr[i]);
				System.out.println(arr[i]);
			}	
			reslutStr = "성공";
		} catch (Exception e) {
			reslutStr = "실패";
			// TODO: handle exception
		}

//		if(boardService.ajaxDelete(Integer.parseInt((String)request.getParameter("arr"))) >= 1) {
//			return "Y";
//		}else {
//			return "N";
//		}
		
		return reslutStr;
	}
	
	
	//ajax 게시글등록
	@ResponseBody
	@RequestMapping(value = "/board/ajaxSave", method = RequestMethod.POST)
	public String ajaxSave(@RequestBody boardVo vo) throws Exception {
//		public String ajaxSave(boardVo vo) throws Exception {
		logger.info("/board/ajaxSave");
		System.out.println("vo===="+vo);
		
		if(boardService.ajaxSave(vo) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	//ajax 게시글 상세화면
	@ResponseBody
	@RequestMapping(value = "/board/ajaxDetail", method = RequestMethod.POST)
	public boardVo ajaxDetail(@RequestParam(name="boardNo", required=false)int boardNo){		
		boardVo detail = boardService.ajaxDetail(boardNo);
		System.out.println("ajax상세화면===="+boardNo);
				
//		model.addAttribute("detail", detail); VIEW단에 바로 뿌려줌 JSTL로 변수 사용  /관계없음
		return detail;
	}
//	}
//	리퀘스트 파람 select one  list똒같다

}	
