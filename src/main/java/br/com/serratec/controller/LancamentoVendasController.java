package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.serratec.dto.LancamentoVendasDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.service.LancamentoVendasService;

@RestController
@RequestMapping("/lancamentovendas")
public class LancamentoVendasController {

	@Autowired
	private LancamentoVendasService service;
	
	@GetMapping("{id}")
	public ResponseEntity<LancamentoVendasDTO> buscarId(@PathVariable Long id) {

		return ResponseEntity.ok(service.buscarId(id));
	}

	@PostMapping
    public ResponseEntity<Object> inserir(@RequestBody LancamentoVendas lancamentoVendas) {
        try {
            LancamentoVendas novoLancamentoDTO = service.inserirLancamento(lancamentoVendas);
            return ResponseEntity.created(null).body(novoLancamentoDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
	
    @GetMapping
    public ResponseEntity<Page<LancamentoVendas>> listarPorPagina(
            @RequestParam(defaultValue = "0") int numeroPagina,
            @RequestParam(defaultValue = "10") int tamanhoPagina) {
        Page<LancamentoVendas> paginaLancamentos = service.listarPorPagina(numeroPagina, tamanhoPagina);
        return ResponseEntity.ok(paginaLancamentos);
    }
    
   
    @DeleteMapping("/{id}")
	public ResponseEntity<LancamentoVendasDTO> removerPorId(@PathVariable Long id) {
	    if (service.buscarId(id) != null) {
	        service.deletar(id);
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<LancamentoVendas> alterar(@PathVariable Long id, @RequestBody LancamentoVendas novoLancamento) {
        if (service.buscarId(id) != null) {
            LancamentoVendas lancamentoAlterado = service.alterar(id, novoLancamento);
            return ResponseEntity.ok(lancamentoAlterado);
        }
        return ResponseEntity.notFound().build();
    }

}

