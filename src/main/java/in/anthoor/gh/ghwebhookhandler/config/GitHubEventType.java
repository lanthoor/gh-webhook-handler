package in.anthoor.gh.ghwebhookhandler.config;

import lombok.Getter;

import java.util.Map;

import static java.util.Map.entry;

public enum GitHubEventType {
    PING("ping"), PUSH("push"), COMMIT_COMMENT("commit_comment"), CREATE("create"), DELETE("delete"), ISSUE_COMMENT(
            "issue_comment"), ISSUES("issues"), PULL_REQUEST("pull_request"), PULL_REQUEST_REVIEW(
            "pull_request_review");

    private static final Map<String, GitHubEventType> valueMap = Map.ofEntries(entry("ping", PING), entry("push", PUSH),
            entry("commit_comment", COMMIT_COMMENT), entry("create", CREATE), entry("delete", DELETE),
            entry("issue_comment", ISSUE_COMMENT), entry("issues", ISSUES), entry("pull_request", PULL_REQUEST),
            entry("pull_request_review", PULL_REQUEST_REVIEW));

    @Getter
    private final String value;

    GitHubEventType(String value) {
        this.value = value;
    }

    public static GitHubEventType fromValue(String value) {
        return valueMap.get(value);
    }
}
