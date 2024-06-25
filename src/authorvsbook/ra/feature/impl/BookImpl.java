package authorvsbook.ra.feature.impl;

import authorvsbook.ra.entity.Book;
import authorvsbook.ra.feature.IBook;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements IBook {
   public static List<Book> books = new ArrayList<Book>();


   @Override
   public List<Book> findAll() {
      return books;
   }

   @Override
   public void addOrUpdate(Book book) {
   int index = findIndexById(book.getBookId());
   if (index >= 0) {
      books.set(index, book);
   }else {
      books.add(book);
   }
   }

   @Override
   public void delete(String id) {
   int index = findIndexById(id);
   if (index >= 0) {
      books.remove(index);
   }else {
      System.err.println("ko ton tai");
   }
   }

   @Override
   public int findIndexById(String id) {
      for(int i = 0; i < books.size(); i++){
         if(books.get(i).getBookId().equals(id)){
            return i;
         }
      }
      return -1;
   }
}
