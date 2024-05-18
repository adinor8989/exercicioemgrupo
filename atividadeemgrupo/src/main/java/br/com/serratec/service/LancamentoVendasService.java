package br.com.serratec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.LancamentoVendasRepository;

@Service
public class LancamentoVendasService {

	@Autowired
	private LancamentoVendasRepository repository;

	public LancamentoVendasDTO buscarId(Long id) {
		LancamentoVendas lancamentos = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new LancamentoVendasDTO(lancamentos.getDataVenda(), lancamentos.getValorVenda(),	lancamentos.getVendedor().getNome());
	}

	public LancamentoVendas inserirLancamento(LancamentoVendas lancamentoVendas) {
		return repository.save(lancamentoVendas);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public Page<LancamentoVendas> listarPorPagina(int numeroPagina, int tamanhoPagina) {
		Pageable pageable = (Pageable) PageRequest.of(numeroPagina, tamanhoPagina);
		return repository.findAll(pageable);
	}

	public LancamentoVendas alterar(Long id, LancamentoVendas novoLancamento) {
	    LancamentoVendas lancamentoExistente = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Lançamento de vendas não encontrado"));
	    novoLancamento.setCodigoVenda(id);	   
	    return repository.save(novoLancamento);
	}
	
	/*LancamentoVendas vendas = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lancamento não encontrado"));
    venda.setCodigoVenda(id);
    return repository.save(venda);
*/
}
