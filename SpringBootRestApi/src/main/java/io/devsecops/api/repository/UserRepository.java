package io.devsecops.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.devsecops.api.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// get an user
	@Query("SELECT u FROM User u WHERE u.userName =:userName")
	User findByUsername(@Param("userName") String userName);

}
