package org.kiki.business.service;

import org.kiki.business.dto.AuthorDTO;
import org.kiki.business.dto.BookDTO;
import org.kiki.database.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAll() {
        var result = new ArrayList<BookDTO>();
        result.add(new BookDTO(
                "От другата страна"
                ,"Животът на патологичния лъжец Мартин се преобръща на сто и осемдесет градуса, когато всичко рязко му е отнето от родителите му. Той ще направи и невъзможното да си възвърне досегашния статут."
                , new Date(2022, Calendar.APRIL,1)
                , new AuthorDTO(
                        "Димитър Калбуров"
                        ,new Date()
                        ,null)));
        return result;
    }
}
