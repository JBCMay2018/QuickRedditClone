package me.afua.redditclone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String url ;
    private String title;
    private LocalDateTime submitted;
    private String image;
    private String postedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSubmitted() {
        return this.submitted;
    }

    public void setSubmitted() {
        this.submitted = LocalDateTime.now();
    }
    public void setSubmitted(LocalDateTime submitted) {
        this.submitted = submitted;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", date=" + submitted +
                '}';
    }
}
