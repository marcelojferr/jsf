package com.javaproject.customer.jsf.service;

import java.util.List;

import com.javaproject.customer.jsf.dao.UsuarioDAO;
import com.javaproject.customer.jsf.entity.UsuarioEntity;

public class UsuarioService {

	public void cadastrarUsuario(UsuarioEntity usuario) {
		new UsuarioDAO().cadastrarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarTodos(){
		return new UsuarioDAO().listarTodos();
	}
	
	public void excluir(Long id) {
		new UsuarioDAO().excluir(id);
	}
	
	public void alterar(UsuarioEntity usuario) {
		new UsuarioDAO().alterar(usuario);
	}
}
