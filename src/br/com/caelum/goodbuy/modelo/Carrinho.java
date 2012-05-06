package br.com.caelum.goodbuy.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {
    private List<Item> itens = new ArrayList<Item>();
    private Double total=0.0;
    
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Integer getTotalDeItens() {
        return itens.size();
    }
	
	public void adiciona(Item item) {
		itens.add(item);
        total += item.getProduto().getPreco() * item.getQuantidade();
	}
	public void remove(int indiceItem) {
		Item removido = itens.remove(indiceItem);
		total-= removido.getProduto().getPreco()*removido.getQuantidade();
	}
}