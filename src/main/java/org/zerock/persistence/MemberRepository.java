package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Member; //도메인 조심

public interface MemberRepository extends CrudRepository<Member, String> {

	@Query("SELECT m.uid, count(p) FROM Member m LEFT OUTER JOIN Profile p ON m.uid = p.member WHERE m.uid = ?1 GROUP BY m")
    public List<Object[]> getMemberWithProfileCount(String uid);
}
