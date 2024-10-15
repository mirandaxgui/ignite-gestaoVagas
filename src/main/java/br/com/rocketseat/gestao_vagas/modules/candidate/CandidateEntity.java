package br.com.rocketseat.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Schema(example="Gui Miranda", requiredMode = RequiredMode.REQUIRED, description= "Nome do candidato")
  private String name;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  @Schema(example="guimiranda", requiredMode = RequiredMode.REQUIRED, description= "username do candidato")
  private String username;

  @Schema(example="guimiranda@gmail.com", requiredMode = RequiredMode.REQUIRED, description= "Email do candidato")
  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;

  @Schema(example="admin@1234", minLength= 10, maxLength= 100, requiredMode = RequiredMode.REQUIRED, description= "Senha do candidato")
  @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
  private String password;

  @Schema(example="Desenvolvedor Junior", requiredMode = RequiredMode.REQUIRED, description= "Breve descrição do candidato")
  private String description;
  
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
