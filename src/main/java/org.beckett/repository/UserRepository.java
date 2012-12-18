package org.beckett.repository;

import org.beckett.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * User: Edward
 * Date: 12/16/12
 * Time: 8:06 AM
 */

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername( String username );

	Page<User> findByUsernameLike( String username, Pageable pageable );

	Page<User> findByFirstNameLike( String firstName, Pageable pageable );

	Page<User> findByLastNameLike( String lastName, Pageable pageable );

	Page<User> findByFirstNameLikeAndLastNameLike( String firstName, String lastName, Pageable pageable );

	@Query( "select u from user u where u.role.role = :role" )
	Page<User> findByRole( @Param( "role" ) Integer role, Pageable pageable );
}