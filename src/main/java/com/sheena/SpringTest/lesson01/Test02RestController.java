package com.sheena.SpringTest.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheena.SpringTest.lesson01.model.NoticeBoard;

@RestController
@RequestMapping("/lesson01/test02")
public class Test02RestController {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> printMovieInfo() {
		
		List<Map<String,Object>> movieList = new ArrayList<>();
		
		Map<String,Object> movieInfo1 = new HashMap<>();
		movieInfo1.put("rate", 15);
		movieInfo1.put("director", "봉준호");
		movieInfo1.put("time", 131);
		movieInfo1.put("title", "기생충");
		movieList.add(movieInfo1);
		
		Map<String,Object> movieInfo2 = new HashMap<>();
		movieInfo2.put("rate", 0);
		movieInfo2.put("director", "로베르토 베니니");
		movieInfo2.put("time", 116);
		movieInfo2.put("title", "인생은 아름다워");
		movieList.add(movieInfo2);
		
		Map<String,Object> movieInfo3 = new HashMap<>();
		movieInfo3.put("rate", 12);
		movieInfo3.put("director", "크리스토퍼 놀란");
		movieInfo3.put("time", 147);
		movieInfo3.put("title", "인셉션");
		movieList.add(movieInfo3);
		
		Map<String,Object> movieInfo4 = new HashMap<>();
		movieInfo4.put("rate", 19);
		movieInfo4.put("director", "윤종빈");
		movieInfo4.put("time", 133);
		movieInfo4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieList.add(movieInfo4);
		
		Map<String,Object> movieInfo5 = new HashMap<>();
		movieInfo5.put("rate", 15);
		movieInfo5.put("director", "프란시스 로렌스");
		movieInfo5.put("time", 116);
		movieInfo5.put("title", "헝거게임");
		movieList.add(movieInfo5);
		
		return movieList;
	}
	
	
	
	@RequestMapping("/2")
	public List<NoticeBoard> printNoticeBoard() {
		
		List<NoticeBoard> noticeBoardList = new ArrayList<NoticeBoard>();
		
		NoticeBoard noticeBoard1 = new NoticeBoard();
		noticeBoard1.setTitle("안녕하세요 가입인사 드립니다.");
		noticeBoard1.setUser("hagulu");
		noticeBoard1.setContent("안녕하세요. 가입했습니다.");
		noticeBoardList.add(noticeBoard1);
		
		NoticeBoard noticeBoard2 = new NoticeBoard();
		noticeBoard2.setTitle("안녕하세요");
		noticeBoard2.setUser("bada");
		noticeBoard2.setContent("축하드립니다.");
		noticeBoardList.add(noticeBoard2);
		
		NoticeBoard noticeBoard3 = new NoticeBoard();
		noticeBoard3.setTitle("환영합니다.");
		noticeBoard3.setUser("dulumary");
		noticeBoard3.setContent("안녕하세요. 가입했습니다.");
		noticeBoardList.add(noticeBoard3);
		
		
		return noticeBoardList;
		
		
	}
	
	
	@RequestMapping("/3")
	public ResponseEntity<NoticeBoard> entity() {
		NoticeBoard noticeBoard = new NoticeBoard();
		noticeBoard.setTitle("안녕하세요 가입인사 드립니다.");
		noticeBoard.setUser("hagulu");
		noticeBoard.setContent("안녕하세요. 가입했습니다.");
		
		ResponseEntity<NoticeBoard> entity = new ResponseEntity(noticeBoard, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	

}
