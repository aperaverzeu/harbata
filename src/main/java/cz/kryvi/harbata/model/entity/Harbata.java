package cz.kryvi.harbata.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "harbata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Harbata {
    @MongoId
    private Long id;

    private String name;

    private String latinScript;

    private String description;
}
