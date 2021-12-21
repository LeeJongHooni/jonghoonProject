package com.comment.model;

import java.util.List;

public class CommentService {
	
	public boolean commentInsert(CommentDTO dto) {
		CommentDAO dao = new CommentDAO();
		boolean res = dao.commentInsert(dto);
		
		if(res) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return res;
	}
	
	public List<CommentDTO> commentSelect(){
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> datas = dao.commentSelect();
		
		if(datas.size() != 0 ) {
			dao.close();
			return datas;
		}else {
			dao.close();
			System.out.println("commentselect fail");
			return datas;
		}
	}

}
