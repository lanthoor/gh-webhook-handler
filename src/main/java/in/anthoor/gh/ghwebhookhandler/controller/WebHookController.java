package in.anthoor.gh.ghwebhookhandler.controller;

import in.anthoor.gh.ghwebhookhandler.service.WebHookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class WebHookController {

    private WebHookService webHookService;

    @Autowired
    public void setWebHookService(WebHookService webHookService) {
        this.webHookService = webHookService;
    }

    @PostMapping(value = "/github-webhook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> receiveWebHookMessage(@RequestBody String payload, @RequestHeader HttpHeaders headers)
            throws IOException {
        webHookService.processWebHook(payload, headers);
        return ResponseEntity.ok().body("");
    }
}
