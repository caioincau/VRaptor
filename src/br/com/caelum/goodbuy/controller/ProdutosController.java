package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.infra.ProdutoDAO;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ProdutosController {
	private final ProdutoDAO dao;
	private final Result result;

	public ProdutosController(ProdutoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	public void remove(Long id){
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}
	
	public Produto edita(Long id) {
	       return dao.carrega(id);
	   }
	   public void altera(Produto produto) {
	       dao.atualiza(produto);
	       result.redirectTo(this).lista();
	}

	public void formulario() {
	}

	public List<Produto> lista() {
		return dao.listaTudo();

	}

	public void adiciona(Produto produto) {
		this.dao.salva(produto);
		result.redirectTo(this).lista();
	}
}
