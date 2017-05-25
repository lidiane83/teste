package br.unipe.pos.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.unipe.pos.web.model.UsuarioModel;

@Repository
public interface UsuerDAO extends JpaRepository<UsuarioModel, Integer>{

}
