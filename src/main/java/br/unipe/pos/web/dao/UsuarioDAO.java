package br.unipe.pos.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import br.unipe.pos.web.model.UsuarioModel;

@Repository
public class UsuarioDAO implements UserDetailsService{
	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		List resultado = (List) em.createQuery("select * from tb_usuario where email= :email", UsuarioModel.class).setParameter("email", email).getResultList();
		
		return ((java.util.List<UsuarioModel>) resultado).get(0);
	}

	
}
