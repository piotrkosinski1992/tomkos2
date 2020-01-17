package com.tomkos2.inventory.app.usecase;

import com.tomkos2.inventory.app.domain.Book;
import com.tomkos2.inventory.app.domain.Response;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InventoryUsecase {

    public boolean isBookInStock(String id) {
        Book book = findByIsbn(id);
        return book.getAmount() > 0;
    }

    @Transactional
    public Response decreaseBookAmount(Book book) {
        Book inventoryBook = findByIsbn(book.getIsbn());
        if (!inventoryBook.decreaseAmount(book.getAmount())) {
            return Response.Error(
              "There is less book than requested inside inventory: " + inventoryBook
                .getAmount());
        }
        return Response.Ok();
    }

    private Book findByIsbn(String isbn) {
        return new Book(isbn, Long.valueOf(isbn.substring(isbn.length() - 1)));
    }

    @Transactional
    public void returnBook(Book book) {
        Book dbBook = findByIsbn(book.getIsbn());
        dbBook.increaseAmount(dbBook.getAmount());
    }
}
