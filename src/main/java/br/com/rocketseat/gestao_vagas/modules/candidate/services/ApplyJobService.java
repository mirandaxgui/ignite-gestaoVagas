package br.com.rocketseat.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseat.gestao_vagas.exceptions.JobNotFoundException;
import br.com.rocketseat.gestao_vagas.exceptions.UserNotFoundException;
import br.com.rocketseat.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.rocketseat.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import br.com.rocketseat.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import br.com.rocketseat.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobService {
  
  @Autowired
  private ApplyJobRepository applyJobRepository;

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private JobRepository jobRepository;

  public ApplyJobEntity execute(UUID idCandidate, UUID idJob){
    
    this.candidateRepository.findById(idCandidate).orElseThrow(
      () -> {
        throw new UserNotFoundException();
      });

    this.jobRepository.findById(idJob).orElseThrow(
      () -> {
        throw new JobNotFoundException();
      });
      
    var applyJob = ApplyJobEntity.builder().candidateID(idCandidate)
    .jobId(idJob).build();
    return this.applyJobRepository.save(applyJob);

  }
}
