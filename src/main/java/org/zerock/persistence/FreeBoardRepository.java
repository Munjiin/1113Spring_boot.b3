package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

	@Query("select b from FreeBoard b where b.bno>0")
	public List<FreeBoard> list(Pageable pageable);
	
	//보드와 댓글 조인
	@Query("select b, count(r) from FreeBoard b "
			+"left outer join FreeReply r on b.bno = r.board "
			+ "group by b") //* 불가
	public Page<Object[]> listPage(Pageable pageable);
	
	//제목 검색과 페이징
	@Query("select b, count(r) from FreeBoard b "
			+"left outer join FreeReply r on b.bno = r.board "
			+ "where b.title like %?1% "
			+ "group by b")
	public Page<Object[]> listByPage(String keyword,Pageable pageable);
	
	//제목이나 내용에 키워드 넣기
	@Query("select b, count(r) from FreeBoard b "
			+"left outer join FreeReply r on b.bno = r.board "
			+ "where (b.title like %?1% or b.content like %?1% ) "
			+ "group by b")
	public Page<Object[]> listByTitleOrContentPage(String keyword,Pageable pageable);
	
}
