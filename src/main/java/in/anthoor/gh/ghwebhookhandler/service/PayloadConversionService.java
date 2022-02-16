package in.anthoor.gh.ghwebhookhandler.service;

import in.anthoor.gh.ghwebhookhandler.config.GitHubEventType;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHEventPayload;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;

@Slf4j
@Service
public class PayloadConversionService {

    public GHEventPayload convert(String payload, String eventHeader) throws IOException {
        return GitHub.offline()
                     .parseEventPayload(new StringReader(payload),
                             getTargetClass(GitHubEventType.fromValue(eventHeader)));
    }

    public Class<? extends GHEventPayload> getTargetClass(GitHubEventType type) {
        switch (type) {
            case PING:
                return GHEventPayload.Ping.class;
            case PUSH:
                return GHEventPayload.Push.class;
            case CREATE:
                return GHEventPayload.Create.class;
            case DELETE:
                return GHEventPayload.Delete.class;
            case ISSUES:
                return GHEventPayload.Issue.class;
            case ISSUE_COMMENT:
                return GHEventPayload.IssueComment.class;
            case PULL_REQUEST:
                return GHEventPayload.PullRequest.class;
            case PULL_REQUEST_REVIEW:
                return GHEventPayload.PullRequestReview.class;
            default:
                log.info("Unknown type: {}", type.getValue());
                return null;
        }
    }
}
