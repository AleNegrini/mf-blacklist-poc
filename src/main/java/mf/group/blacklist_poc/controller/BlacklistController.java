package mf.group.blacklist_poc.controller;

import ch.qos.logback.core.pattern.color.BlackCompositeConverter;
import mf.group.blacklist_poc.dto.BlacklistDto;
import mf.group.blacklist_poc.dto.BlacklistRequestBody;
import mf.group.blacklist_poc.repository.BlacklistRepository;
import mf.group.blacklist_poc.service.BlacklistService;
import org.jooq.generated.public_.enums.KeysEnum;
import org.jooq.generated.public_.tables.records.BlacklistRecord;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlacklistController {

    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @GetMapping("/")
    public List<BlacklistDto> getAll(){
        return blacklistService.findAll();
    }

    @PostMapping("/")
    public void create(@RequestBody BlacklistRequestBody blacklistRequestBody) {
        blacklistService.insert(blacklistRequestBody);
    }

    @DeleteMapping("/")
    public void create(@RequestParam KeysEnum key, @RequestParam String value) {
        blacklistService.delete(key, value);
    }
}
