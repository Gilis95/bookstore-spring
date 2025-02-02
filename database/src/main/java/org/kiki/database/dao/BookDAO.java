package org.kiki.database.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("book")
public class BookDAO {
    @Id
    @Column("id")
    private Long id;

    @Column("title")
    private String title;
    @Column("description")
    private String description;

    @Column("release_date")
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    AuthorDAO author;
}
