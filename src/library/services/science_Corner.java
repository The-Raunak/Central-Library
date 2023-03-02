package library.services;

import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.in;

public class science_Corner implements central_library{
    String nameOfBook;
    String author;
    int book_Id;
    int quantity;
    int rollNoOfStudent;

    int count(int n,science_Corner book_Storage[]) {
        int l = book_Storage.length;
        int ans = 0;
        for(int i = 0;i<l;i++){
            if(n == book_Storage[i].book_Id){
                ans++;
            }
        }
        return ans;
    }
    @Override
    public void book_Insert() {
        science_Corner book_Storage[] = new science_Corner[0];
        Scanner s = new Scanner(in);
        for(int i = 0;i<10;i++) {
            System.out.println("Name of the book = ");
            book_Storage[i].nameOfBook = s.nextLine();
            System.out.println("Name of the author = ");
            book_Storage[i].author = s.nextLine();
            System.out.println("Book Id = ");
            book_Storage[i].book_Id = s.nextInt();
            System.out.println("Quantity of the book :: " + book_Storage[i].nameOfBook + " = ");
            book_Storage[i].quantity = count(book_Storage[i].book_Id,book_Storage);
            System.out.print(book_Storage[i].quantity);
            if(book_Storage[i].quantity != 0) {
                System.out.println("the book " + book_Storage[i].nameOfBook + " is available");
            }
            else{
                System.out.println("the book " + book_Storage[i].nameOfBook + " is not available");
            }
        }
    }

    @Override
    public void borrow_Book() {

    }
}
