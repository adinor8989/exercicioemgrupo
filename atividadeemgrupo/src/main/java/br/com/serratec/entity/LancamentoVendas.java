package br.com.serratec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class LancamentoVendas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVenda;
	@NotNull
	private LocalDateTime dataVenda;
	private Double valorVenda;
	
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor")
	private Vendedor vendedor;
	
	
	public Long getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
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
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
