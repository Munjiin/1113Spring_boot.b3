package org.zerock.persistence;

import org.apache.ibatis.annotations.Delete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.PDS;

public interface PDSRepository extends CrudRepository<PDS, Long>{
	
	@Modifying
	@Query("UPDATE FROM PDSFile f set f.fname=?2 "
			+ "WHERE f.fno =?1 ") //물음표 뒤에 바로 붙여쓰기
	public int updatePDSFile(Long fno, String newFileName);
	
	//첨부파일 삭제
	@Modifying
	@Query("DELETE FROM PDSFile f WHERE f.fno=?1")
	public int deletePDSFile(Long fno);

}
