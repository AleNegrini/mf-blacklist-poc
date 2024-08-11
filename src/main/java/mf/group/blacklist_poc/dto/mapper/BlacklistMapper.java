package mf.group.blacklist_poc.dto.mapper;

import mf.group.blacklist_poc.dto.BlacklistDto;
import mf.group.blacklist_poc.dto.BlacklistRequestBody;
import org.jooq.generated.public_.tables.records.BlacklistRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlacklistMapper {
    BlacklistMapper INSTANCE = Mappers.getMapper(BlacklistMapper.class );

    BlacklistDto blacklistRecordToBlacklistDto(BlacklistRecord blacklistRecord);

    BlacklistRecord blacklistRequestBodyToBlacklistRecord(BlacklistRequestBody blacklistRequestBody);
}
