package br.unipe.pos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.dao.UsuerDAO;
import br.unipe.pos.web.model.ContatoModel;
import br.unipe.pos.web.model.UsuarioModel;
@Controller
@RequestMapping("/usuario")

public class UserController {
		
		// id nome email senha
		@Autowired
		private UsuerDAO repositorio;
		
		@RequestMapping(path="/formUser", method=RequestMethod.GET)	
		public String form(Model model) {
			model.addAttribute("usuario", new UsuarioModel());
			return "/usuario/usuarioform";
		}

		@RequestMapping(path="/consultarUser",method=RequestMethod.GET)
		@ResponseBody
		public String consultar(
				@PathVariable(name="id") int id){		
			
			UsuarioModel usuario = repositorio.findOne(id);
			if(usuario!=null) 
				return usuario.toString();
			
			return "Sem resultado";
		}
		
		@RequestMapping(path="/removeruser/{id}",method=RequestMethod.GET)
		@ResponseBody
		public String remover(
				@PathVariable(name="id") int id){				
			repositorio.delete(id);		
			return "Sucesso";
		}
		
		@RequestMapping("/usuario/incluir")
		@ResponseBody
		public String incluir(UsuarioModel user){
			repositorio.save(user);
			return "Sucesso";
		}
		
		@RequestMapping(path={"/listaruser"} , method=RequestMethod.GET)
		public List<UsuarioModel> listar(){
			List<UsuarioModel> lista = 
					repositorio.findAll();
			return lista;
		}
		
			

		public UsuerDAO getRepositorio() {
			return repositorio;
		}

		public void setRepositorio(UsuerDAO repositorio) {
			this.repositorio = repositorio;
		}



}
