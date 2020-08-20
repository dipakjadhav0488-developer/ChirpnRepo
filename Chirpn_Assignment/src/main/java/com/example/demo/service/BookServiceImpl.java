package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository booksrepo;

	@Override
	public boolean saveBook(Books b) {
		Books entity = new Books();
		BeanUtils.copyProperties(b, entity);
		Books savedEntity = booksrepo.save(entity);
		return savedEntity.getId() != null;
	}


}
