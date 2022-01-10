package cz.kryvi.harbata.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "harbata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Harbata {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @MongoId
    private Long id;

    private String name;

    private String latinScript;

    private String description;
}
