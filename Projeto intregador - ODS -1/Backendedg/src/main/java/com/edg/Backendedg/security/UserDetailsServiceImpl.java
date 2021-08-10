package com.edg.Backendedg.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edg.Backendedg.model.Usuario;
import com.edg.Backendedg.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		Optional<Usuario> usuario= userRepository.findByEmail(userName);
		usuario.orElseThrow(()-> new UsernameNotFoundException(userName + "Not Found!" ));
		
		return usuario.map(UserDetailsImpl::new).get();
	}
	
	

}