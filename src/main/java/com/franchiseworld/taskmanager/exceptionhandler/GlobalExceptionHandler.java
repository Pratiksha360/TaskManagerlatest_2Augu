package com.franchiseworld.taskmanager.exceptionhandler;

import com.franchiseworld.taskmanager.customexception.ProjectNotFoundException;
import com.franchiseworld.taskmanager.customexception.TaskNotFoundException;
import com.franchiseworld.taskmanager.customexception.TransactionException;
import com.franchiseworld.taskmanager.customexception.UserNameNotFoundException;
import com.franchiseworld.taskmanager.message.ApiError;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { UserNameNotFoundException.class })
	public ResponseEntity<ApiError> handleException1(UserNameNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { ProjectNotFoundException.class })
	public ResponseEntity<ApiError> handleExceptionn2(ProjectNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { TaskNotFoundException.class })
	public ResponseEntity<ApiError> handleExceptionn3(TaskNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { SQLIntegrityConstraintViolationException.class, DataIntegrityViolationException.class })
	public ResponseEntity<ApiError> handleExceptionn4(SQLIntegrityConstraintViolationException ex) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT.value(), ex.getLocalizedMessage());
		return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = { UnexpectedTypeException.class })
	public ResponseEntity<ApiError> handleExceptionn5(UnexpectedTypeException ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	protected ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),
				ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { TransactionException.class })
	public ResponseEntity<ApiError> handleException(TransactionException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}

}
