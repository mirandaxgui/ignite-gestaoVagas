package br.com.rocketseat.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.gestao_vagas.exceptions.UserNotFoundException;
import br.com.rocketseat.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.rocketseat.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .email(candidate.getEmail())
                .username(candidate.getUsername())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
        return candidateDTO;
    }

}
