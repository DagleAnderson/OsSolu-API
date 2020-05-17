package com.solutech.soluos.domain.DTO;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewOrdemServicoDTO {
	
	@Valid
	@NotNull
	private ClienteIdDTO cliente;
	
	@NotBlank
	private String descricao;
	@NotNull
	private BigDecimal preco;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public ClienteIdDTO getCliente() {
		return cliente;
	}
	public void setIdCliente(ClienteIdDTO cliente) {
		this.cliente = cliente;
	}
	
	
}
