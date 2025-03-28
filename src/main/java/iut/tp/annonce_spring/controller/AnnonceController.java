package iut.tp.annonce_spring.controller;

import iut.tp.annonce_spring.dto.CreateAnnonceDto;
import iut.tp.annonce_spring.dto.UpdateAnnonceDto;
import iut.tp.annonce_spring.entity.Annonce;
import iut.tp.annonce_spring.service.AnnonceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) { this.annonceService = annonceService; }

    @GetMapping
    public ResponseEntity<?> getAllAnnonces() {
        List<CreateAnnonceDto> annonces = this.annonceService.getAllAnnonces();
        return ResponseEntity.ok().body(annonces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnonceById(@PathVariable Long id) {
        try {
            Annonce annonce = this.annonceService.getAnnonceById(id);
            return ResponseEntity.ok().body(annonce);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody final CreateAnnonceDto createAnnonceDto) {
        try{
            Annonce annonce = this.annonceService.save(createAnnonceDto);
            return ResponseEntity.ok().body(annonce);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody final UpdateAnnonceDto updateAnnonceDto) {
        try{
            Annonce annonce = this.annonceService.update(updateAnnonceDto);
            return ResponseEntity.ok().body(annonce);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            this.annonceService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
