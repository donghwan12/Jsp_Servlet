package com.example.app.domain.commo.service;

import java.util.List;
import java.util.Map;

import com.example.app.domain.commo.dto.BookDto;
import com.example.app.domain.commo.dto.Criteria;

public interface BookService {

	boolean bookRegister(BookDto dto) throws Exception;

	List<BookDto> getAllBooks() throws Exception;

	BookDto getBook(int bookCode) throws Exception;

	Map<String, Object> getAllBooks(Criteria criteria) throws Exception;

}