package org.kiki.business.dto;

import java.util.Date;
import java.util.List;

public record AuthorDTO(String name, Date birthDate, List<BookDTO> books) {
}
