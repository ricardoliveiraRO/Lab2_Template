package pt.pa.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkManagerTest {
    //take comments when BookmarkManager is implemented

    private BookmarkManager manager;
    @BeforeEach
    void setUp() {
       manager= new BookmarkManager();
    }

    @org.junit.jupiter.api.Test
    void getTotalLinks() {
        assertEquals(1,manager.getTotalEntries());
        manager.addBookmarkFolder("bookmarks", "Redes Sociais");
        manager.addBookmarkFolder("bookmarks", "Diversos");
        assertEquals(3,manager.getTotalEntries());
        manager.addBookmarkEntry("diversos", "Gmail", "http://www.gmail.com");
        manager.addBookmarkEntry("diversos", "StackOverflow", "http://www.stackoverflow.com");
        assertEquals(5,manager.getTotalEntries());
    }








}