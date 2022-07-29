package br.com.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.domain.Produto;
import br.com.cadastro.repositories.ProdutoRepository;
import br.com.cadastro.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto findById(Integer id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + "Tipo: " + Produto.class.getName()));
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto save(Produto produto) {
		produto.setId(null);
		return repository.save(produto);
	}

	public Produto update(Produto produto) {
		Produto newProduto = repository.getById(produto.getId());
		updateProduto(produto, newProduto);
		return repository.save(newProduto);
	}

	private void updateProduto(Produto oldProduto, Produto newProduto) {
		newProduto.setNome(oldProduto.getNome());
		newProduto.setQuantidade(oldProduto.getQuantidade());
		newProduto.setValor(oldProduto.getValor());

	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
