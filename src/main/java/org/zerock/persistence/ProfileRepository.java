package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Profile; //임폴트 조심

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
