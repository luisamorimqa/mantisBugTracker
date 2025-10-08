package Funcional;

import com.mantis.api.endpoints.IssueEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueTest {

    IssueEndpoint issueEndpoint = new IssueEndpoint();

    @Test
    @DisplayName("POST /api/rest/issues -> Deve criar uma issue (minimal)")
    public void postMinimalIssue() {
        issueEndpoint.postMinimalIssue();
    }

    @Test
    @DisplayName("GET /api/rest/issues -> Deve retornar todas as issues cadastradas")
    public void getAllIssue() {
        issueEndpoint.getAllIssues();
    }

}