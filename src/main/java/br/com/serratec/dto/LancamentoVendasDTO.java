package br.com.serratec.dto;


import java.time.LocalDateTime;

import br.com.serratec.entity.LancamentoVendas;

public class LancamentoVendasDTO {

	private LocalDateTime dataVenda;
	private Double valorVenda;
	private String nomeVendedor;
	
		
	
	public LancamentoVendasDTO(LancamentoVendas lv) {
		super();
		this.dataVenda = lv.getDataVenda();
		this.valorVenda = lv.getValorVenda();
		this.nomeVendedor = lv.getVendedor().getNome();
	}

	

	public LancamentoVendasDTO(LocalDateTime dataVenda2, Double valorVenda2, String nome) {
		this.dataVenda = dataVenda2;
		this.valorVenda = valorVenda2;
		this.nomeVendedor = nome;
	}



	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	
	
	
}
