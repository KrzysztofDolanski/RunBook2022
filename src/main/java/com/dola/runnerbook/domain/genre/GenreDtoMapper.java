package com.dola.runnerbook.domain.genre;

import com.dola.runnerbook.domain.genre.Genre;
import com.dola.runnerbook.domain.genre.dto.GenreDTO;

public class GenreDtoMapper {

    static GenreDTO mapToDto(Genre genre){
        return new GenreDTO(genre.getId(), genre.getName(), genre.getDescription());
    }
}
