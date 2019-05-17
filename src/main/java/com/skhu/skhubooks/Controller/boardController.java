package com.skhu.skhubooks.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skhu.skhubooks.Service.boardService;
import com.skhu.skhubooks.VO.boardVO;

@Controller
public class boardController {
	@Autowired
	boardService service;
	
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public String boardList(Model model)throws Exception{
		List<boardVO> list;
		list = service.boardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardInsert", method = RequestMethod.GET)
	public String boardInsert(Model model)throws Exception{
		return "/board/boardInsert";
	}
	
	@RequestMapping(value = "/board/boardInsertDo", method = RequestMethod.GET)
	public String boardInsertDo(Model model, boardVO boardvo)throws Exception{
		service.boardInsert(boardvo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, boardVO boardvo)throws Exception{
		model.addAttribute("list",service.boardDetail(boardvo.getBoard_no()));
		return "/board/boardDetail";
	}
	
	@RequestMapping(value = "/board/boardDelete", method = RequestMethod.GET)
	public String boardDelete(Model model, boardVO boardvo)throws Exception{
		service.boardDelete(boardvo.getBoard_no());
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardUpdate", method = RequestMethod.GET)
	public String boardUpdate(Model model, boardVO boardvo)throws Exception{
		model.addAttribute("list",service.boardDetail(boardvo.getBoard_no()));
		return "/board/boardUpdate";
	}
	
	@RequestMapping(value = "/board/boardUpdateDo", method = RequestMethod.GET)
	public String boardUpdateDo(Model model, boardVO boardvo)throws Exception{
//		System.out.println(boardvo);
		service.boardUpdate(boardvo);
		return "redirect:/board/boardDetail?board_no="+boardvo.getBoard_no();
	}
}
