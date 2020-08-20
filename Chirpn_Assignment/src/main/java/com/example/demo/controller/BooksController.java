package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;
import com.example.demo.service.BookService;


@Controller
public class BooksController {
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private BookService bookService;

	/*
	 * @GetMapping("/books") public List<Books> getAllBookss() { return
	 * booksRepository.findAll(); }
	 */
	
	@RequestMapping(value = "/home")
	public String init(Model model) {
		Books b = new Books();
		model.addAttribute("book", b);
		return "books";
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("book") Books c, Model model) {
		boolean isSaved = bookService.saveBook(c);
		if (isSaved) {
			model.addAttribute("succMsg", "Book Saved");
		} else {
			model.addAttribute("errMsg", "Failed to save");
		}
		return "books";
	}

	/*@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBooksById(@PathVariable(value = "id") Long booksId)
			throws ResourceNotFoundException {
		Books books = booksRepository.findById(booksId)
				.orElseThrow(() -> new ResourceNotFoundException("Books not found for this id :: " + booksId));
		return ResponseEntity.ok().body(books);
	}

	@PostMapping("/books")
	public Books createBooks(@Valid @RequestBody Books books) {
		return booksRepository.save(books);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBooks(@PathVariable(value = "id") Long booksId,
			@Valid @RequestBody Books booksDetails) throws ResourceNotFoundException {
		Books books = booksRepository.findById(booksId)
				.orElseThrow(() -> new ResourceNotFoundException("Books not found for this id :: " + booksId));

		books.setEmail(booksDetails.getEmail());
		books.setLastName(booksDetails.getLastName());
		books.setFirstName(booksDetails.getFirstName());
		books.setUserName(booksDetails.getUserName());
		books.setMobileNumber(booksDetails.getMobileNumber());
		final Books updatedBooks = booksRepository.save(books);
		return ResponseEntity.ok(updatedBooks);
	}

	@DeleteMapping("/books/{id}")
	public Map<String, Boolean> deleteBooks(@PathVariable(value = "id") Long booksId)
			throws ResourceNotFoundException {
		Books books = booksRepository.findById(booksId)
				.orElseThrow(() -> new ResourceNotFoundException("Books not found for this id :: " + booksId));

		booksRepository.delete(books);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
