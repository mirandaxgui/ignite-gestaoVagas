package br.com.rocketseat.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    @Schema(example="guigui")
    private String username;
    @Schema(example="Guilherme Miranda")
    private String name;
    @Schema(example="gui@gmail.com")
    private String email;
    private UUID id;
    @Schema(example="Desenvolvedor Java Junior")
    private String description;

}
