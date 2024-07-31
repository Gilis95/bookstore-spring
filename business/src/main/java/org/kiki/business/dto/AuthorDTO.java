package org.kiki.business.dto;

import java.time.LocalDate;
import java.util.List;

public record AuthorDTO(Long id, String name, LocalDate birthDate, List<BookDTO> books) {
}
