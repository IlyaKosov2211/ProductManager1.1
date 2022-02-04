package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Product book1 = new Book(157, "Оно", 728, "Стивен Кинг");
    private Product book2 = new Book(168, "Куджо", 624, "Стивен Кинг");
    private Product book3 = new Book(178, "Мизери", 785, "Стивен Кинг");
    private Product smartphone1 = new Smartphone(128, "Iphone", 70000, "China");
    private Product smartphone2 = new Smartphone(245, "Samsung", 50000, "China");
    private Product smartphone3 = new Smartphone(367, "Asus", 20000, "China");

    @BeforeEach
    void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
    }

    @Test
    public void saveAll() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        repository.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.removeById(157);
        Product[] expected = {book2, book3, smartphone1, smartphone2,smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}