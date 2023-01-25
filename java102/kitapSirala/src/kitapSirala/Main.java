package kitapSirala;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		TreeSet<Book> books = new TreeSet<>(new OrderSayfaComparator());
		
		books.add(new Book("x",256,"x","2023"));
		books.add(new Book("y",222,"x","2022"));
		books.add(new Book("z",232,"x","2021"));
		books.add(new Book("t",242,"x","2020"));
		books.add(new Book("v",252,"x","2019"));

		
		for(Book s : books) {
			System.out.println(s.getSayfa());
		}
		
		
		TreeSet<Book> books2 = new TreeSet<>(new OrderKitapNameComparator());
		
		books2.add(new Book("x",256,"x","2023"));
		books2.add(new Book("y",222,"x","2022"));
		books2.add(new Book("z",232,"x","2021"));
		books2.add(new Book("t",242,"x","2020"));
		books2.add(new Book("v",252,"x","2019"));
		
		
		for(Book s : books) {
			System.out.println(s.getBookName());
		}
		

	}

}
