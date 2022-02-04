package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(157, "Оно", 728, "Стивен Кинг");
    private Product book2 = new Book(168, "Куджо", 624, "Стивен Кинг");
    private Product book3 = new Book(178, "Мизери", 785, "Стивен Кинг");
    private Product smartphone1 = new Smartphone(128, "Iphone", 70000, "China");
    private Product smartphone2 = new Smartphone(245, "Samsung", 50000, "China");
    private Product smartphone3 = new Smartphone(367, "Asus", 20000, "China");

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void searchBookByName() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Мизери");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByAuthor() {
        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Стивен Кинг");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Александр Дюма");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByManufacturer() {
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("China");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindManufacturer() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Slovakia");
        assertArrayEquals(expected, actual);
    }
}