package iut.tp.annonce_spring.dto;

import lombok.Data;

@Data
public class UpdateAnnonceDto {
    private Long id;
    private String title;
    private String description;
    private String address;
    private String mail;
}
