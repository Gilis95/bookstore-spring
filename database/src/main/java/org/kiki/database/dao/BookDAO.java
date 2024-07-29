package org.kiki.database.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("books")
public class BookDAO {
    @Id
    @Column("id")
    private Long id;

    @Column("title")
    private String title;
    @Column("description")
    private String description;
    @Column("release_date")
    private Date releaseDate;
//    AuthorDTO author
}
