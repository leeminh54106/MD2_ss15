package authorvsbook.ra.feature.impl;

import authorvsbook.ra.entity.Author;
import authorvsbook.ra.entity.Book;
import authorvsbook.ra.feature.IAuthor;

import java.util.ArrayList;
import java.util.List;

public class AuthorImpl implements IAuthor {
    public static List<Author> authors = new ArrayList<>();
static {
    Author author = new Author(20,1, "quang", "hay",true);
    Author author1 = new Author(30,2, "binh", "nice",false);
    Author author3 = new Author(40,3, "son", "good",true);
    authors.add(author);
    authors.add(author1);
    authors.add(author3);
}

    @Override
    public List<Author> findAll() {
        return authors;
    }

    @Override
    public void addOrUpdate(Author author) {
        int index = findIndexById(author.getAuthorId());
        if (index >= 0) {
            authors.set(index, author);
        } else {
            authors.add(author);
        }

    }

    @Override
    public void delete(Integer id) {
        int index = findIndexById(id);
        if (index >= 0) {
            boolean isExit = true;
            for (Book b : BookImpl.books) {
                if (b.getAuthor().getAuthorId() == id) {
                    isExit = false;
                    break;
                }
            }
            if (isExit) {
                authors.remove(index);
                System.out.println("xoa thanh cong");
            } else {
                Author author = authors.get(index);
                author.setStatus(!author.isStatus());
                addOrUpdate(author);
                System.err.println("author co chua book");
            }
        } else {
            System.err.println("ko tim thay");
        }
    }

    @Override
    public int findIndexById(Integer id) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getAuthorId() == id) {
                return i;
            }
        }
        return -1;
    }
}
