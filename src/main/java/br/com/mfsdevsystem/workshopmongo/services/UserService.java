package br.com.mfsdevsystem.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.workshopmongo.domain.User;
import br.com.mfsdevsystem.workshopmongo.dto.UserDTO;
import br.com.mfsdevsystem.workshopmongo.repository.UserRepository;
import br.com.mfsdevsystem.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
	   return userRepository.findAll();	
	}
	
	public User findById(String id ) {

		try {
	    	User user = userRepository.findById( id ).get();
			
		   return user;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Object não encontrado!");
		}
		
	}

	public User insert(User obj) {
		
	    return userRepository.insert( obj );	
	    
	}
	
	public User fromDTO( UserDTO objDTO) {
		
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	
	}
	
	public void delete(String id) {
	
		userRepository.deleteById( id );
		
	}
}
