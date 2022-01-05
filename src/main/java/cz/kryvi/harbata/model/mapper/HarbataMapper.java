package cz.kryvi.harbata.model.mapper;

import cz.kryvi.harbata.model.dto.HarbataDTO;
import cz.kryvi.harbata.model.entity.Harbata;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class HarbataMapper implements Function<HarbataDTO, Harbata> {
    @Override
    public Harbata apply(HarbataDTO harbataDTO) {
        return new Harbata(harbataDTO.id(), harbataDTO.name());
    }
}
