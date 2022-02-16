package in.anthoor.gh.ghwebhookhandler.service;

import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHEventPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class WebHookService {

    private PayloadConversionService payloadConversionService;

    @Autowired
    public void setPayloadConversionService(PayloadConversionService payloadConversionService) {
        this.payloadConversionService = payloadConversionService;
    }

    @Async
    public void processWebHook(String payload, HttpHeaders headers) throws IOException {
        log.info("Processing async");
        GHEventPayload eventPayload = payloadConversionService.convert(payload, headers.get("X-GitHub-Event").get(0));
        log.info("Repository: {}", eventPayload.getRepository().getFullName());
        log.info("Processing complete");
    }
}
