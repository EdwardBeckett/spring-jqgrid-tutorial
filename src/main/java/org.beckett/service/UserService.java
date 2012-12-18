package org.beckett.service;

import org.beckett.domain.User;
import org.beckett.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Edward
 * Date: 12/16/12
 * Time: 8:08 AM
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Boolean create( User user ) {
		user.getRole().setUser( user );
		User saved = repository.save( user );
		if( saved == null ) {
			return false;
		}
		return true;
	}

	public Boolean update( User user ) {
		User existingUser = repository.findByUsername( user.getUsername() );
		if( existingUser == null ) {
			return false;
		}
		// Only firstName, lastName, and role fields are updatable
		existingUser.setFirstName( user.getFirstName() );
		existingUser.setLastName( user.getLastName() );
		existingUser.getRole().setRole( user.getRole().getRole() );

		User saved = repository.save( existingUser );
		if( saved == null )
			return false; {

		}
		return true;
	}

	public Boolean delete( User user ) {
		User existingUser = repository.findByUsername( user.getUsername() );
		if( existingUser == null )
			return false;

		repository.delete( existingUser );
		User deletedUser = repository.findByUsername( user.getUsername() );
		if( deletedUser != null )
			return false;

		return true;
	}
}