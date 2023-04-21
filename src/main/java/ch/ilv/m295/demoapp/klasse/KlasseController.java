package ch.ilv.m295.demoapp.klasse;

import ch.ilv.m295.demoapp.base.MessageResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SecurityRequirement(name = "bearerAuth")
@Validated
@RestController
public class KlasseController {

    private final KlasseService klasseService;

    public KlasseController(KlasseService klasseService){
        this.klasseService = klasseService;
    }

    @GetMapping("api/klasse")
        public ResponseEntity<List<Klasse>> all() {
        List<Klasse> result = klasseService.getKlasses();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/klasse/{id}")
    public ResponseEntity<Klasse> one(@PathVariable Long id) {
        Klasse klasse = klasseService.getKlasse(id);
        return new ResponseEntity<>(klasse, HttpStatus.OK);
    }

    @PostMapping("api/klasse")
    public ResponseEntity<Klasse> newDepartment(@Valid @RequestBody Klasse klasse) {
       Klasse savedKlasse = klasseService.insertKlasse(klasse);
        return new ResponseEntity<>(savedKlasse, HttpStatus.OK);
    }

    @PutMapping("api/klasse/{id}")
    public ResponseEntity<Klasse> updateDepartment(@Valid @RequestBody Klasse klasse, @PathVariable Long id) {
        Klasse savedKlasse = klasseService.updateKlasse(klasse, id);
        return new ResponseEntity<>(savedKlasse, HttpStatus.OK);
    }


    @DeleteMapping("api/klasse/{id}")
        public ResponseEntity<MessageResponse> deleteKlasse(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(klasseService.deleteKlasse(id));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
