package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class BoardsDAO {

	SqlSessionFactory sqlSessionFactory  = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
// 게시글 업로드
	public int upload_post(BoardsDTO b_dto) {
		System.out.println("BoardsDAO 도착");
						
		int result = sqlSession.insert("upload",b_dto);
		if(result > 0) {
			System.out.println("업로드 성공!");
		}
		sqlSession.close();
		
		return result;
	}

// 메인게시판 전체 데이터 가져오기
	public List<BoardsDTO> Show_allBoard(int endRow){
		List<BoardsDTO> list = new ArrayList<BoardsDTO>();
				
		try {
			list =sqlSession.selectList("Show_allBoard",endRow);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}
	

	// db에 저장된 전체 갯수  ..페이징
	public int BoardsTotal() {
	    int total = 0;
	    try (SqlSession session = sqlSessionFactory.openSession()) {
	        total = session.selectOne("BoardsTotal");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return total;
	}
	
	
	// 메인게시판에서 해당 게시물만 가져오기
	public BoardsDTO show_DetailBoard(int B_IDX) {
		BoardsDTO list = null;
		try {
			list = (BoardsDTO)sqlSession.selectOne("show_DetailBoard",B_IDX);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;		
	}
	
	//조회수 업데이트하기
	public int b_views_inc(BoardsDTO dto) {
		System.out.println("BoardsDAO b_views_inc 도착");
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
						

		int result = sqlSession.update("b_views_inc", dto);
		
		if(result > 0) {
			System.out.println("업데이트 성공!");
		}else {
			System.out.println("업데이트 실패");
		}
		sqlSession.close();
		
		return result;
	}

	// 해당게시물 삭제하기
	public int delBoard(int b_idx) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = sqlSession.delete("delBoard", b_idx);
		sqlSession.close();
		return cnt; 
		
	}

	public int imgUpload(BoardImgsDTO idto) {
		System.out.println("BoardImgsDAO 도착");
						
		int result = sqlSession.insert("imgUpload",idto);
		if(result > 0) {
			System.out.println("이미지업로드 성공!");
		}
		sqlSession.close();
		
		return result;
	}
	
}
