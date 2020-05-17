package com.solutech.soluos.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StatusHandlerException {
	private Integer status;
	private LocalDateTime dateAndHour;
	private String title;
	private List<InputValidation> inputValidation;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDateAndHour() {
		return dateAndHour;
	}

	public void setDateAndHour(LocalDateTime dateAndHour) {
		this.dateAndHour = dateAndHour;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<InputValidation> getInputValidation() {
		return inputValidation;
	}

	public void setInputValidation(List<InputValidation> inputValidation) {
		this.inputValidation = inputValidation;
	}

}
