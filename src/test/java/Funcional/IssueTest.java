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
    @DisplayName("POST /api/rest/issues -> Deve criar uma issue")
    public void postIssue() {
        issueEndpoint.postIssue();
    }

    @Test
    @DisplayName("POST /api/rest/issues -> Não deve conseguir adicionar uma nova issue")
    public void naoDeveAdicionarIssue() {
        issueEndpoint.postIssueWithoutAuth();
    }

    @Test
    @DisplayName("GET /api/rest/issues -> Deve retornar todas as issues cadastradas")
    public void getAllIssue() {
        issueEndpoint.getAllIssues();
    }

    @Test
    @DisplayName("GET /api/rest/issues -> Deve retornar uma issue cadastrada")
    public void getAnIssue() {
        issueEndpoint.getAnIssue();
    }

    @Test
    @DisplayName("PATCH /api/rest/issues -> Deve alterar uma issue existente")
    public void patchIssue() {
        issueEndpoint.patchIssue();
    }

    @Test
    @DisplayName("DELETE /api/rest/issues -> Deve deletar uma issue")
    public void deleteAnIssue() {
        issueEndpoint.deleteAnIssue();
    }
}