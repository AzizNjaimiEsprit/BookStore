package tn.esprit.BookStore.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Library implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name="book_id", nullable=false)
	private OnlineBook book;
	@Column(name="status")
    private String status="Recently added";
	@Column(name="page_reached")
    private int reachedPage=0;
	@Column(name="quiz_score")
    private int quizScore=0;

	public Library() {

	}

	public Library(User user, OnlineBook book, String status, int reachedPage, int quizScore) {
		this.user = user;
		this.book = book;
		this.status = status;
		this.reachedPage = reachedPage;
		this.quizScore = quizScore;
	}


	public Library(OnlineBook book, String status, int reachedPage, int quizScore) {
		this.book = book;
		this.status = status;
		this.reachedPage = reachedPage;
		this.quizScore = quizScore;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public OnlineBook getBook() {
		return book;
	}


	public void setBook(OnlineBook book) {
		this.book = book;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getReachedPage() {
		return reachedPage;
	}


	public void setReachedPage(int reachedPage) {
		this.reachedPage = reachedPage;
	}


	public int getQuizScore() {
		return quizScore;
	}


	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Library other = (Library) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Library{" +
				"user=" + user +
				", book=" + book +
				", status='" + status + '\'' +
				", reachedPage=" + reachedPage +
				", quizScore=" + quizScore +
				'}';
	}
}
