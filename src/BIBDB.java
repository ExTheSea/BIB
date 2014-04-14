import java.util.ArrayList;
import java.util.Iterator;


abstract class BIBDB {

	static ArrayList<Book> bookshelf = new ArrayList<Book>();
	
	static Object[] getAll(){
		Object[] arr = new Object[bookshelf.size()];
		int z = 0;
		for (Iterator<Book> i = bookshelf.iterator(); i.hasNext();) {
			Book b = i.next();
			arr[z] = b.listAll();
			z++;
		}
		return arr;
	}
	
//	bookshelf.add(new Object[]{"1","Die Blutlinie",  "Cody McFadyen", "Lübek", "2008", "Mosbach", "n"});
//	bookshelf.add(new Object[]{"2","Der Menschenmacher",  "Cody McFadyen", "Lübek", "2010", "Mosbach", "n"});
//	bookshelf.add(new Object[]{"3","Ausgelöscht",  "Cody McFadyen", "Lübek", "2012", "Mosbach", "j"});
//	bookshelf.add(new Object[]{"4","Das Böse in Uns",  "Cody McFadyen", "Lübek", "2013", "Mosbach", "n"});
//	bookshelf.add(new Object[]{"5","Java for Hillbillies",  "Marius Reinwald", "Mosbach", "2014", "Mosbach", "n"});
	
	static void createsample(){
		bookshelf.add(new Book("Die Blutlinie",  "Cody McFadyen", "Lübek", "2008", "Mosbach", false));
		bookshelf.add(new Book("Der Menschenmacher",  "Cody McFadyen", "Lübek", "2010", "Mosbach", false));
		bookshelf.add(new Book("Ausgelöscht",  "Cody McFadyen", "Lübek", "2012", "Mosbach", true));
		bookshelf.add(new Book("Das Böse in Uns",  "Cody McFadyen", "Lübek", "2013", "Mosbach", false));
		bookshelf.add(new Book("Java for Hillbillies",  "Marius Reinwald", "Mosbach", "2014", "Mosbach", false));
	}
	
	static Object[] getNotLend(){
		Object[] arr = new Object[bookshelf.size()];
		int z = 0;
		for (Iterator<Book> i = bookshelf.iterator(); i.hasNext();) {
			Book b = i.next();
			if(!b.isLend()){
				arr[z] = b.listAll();
				z++;
			}
		}
		return arr;
	}
	
	static Object[][] getLend(){
		Object[][] arr = new Object[bookshelf.size()][7];
		int z = 0;
		for (Iterator<Book> i = bookshelf.iterator(); i.hasNext();) {
			Book b = i.next();
			if(b.isLend()){
				arr[z] = b.listAll();
				z++;
			}
		}
		return arr;
	}
	
	static class Book {
		private String Author;
		private String Title;
		private String Year;
		private String Publisher;
		private String Location;
		private boolean Lend;
		static int counter = 0;
		private int ID;
		
		public boolean isLend() {
			return Lend;
		}
		public void setLend(boolean Lend) {
			this.Lend = Lend;
		}
		public String getAuthor() {
			return Author;
		}
		public void setAuthor(String author) {
			Author = author;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getYear() {
			return Year;
		}
		public void setYear(String year) {
			Year = year;
		}
		public String getPublisher() {
			return Publisher;
		}
		public void setPublisher(String publisher) {
			Publisher = publisher;
		}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			Location = location;
		}
		
		public Book(String Author, String Title, String Year, String Publisher, String Location, boolean Lend) {
			this.ID = counter;
			counter ++;
			this.Author = Author;
			this.Title = Title;
			this.Year = Year;
			this.Publisher = Publisher;
			this.Location = Location;
			this.Lend = Lend;
		}
		
		public Object[] listAll(){
			return new Object[] {this.ID, this.Author, this.Title, this.Year, this.Publisher, this.Location, this.Lend};
		}
	}
}
