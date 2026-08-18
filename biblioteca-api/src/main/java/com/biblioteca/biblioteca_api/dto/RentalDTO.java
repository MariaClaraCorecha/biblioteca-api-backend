package com.biblioteca.biblioteca_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RentalDTO {

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long customerId;

    @NotNull(message = "O ID do livro é obrigatório")
    private Long bookId;
}