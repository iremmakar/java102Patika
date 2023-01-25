package kitapSirala;

import java.util.Comparator;

public class OrderKitapNameComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getBookName().compareTo(o2.getBookName());
	}

}
