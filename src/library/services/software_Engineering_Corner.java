package library.services;

import library.Interface.central_library;

import java.util.Scanner;

import static java.lang.System.in;

public class software_Engineering_Corner implements central_library {
    String nameOfBook, author;
    int book_Id, quantity, rollNoOfStudent;
    date date;
    software_Engineering_Corner book_Storage[] = new software_Engineering_Corner[0];

    int count(int n, software_Engineering_Corner book_Storage[]) {
        int l = book_Storage.length;
        int ans = 0;
        for (int i = 0; i < l; i++) {
            if (n == book_Storage[i].book_Id) {
                ans++;
            }
        }
        return ans;
    }

    @Override
    public void book_Insert() {
        Scanner s = new Scanner(in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Name of the book = ");
            book_Storage[i].nameOfBook = s.nextLine();
            System.out.println("Name of the author = ");
            book_Storage[i].author = s.nextLine();
            System.out.println("Book Id = ");
            book_Storage[i].book_Id = s.nextInt();
            System.out.println("Quantity of the book :: " + book_Storage[i].nameOfBook + " = ");
            book_Storage[i].quantity = count(book_Storage[i].book_Id, book_Storage);
            System.out.print(book_Storage[i].quantity);
            if (book_Storage[i].quantity > 0) {
                System.out.println("the book " + book_Storage[i].nameOfBook + " is available");
            } else {
                System.out.println("the book " + book_Storage[i].nameOfBook + " is not available");
            }
        }
    }

    @Override
    public void borrow_Book() {
        Scanner s = new Scanner(in);
        System.out.println("Enter the book id = ");
        int Id = s.nextInt();

        for (int i = 0; i < 5; i++) {
            if (book_Storage[i].book_Id == Id && book_Storage[i].quantity > 0) {
                book_Storage[i].quantity--;
                System.out.println("Enter the rollNo = ");
                book_Storage[i].rollNoOfStudent = s.nextInt();
                System.out.println("successfully borrowed return after 7days");
                System.out.println("Enter the day = ");
                book_Storage[i].date.day = s.nextInt();
                System.out.println("Enter the month = ");
                book_Storage[i].date.month = s.nextInt();
                System.out.println("Enter the year = ");
                book_Storage[i].date.year = s.nextInt();
                break;
            } else {
                System.out.println("book not available");
                if (book_Storage[i].date.day <= 23) {
                    System.out.println("you can take it on " + (book_Storage[i].date.day + 7) + "/" + (book_Storage[i].date.month) + "/" + (book_Storage[i].date.year));
                } else if (book_Storage[i].date.day > 23 && book_Storage[i].date.month < 12) {
                    System.out.println("you can take it on " + (book_Storage[i].date.day + 7 - 30) + "/" + (book_Storage[i].date.month + 1) + "/" + (book_Storage[i].date.year));
                } else if (book_Storage[i].date.day > 23 && book_Storage[i].date.month == 12) {
                    System.out.println("you can take it on " + (book_Storage[i].date.day + 7 - 30) + "/" + 1 + "/" + (book_Storage[i].date.year + 1));
                }
            }
        }
    }

    class date {
        int day, month, year;
    }
}
