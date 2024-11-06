import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTester {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void addBookTest(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(true);
    }

    @Test
    void addBookPhoneTest(){
        Store store = new Store();
        Book book = new Book();
        Phone phone = new Phone();
        store.addBook(book);
        store.addPhone(phone);
        assertTrue(true);
    }

    @Test
    void phoneLocationTest(){
        Store store = new Store();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updatePhonesLocation("Room 512");
        ArrayList<CISItem> check = store.getAllPhones();
        for(CISItem obj:check){
            assertEquals(obj.getLocation(),"Room 512");
        }
    }

    @Test
    void getItemsTest(){
        Store store = new Store();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Arduino arduino1 = new Arduino();
        Arduino arduino2 = new Arduino();
        Magazine magazine1 = new Magazine();
        Magazine magazine2 = new Magazine();
        Magazine magazine3 = new Magazine();

        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addItem(arduino1);
        store.addItem(arduino2);
        store.addItem(magazine1);
        store.addItem(magazine2);
        store.addItem(magazine3);

        ArrayList<CISItem> itemCheck = store.getItems("phone");
        CISItem[] ans = new CISItem[]{phone1,phone2};
        for(int i=0;i<itemCheck.size();i++){
            assertEquals(itemCheck.get(i),ans[i]);
        }

        itemCheck = store.getItems("magazine");
        ans = new CISItem[]{magazine1,magazine2,magazine3};
        for(int i=0;i<itemCheck.size();i++){
            assertEquals(itemCheck.get(i),ans[i]);
        }

        itemCheck = store.getItems("arduino");
        ans = new CISItem[]{arduino1,arduino2};
        for(int i=0;i<itemCheck.size();i++){
            assertEquals(itemCheck.get(i),ans[i]);
        }
    }

    @Test
    void updateItemsTest(){
        Store store = new Store();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Arduino arduino1 = new Arduino();
        Arduino arduino2 = new Arduino();
        Magazine magazine1 = new Magazine();
        Magazine magazine2 = new Magazine();
        Magazine magazine3 = new Magazine();

        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addItem(arduino1);
        store.addItem(arduino2);
        store.addItem(magazine1);
        store.addItem(magazine2);
        store.addItem(magazine3);

        store.updateItems("phone","operatingsystem","IOS 101");
        store.updateItems("phone","screensize","103");
        store.updateItems("arduino","name","hello");
        store.updateItems("magazine","author","jeff");
        store.updateItems("book","description","this is a book!");
        store.updateItems("book","datePublished","jan 2024");

        ArrayList<CISItem> itemCheck = store.getItems("phone");
        for(CISItem item:itemCheck){
            if(item instanceof Phone){
                assertEquals(((Phone) item).getOperatingSystem(),"IOS 101");
                assertEquals(((Phone) item).getScreenSize(),103);
            }
        }

        itemCheck = store.getItems("arduino");
        for(CISItem item:itemCheck){
            assertEquals(item.getName(),"hello");
        }

        itemCheck = store.getItems("magazine");
        for(CISItem item:itemCheck){
            if(item instanceof ReadingItem){
                assertEquals(((ReadingItem) item).getAuthor(),"jeff");
            }
        }

        itemCheck = store.getItems("book");
        for(CISItem item:itemCheck){
            assertEquals(item.getDescription(),"this is a book!");
            if(item instanceof Book){
                assertEquals(((Book) item).getDatePublished(),"jan 2024");
            }
        }
    }

}