package com.solutech.soluos.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.solutech.soluos.domain.exception.DBException;
import com.solutech.soluos.domain.exception.NotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleDBExceptionNotFound(NotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		StatusHandlerException exception = new StatusHandlerException();
		exception.setStatus(status.value());
		exception.setTitle(ex.getMessage());
		exception.setDateAndHour(LocalDateTime.now());

		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(DBException.class)
	public ResponseEntity<Object> handleDBException(DBException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		StatusHandlerException exception = new StatusHandlerException();
		exception.setStatus(status.value());
		exception.setTitle(ex.getMessage());
		exception.setDateAndHour(LocalDateTime.now());

		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<InputValidation> campos = new ArrayList<InputValidation>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String mensage = error.getDefaultMessage();

			campos.add(new InputValidation(name, mensage));
		}
		;

		StatusHandlerException exception = new StatusHandlerException();
		exception.setStatus(status.value());
		exception
				.setTitle("Um ou mais campos estão inválidos.Faça o preenchimento correto das informações requedidas!");
		exception.setDateAndHour(LocalDateTime.now());
		exception.setInputValidation(campos);

		// TODO Auto-generated method stub
		return super.handleExceptionInternal(ex, exception, headers, status, request);
	}
}
