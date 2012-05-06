package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.infra.ProdutoDAO;
import br.com.caelum.goodbuy.modelo.Carrinho;
import br.com.caelum.goodbuy.modelo.Item;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CarrinhoController {
	private ProdutoDAO dao;
	private Carrinho carrinho;
	private Result result;

	public CarrinhoController(ProdutoDAO dao, Carrinho carrinho, Result result) {
		this.dao = dao;
		this.carrinho = carrinho;
		this.result = result;
	}
	
	@Delete @Path("/carrinho/{indiceItem}")
	public void deletar(int indiceItem){
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}
	
	@Get @Path("/carrinho")
    public void visualiza() {
    }
	
	 @Post @Path("/carrinho")
     public void adiciona(Item item) {
         dao.recarrega(item.getProduto());
         carrinho.adiciona(item);
         result.redirectTo(this).visualiza();
     }

}
