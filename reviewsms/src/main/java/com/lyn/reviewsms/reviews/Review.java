package com.lyn.reviewsms.reviews;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date createdDate;
    private Date lastModification;
    private String author;
    private Long companyId;

    public Review() {
    }

    public Review(Long id, String text, Date createdDate, Date lastModification, String author) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.lastModification = lastModification;
        this.author = author;

    }

    public Review(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public void update(Review updateReview) {
        this.text = text;
        this.lastModification = updateReview.lastModification;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
