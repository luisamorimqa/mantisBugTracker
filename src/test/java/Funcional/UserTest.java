package Funcional;

import com.mantis.api.endpoints.UserEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    UserEndpoint userEndpoint = new UserEndpoint();

    @Test
    @DisplayName("POST /api/rest/users/ -> Deve adicionar um novo usuário")
    public void deveAdicionarUmNovoUsuario() {
        userEndpoint.postUser();
    }

    @Test
    @DisplayName("POST /api/rest/users/ -> Não deve conseguir adicionar um novo usuário")
    public void naoDeveConseguirAdicionarUmNovoUsuario() {
        userEndpoint.postUserWithoutAutSpec();
    }

    @Test
    @DisplayName("DELETE /api/rest/users/ -> Não deve conseguir deletar um usuário protegido")
    public void naoDeveDeletarUsuarioProtegido() {
        userEndpoint.deleteUserProtected();
    }

    @Test
    @DisplayName("DELETE /api/rest/users/ -> Deve deletar usuário não protegido")
    public void deveDeletarUsuarioNaoProtegido() {
        userEndpoint.deleteUserNonProtected();
    }
}