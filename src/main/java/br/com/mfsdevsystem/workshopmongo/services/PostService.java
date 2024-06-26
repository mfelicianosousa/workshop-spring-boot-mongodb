package br.com.mfsdevsystem.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.workshopmongo.domain.Post;
import br.com.mfsdevsystem.workshopmongo.repository.PostRepository;
import br.com.mfsdevsystem.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id ) {

		try {
	    	Post post = postRepository.findById( id ).get();
			
		   return post;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Object não encontrado!");
		}
		
	}

	public List<Post> findByTitle(String text){
		// return postRepository.findByTitleContainingIgnoreCase( text );
		return postRepository.searchTitle( text );
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
	
}
