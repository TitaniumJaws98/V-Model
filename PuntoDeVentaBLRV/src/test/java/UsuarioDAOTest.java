
import com.mycompany.puntodeventablrv.database.ConexionSQLite;
import com.mycompany.puntodeventablrv.database.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;


public class UsuarioDAOTest {
    
    private Connection conexion;
    private UsuarioDAO usuario;
    
    public UsuarioDAOTest() {
    
    }
    
    @Before
    void setUp() throws SQLException{
        
        conexion = ConexionSQLite.conectar();
        
        usuario = new UsuarioDAO(conexion);
        
    }
    
    @After
    void tearDown() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }
    
}
