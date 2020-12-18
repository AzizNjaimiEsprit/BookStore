package tn.esprit.BookStore.model;

import java.io.Serializable;
import java.util.Objects;

public class LibraryId implements Serializable {
    private int user;
    private int book;

	public LibraryId(){}

	public LibraryId(int user, int book) {
		this.user = user;
		this.book = book;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LibraryId libraryId = (LibraryId) o;
		return user == libraryId.user &&
				book == libraryId.book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, book);
	}
}