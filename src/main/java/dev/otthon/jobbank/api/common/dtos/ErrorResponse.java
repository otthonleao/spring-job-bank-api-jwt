package dev.otthon.jobbank.api.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;

    @Builder.Default // O Builder sempre inicia com valor NULL, então essa anotação faz com que ele inicie com o valor atribuido
    private LocalDateTime timestamp = LocalDateTime.now();

}
