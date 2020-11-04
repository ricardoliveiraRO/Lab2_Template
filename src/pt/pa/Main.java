/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.pa;

import pt.pa.adts.BookmarkManager;
import pt.pa.model.BookmarkInvalidOperation;

/**
 *
 * @author brunomnsilva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //take comments when BookmarkManager is implemented
        try {
            BookmarkManager manager = new BookmarkManager();
            
            manager.addBookmarkFolder("bookmarks", "Jornais");
            manager.addBookmarkFolder("jornais", "Finanças");
            manager.addBookmarkFolder("bookmarks", "Redes Sociais");
            manager.addBookmarkFolder("bookmarks", "Diversos");
            
            manager.addBookmarkEntry("jornais", "Publico", "http://www.publico.pt");
            manager.addBookmarkEntry("jornais", "Expresso", "http://www.expresso.pt");
            manager.addBookmarkEntry("finanças", "Diário Económico", "http://economico.sapo.pt/");
            
            manager.addBookmarkEntry("redes sociais", "Facebook", "http://www.facebook.com");
            manager.addBookmarkEntry("redes sociais", "Instagram", "http://www.instagram.com");
            
            manager.addBookmarkEntry("diversos", "Gmail", "http://www.gmail.com");
            manager.addBookmarkEntry("diversos", "StackOverflow", "http://www.stackoverflow.com");
            
            manager.addBookmarkEntry("bookmarks", "IPS", "http://www.ips.pt");

            manager.addBookmarkFolder("jornais", "desportivos");
            manager.addBookmarkEntry("desportivos", "abola", "http://www.abola.pt");
            manager.addBookmarkEntry("desportivos", "record", "http://www.record.xl.pt");

            System.out.println(manager);

            System.exit(0);

        } catch (BookmarkInvalidOperation exception) {
            System.err.println(exception.getMessage());
        }
    }
    
}
