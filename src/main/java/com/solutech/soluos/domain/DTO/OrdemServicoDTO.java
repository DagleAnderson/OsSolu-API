package com.solutech.soluos.domain.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.solutech.soluos.domain.Enum.StatusOrderService;

public class OrdemServicoDTO {
	private Long id;
	private ClienteDTO cliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrderService status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFechamento;
	
	
	public OrdemServicoDTO() {
		
	}


	public OrdemServicoDTO(Long id, ClienteDTO nameCliente, String descricao, BigDecimal preco, StatusOrderService status,
			OffsetDateTime dataAbertura, OffsetDateTime dataFechamento) {
		this.id = id;
		this.cliente = nameCliente;
		this.descricao = descricao;
		this.preco = preco;
		this.status = status;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
	}

		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServicoDTO other = (OrdemServicoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO nomeCliente) {
		this.cliente= nomeCliente;
	}


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


	public StatusOrderService getStatus() {
		return status;
	}


	public void setStatus(StatusOrderService status) {
		this.status = status;
	}


	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public OffsetDateTime getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(OffsetDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	
}
