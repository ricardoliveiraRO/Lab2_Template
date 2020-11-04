package pt.pa.adts;

import javafx.geometry.Pos;
import pt.pa.model.BookmarkEntry;
import pt.pa.model.BookmarkInvalidOperation;

import javax.swing.tree.TreeNode;
import java.awt.print.Book;
import java.util.ArrayList;

public class BookmarkManager {

    TreeLinked<BookmarkEntry> bookmarks;

    public BookmarkManager(){
        bookmarks = new TreeLinked<>(new BookmarkEntry("Bookmarks"));
    }

    private Position<BookmarkEntry> find(String key){
        for(Position<BookmarkEntry> p : bookmarks.positions()){
            if(p.element().getKey().equalsIgnoreCase(key))
                return p;
        }
        return null;
    }

    private boolean exists(String key){
        for(Position<BookmarkEntry> p : bookmarks.positions()){
            if(p.element().getKey().equalsIgnoreCase(key));
                return true;
        }
        return false;
    }

    public void addBookmarkEntry(String keyParent, String keyFolder, String url) throws BookmarkInvalidOperation {
        if(!exists(keyFolder)){
            throw new BookmarkInvalidOperation("Folder doesnt exists");
        }
        if(!exists(keyParent)){
            throw new BookmarkInvalidOperation("Parent folder doesnt exists");
        }

        BookmarkEntry newFolder = new BookmarkEntry(keyFolder, url);
        for (Position<BookmarkEntry> p : bookmarks.positions()) {
            if (p.element().getKey().equalsIgnoreCase(keyParent)) {
                bookmarks.insert(p, newFolder);
                return;
            }
        }
    }

    public void addBookmarkFolder(String keyParent, String keyFolder) throws BookmarkInvalidOperation{
        if(!exists(keyFolder)){
            throw new BookmarkInvalidOperation("Folder doesnt exists");
        }
        if(!exists(keyParent)){
            throw new BookmarkInvalidOperation("Parent folder doesnt exists");
        }

        BookmarkEntry newFolder = new BookmarkEntry(keyFolder);
        for(Position<BookmarkEntry> p : bookmarks.positions()){
            if(p.element().getKey().equalsIgnoreCase(keyParent)){
                bookmarks.insert(p, newFolder);
                return;
            }
        }
    }

    public int getTotalEntries(){
        int count = 0;

        for(BookmarkEntry bm : bookmarks.elements()){
            count++;
        }

        return count;
    }

    public int getTotalLinks(){
        int count = 0;

        for(BookmarkEntry bm : bookmarks.elements()){
            if(!bm.isFolder())
                count++;
        }

        return count;
    }

    void moveEntryToFolder(String keyEntry, String folder) throws BookmarkInvalidOperation {
        if(!exists(keyEntry)){
            throw new BookmarkInvalidOperation("Folder doesnt exists");
        }
        if(!exists(folder)){
            throw new BookmarkInvalidOperation("Parent folder doesnt exists");
        }
        if(!find(folder).element().isFolder()){
            throw new BookmarkInvalidOperation("Its not a folder");
        }

        bookmarks.move(find(keyEntry), find(folder));
    }

    String getParentFolder(String keyEntry) throws BookmarkInvalidOperation{
        String keyParent = "";

        if(!exists(keyEntry))
            throw new BookmarkInvalidOperation("KeyEntry doesnt exists");
        if(find(keyEntry).element().isFolder())
            throw new BookmarkInvalidOperation("Is a folder");

        keyEntry = bookmarks.parent(find(keyEntry)).element().getKey();

        return keyEntry;
    }




}
