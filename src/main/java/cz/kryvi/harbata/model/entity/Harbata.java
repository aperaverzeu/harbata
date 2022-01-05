package cz.kryvi.harbata.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "harbata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Harbata {
    @Id
    private Long id;

    private String name;
}
