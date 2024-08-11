package mf.group.blacklist_poc.service;

import mf.group.blacklist_poc.dto.BlacklistDto;
import mf.group.blacklist_poc.dto.BlacklistRequestBody;
import mf.group.blacklist_poc.dto.mapper.BlacklistMapper;
import mf.group.blacklist_poc.repository.BlacklistRepository;
import org.jooq.generated.public_.enums.KeysEnum;
import org.jooq.generated.public_.tables.records.BlacklistRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistService {

    private final BlacklistRepository blacklistRepository;

    public BlacklistService(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    public List<BlacklistDto> findAll() {
        List<BlacklistRecord> blacklistRecords =  blacklistRepository.findAll();

        return blacklistRecords
                .stream()
                .map(BlacklistMapper.INSTANCE::blacklistRecordToBlacklistDto)
                .toList();
    }

    public void insert(BlacklistRequestBody newBlacklist){
        List<BlacklistRecord> newRecords = List.of(BlacklistMapper.INSTANCE.blacklistRequestBodyToBlacklistRecord(newBlacklist));

        blacklistRepository.insert(newRecords);
    }

    public void delete(KeysEnum key, String value){
        blacklistRepository.deleteByKeyAndValue(key, value);
    }

//    public List<BlacklistDto> findById() {
//
//        return blacklistRepository.findAll()
//                .stream()
//                .map(record -> new BlacklistDto(
//                        record.getName(),
//                        record.getSurname(),
//                        record.getEmail()
//                        )
//                ).toList();
//    }
}
