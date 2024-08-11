package mf.group.blacklist_poc.repository;

import org.jooq.DSLContext;
import org.jooq.Rows;
import org.jooq.generated.public_.enums.KeysEnum;
import org.jooq.generated.public_.tables.Blacklist;
import org.jooq.generated.public_.tables.records.BlacklistRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlacklistRepository {

    private final DSLContext dslContext;
    private final Blacklist tableName = Blacklist.BLACKLIST;

    public BlacklistRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<BlacklistRecord> findAll() {
        return dslContext.selectFrom(tableName).fetch();
    }

    public void insert(List<BlacklistRecord> blacklistRecords) {
        dslContext.insertInto(tableName).set(blacklistRecords).execute();
    }

    public void deleteByKeyAndValue(KeysEnum key, String value) {
        dslContext
            .deleteFrom(tableName)
            .where(tableName.KEY.eq(key))
            .and(tableName.VALUE.eq(value))
            .execute();
    }

}
