package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {

    @NotBlank(message = "O título é obrigatório")
    private String title;

    @NotBlank(message = "O autor é obrigatório")
    private String author;

    private String isbn;

    @NotNull(message = "O preço de venda é obrigatório")
    @Positive
    private BigDecimal salePrice;

    @NotNull(message = "A diária de aluguel é obrigatória")
    @Positive
    private BigDecimal rentalDailyRate;

    @NotNull
    private Integer saleStock;

    @NotNull
    private Integer rentalStock;
}