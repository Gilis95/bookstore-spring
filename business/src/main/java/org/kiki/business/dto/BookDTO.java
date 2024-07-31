package org.kiki.business.dto;

import java.time.LocalDate;

public record BookDTO(
        Long id,
        String title,
        String description,
        LocalDate releaseData,
        AuthorDTO author
) {
}
