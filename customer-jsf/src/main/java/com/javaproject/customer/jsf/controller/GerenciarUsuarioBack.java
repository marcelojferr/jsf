package com.javaproject.customer.jsf.controller;

import java.util.List;
import com.javaproject.customer.jsf.entity.UsuarioEntity;
import com.javaproject.customer.jsf.service.UsuarioService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "gerenciarUsuario")
@SessionScoped
public class GerenciarUsuarioBack {

	private UsuarioEntity usuario;
	
	private List<UsuarioEntity> usuarios;

	private Long cont = 0L;
	
	public GerenciarUsuarioBack() {
		usuario = new UsuarioEntity();
		usuarios = new UsuarioService().listarTodos();	
	}

	public void excluir(UsuarioEntity usu) {
		new UsuarioService().excluir(usu.getId());		
		usuarios = new UsuarioService().listarTodos();
	}
	
	public void carregarForm(UsuarioEntity usu) {
		usuario = usu;
	}
	
	public void salvar() {
		
		if(usuario.getId() == null) {			
			//Gerando um ID pro meu usuário
			usuario.setId(cont);
			cont++;
	
			//Adiciona o usuario na lista
			//usuarios.add(usuario);
			new UsuarioService().cadastrarUsuario(usuario);
		}else {
			new UsuarioService().alterar(usuario);
		}
		//Limpa objeto usuario, e consequentemente ele limpará o campo
		usuario = new UsuarioEntity();	
		usuarios = new UsuarioService().listarTodos();	
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
}
