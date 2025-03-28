package iut.tp.annonce_spring.service;

import iut.tp.annonce_spring.dto.CreateAnnonceDto;
import iut.tp.annonce_spring.dto.UpdateAnnonceDto;
import iut.tp.annonce_spring.entity.Annonce;
import iut.tp.annonce_spring.mapper.AnnonceMapper;
import iut.tp.annonce_spring.repository.AnnonceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {this.annonceRepository = annonceRepository;}

    public List<CreateAnnonceDto> getAllAnnonces() {
        List<Annonce> annonces = annonceRepository.findAll();
        List<CreateAnnonceDto> createAnnonceDtos = annonces.stream().map(AnnonceMapper::toDto).toList();
        return createAnnonceDtos;
    }

    public Annonce getAnnonceById(Long id) {
        return this.annonceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Annonce save(CreateAnnonceDto createAnnonceDto) {
        Annonce annonce = AnnonceMapper.toEntity(createAnnonceDto);
        return annonceRepository.save(annonce);
    }

    public Annonce update(UpdateAnnonceDto updateAnnonceDto) {
        return this.annonceRepository.findById(updateAnnonceDto.getId())
                .map(annonce -> {
                    if (updateAnnonceDto.getAddress() != null) annonce.setAddress(updateAnnonceDto.getAddress());
                    if (updateAnnonceDto.getMail() != null) annonce.setMail(updateAnnonceDto.getMail());
                    if (updateAnnonceDto.getTitle() != null) annonce.setTitle(updateAnnonceDto.getTitle());
                    if (updateAnnonceDto.getDescription() != null) annonce.setDescription(updateAnnonceDto.getDescription());

                    return this.annonceRepository.save(annonce);
                })
                .orElseThrow(() -> new EntityNotFoundException("Annonce non trouvée"));
    }

    public void delete(Long id) {
        this.annonceRepository.deleteById(id);
    }

}
