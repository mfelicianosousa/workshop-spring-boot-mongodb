package br.com.mfsdevsystem.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.workshopmongo.domain.User;
import br.com.mfsdevsystem.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
	   return userRepository.findAll();	
	}
}
