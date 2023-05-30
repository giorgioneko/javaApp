package Udemy;

import java.util.UUID;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Arrays;
public class Book {
	
  private int id = UUID.randomUUID().hashCode();
  private String Name;
  private Author[] authors;
  private Publisher publisher;
  private int publishingyear;
  private int amountOfPages;
  private BigDecimal price;
  private CoverType coverType;
  
  public Book(int id, String Name, Author[] authors, Publisher publisher,
			int publishingyear, int amountOfPages, BigDecimal price,
			CoverType coverType){
      this.id = id;
      this.Name = Name;
		this.authors = authors;
		this.publisher = publisher;
		this.publishingyear = publishingyear;
		this.amountOfPages = amountOfPages;
		this.price = price;
		this.coverType = coverType;
  }
  
  	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getPublishingYear() {
		return publishingyear;
	}

	public void setPublishingYear(int publishingyear) {
		this.publishingyear = publishingyear;
	}

	public int getAmountOfPages() {
		return amountOfPages;
	}

	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CoverType getCoverType() {
		return coverType;
	}

	public void setCoverType(CoverType coverType) {
		this.coverType = coverType;
	}
  
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + Objects.hash(amountOfPages, coverType, id, Name, price,
				publisher, publishingyear);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return amountOfPages == other.amountOfPages
				&& Arrays.equals(authors, other.authors) && coverType == other.coverType
				&& id == other.id && Objects.equals(Name, other.Name)
				&& Objects.equals(price, other.price)
				&& Objects.equals(publisher, other.publisher)
				&& publishingyear == other.publishingyear;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + Name + ", authors="
				+ Arrays.toString(authors) + ", publisher=" + publisher
				+ ", publishingYear=" + publishingyear + ", amountOfPages="
				+ amountOfPages + ", price=" + price + ", coverType=" + coverType + "]";
	}
	
	public boolean hasAuthor(Author authorCriteria) {
		for (Author author : authors) {
			return author.equals(authorCriteria); 
		}
		
		return false;
	        
	    
  

}
}