package tn.esprit.BookStore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Library implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private User user;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(255) default Recently_added")
	private Status status;

	@Column(name="page_reached",columnDefinition = "integer default 0")
    private int reachedPage;

	@OneToOne
	@JoinColumn(name = "online_book_id")
	private OnlineBook onlineBook;

	public Library() {

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getReachedPage() {
		return reachedPage;
	}

	public void setReachedPage(int reachedPage) {
		this.reachedPage = reachedPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OnlineBook getOnlineBook() {
		return onlineBook;
	}

	public void setOnlineBook(OnlineBook onlineBook) {
		this.onlineBook = onlineBook;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Library library = (Library) o;
		return id == library.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Library{" +
				"id=" + id +
				", onlineBook=" + onlineBook +
				", user=" + user +
				", status=" + status +
				", reachedPage=" + reachedPage +
				'}';
	}
}
