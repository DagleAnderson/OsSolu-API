package com.solutech.soluos.domain.DTO;

import java.time.OffsetDateTime;

public class ComentarioDTO {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnv;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataEnv() {
		return dataEnv;
	}
	public void setDataEnv(OffsetDateTime dataEnv) {
		this.dataEnv = dataEnv;
	}
	
	
}
