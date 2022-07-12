package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
//	Passport findByPassportId(int id);
	List<User> findAll();
	User save(User user);
	void deleteById(int id);
	
	@Query (" select u from User u where u.id = ?1")   // ?1,?2,?3 => positioned parameters
	User getUserByQuery(int uid); // example for JPQL	

	@Query (value = " select * from users u where u.USER_ID = ?1" , nativeQuery = true)  
	User getUserByNativeSQL(int uid);  // Example of Native Query
//	 By default @Query will execute only select statements
//	To execute insert, update, delete statements @Query should be marked as @Modifying
	
	@Modifying
	@Query("update User u set u.name = ?2, u.city = ?3 where u.id= ?1")
	void modifyUser(int id ,String name, String city);
	
//	@Param
	@Query("select u from User u where u.city = :vcity")  // Named parameter
	List<User> getUserFromCity( @Param("vcity") String city);
}