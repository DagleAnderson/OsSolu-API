package com.solutech.soluos.domain.DTO;

import javax.validation.constraints.NotNull;

public class ClienteIdDTO {
	
	@NotNull
	private	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
