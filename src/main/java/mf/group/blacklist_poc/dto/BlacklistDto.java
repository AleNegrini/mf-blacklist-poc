package mf.group.blacklist_poc.dto;

import org.jooq.generated.public_.enums.KeysEnum;

import java.time.LocalDateTime;

public record BlacklistDto(
    KeysEnum key,
    String value,
    String mfUser,
    String reason,
    LocalDateTime expiration,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
){}
