package spring_boot.read_book.exveption;

public class BookException extends Exception{
    public BookException(){};

    public BookException(String s){
        super(s);
    }
}
