package com.MappingPractice.StudentManagementMappingPractice.Service;

import com.MappingPractice.StudentManagementMappingPractice.Model.Book;
import com.MappingPractice.StudentManagementMappingPractice.Repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepo.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setStudent(updatedBook.getStudent());
            return bookRepo.save(existingBook);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
