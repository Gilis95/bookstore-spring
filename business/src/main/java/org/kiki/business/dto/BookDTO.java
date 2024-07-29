package org.kiki.business.dto;

import java.util.Date;

public record BookDTO (
     String title,
     String description,
     Date releaseData,
     AuthorDTO author
){
}
