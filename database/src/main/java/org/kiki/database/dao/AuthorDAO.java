package org.kiki.database.dao;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("author")
public class AuthorDAO {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    public void copyFrom(AuthorDAO other)
    {
        name = other.name;
        birthDate = other.birthDate;
    }
}
