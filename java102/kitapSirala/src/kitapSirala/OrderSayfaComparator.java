package kitapSirala;

import java.util.Comparator;

public class OrderSayfaComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getSayfa()-o2.getSayfa();
	}

	

}
