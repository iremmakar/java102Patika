package kitapSirala;

public class Book {
	
	private String bookName;
	private int sayfa;
	private String yazar;
	private String yayinTarih;
	
	
	public Book(String bookName, int sayfa, String yazar, String yayinTarih) {
		super();
		this.bookName = bookName;
		this.sayfa = sayfa;
		this.yazar = yazar;
		this.yayinTarih = yayinTarih;
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getSayfa() {
		return sayfa;
	}
	public void setSayfa(int sayfa) {
		this.sayfa = sayfa;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	public String getYayinTarih() {
		return yayinTarih;
	}
	public void setYayinTarih(String yayinTarih) {
		this.yayinTarih = yayinTarih;
	}
	
	
	
	

}
