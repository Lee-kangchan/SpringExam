package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.app.board.BoardDAO;
import com.springbook.app.board.BoardService;
import com.springbook.app.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	
	public String updateBoard(@ModelAttribute("board")BoardVO vo) {
		System.out.println("번호   :" + vo.getSeq());
		System.out.println("제목   :" + vo.getTitle());
		System.out.println("작성자:" + vo.getWriter());
		System.out.println("내용   :" + vo.getContent());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do") //글 삭제 
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
