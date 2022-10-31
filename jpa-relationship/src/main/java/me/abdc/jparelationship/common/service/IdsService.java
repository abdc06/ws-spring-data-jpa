package me.abdc.jparelationship.common.service;

import me.abdc.jparelationship.common.entity.Ids;
import me.abdc.jparelationship.common.repository.IdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdsService {

    @Autowired
    private IdsRepository idsRepository;

    public String getNextId(String tableName) {
        Optional<Ids> ids = idsRepository.findByTableNameIgnoreCase(tableName);
        Long nextId = 1L;
        if (ids.isPresent()) {
            nextId = ids.get().getNextId();
        }
        idsRepository.save(new Ids(tableName, nextId + 1L));

        return String.format("%s_%08d", tableName, nextId);
    }
}
