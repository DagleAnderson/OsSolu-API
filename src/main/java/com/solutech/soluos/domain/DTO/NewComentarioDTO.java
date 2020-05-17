package com.solutech.soluos.domain.DTO;

import javax.validation.constraints.NotBlank;

public class NewComentarioDTO {
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
