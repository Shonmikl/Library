package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Reviews")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "reviewer_name")
    private String reviewerName;

    @Column(name = "review_date")
    private Date reviewDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId
                && Objects.equals(reviewText, review.reviewText)
                && Objects.equals(reviewerName, review.reviewerName)
                && Objects.equals(reviewDate, review.reviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                reviewId,
                reviewText,
                reviewerName,
                reviewDate);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewText='" + reviewText + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", reviewDate=" + reviewDate +
                ", book=" + book +
                '}';
    }
}