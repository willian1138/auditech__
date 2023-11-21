package fbw.auditech.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Palavras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    List<String> primeiroNivel = List.of("gato", "passaro", "cobra");
    List<String> segundoNivel = List.of("ornitorinco", "arvore", "onomatopeia");
    List<String> terceiroNivel = List.of("esparadrapofobia", "obscuro", "gótico");
    List<String> quartoNivel = List.of("desoxirribonucleico", "pepita", "teatro");
    
}
