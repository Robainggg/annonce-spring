package iut.tp.annonce_spring.mapper;

import iut.tp.annonce_spring.dto.CreateAnnonceDto;
import iut.tp.annonce_spring.dto.UpdateAnnonceDto;
import iut.tp.annonce_spring.entity.Annonce;

public class AnnonceMapper {

    public static Annonce toEntity(CreateAnnonceDto createAnnonceDto){
        Annonce annonce = new Annonce();
        annonce.setTitle(createAnnonceDto.getTitle());
        annonce.setDescription(createAnnonceDto.getDescription());
        annonce.setAddress(createAnnonceDto.getAddress());
        annonce.setMail(createAnnonceDto.getMail());
        return annonce;
    }

    public static CreateAnnonceDto toDto(Annonce annonce){
        CreateAnnonceDto createAnnonceDto = new CreateAnnonceDto();
        createAnnonceDto.setTitle(annonce.getTitle());
        createAnnonceDto.setDescription(annonce.getDescription());
        createAnnonceDto.setAddress(annonce.getAddress());
        createAnnonceDto.setMail(annonce.getMail());
        return createAnnonceDto;
    }

    public static Annonce toEntity(UpdateAnnonceDto updateAnnonceDto){
        Annonce annonce = new Annonce();
        annonce.setId(updateAnnonceDto.getId());
        annonce.setTitle(updateAnnonceDto.getTitle());
        annonce.setDescription(updateAnnonceDto.getDescription());
        annonce.setAddress(updateAnnonceDto.getAddress());
        annonce.setMail(updateAnnonceDto.getMail());
        return annonce;
    }
}
