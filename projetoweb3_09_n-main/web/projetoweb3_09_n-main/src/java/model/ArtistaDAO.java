
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistaDAO {
    private static Connection conn;
    
    public ArtistaDAO() throws ClassNotFoundException, SQLException {
        conn = MyDatabase.getDatabase();
    }
    
    //****Métodos do CRUD****
    //INSERT (Create)
    public void insertArtista(Artista a) throws SQLException{
        //Criando a query para inserir o registro
        String query = "INSERT INTO artistas(nome, cod_genero, nacionalidade, solo)"
                + "VALUES(?,?,?,?)";
        
        //Preparar a query para ser executada no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, a.getArtista());
        prep.setInt(2, a.getGenero());
        prep.setString(3, a.getNacionalidade());
        prep.setInt(4, a.getSolo());
        
        //Executando a query pronta
        prep.execute();
        prep.close();
    }
    
    //SELECT
    public ArrayList<Artista>listAll() throws SQLException{
        //CRIAR LISTA VAZIA
        ArrayList<Artista> list = new ArrayList<>();
        
        //CRIAR QUERY PARA PESQUISA NO DB
        String query = "SELECT * FROM artistas";
        
        //PREPARAR QUERY PARA EXECUTAR NO DB 
        PreparedStatement prep = conn.prepareStatement(query);
        
            //PEGAR O RESULTADO DA PESQUISA DB
            ResultSet res = prep.executeQuery();
            
            //VARRER "res" MAPEANDO OS REGISTROS DO DB
            //PARAOBJETOS DA CLASSE "Artista"
            while(res.next() ){
              //CRIAR OBJETO ARTISTA VAZIO
              Artista art =  new Artista ();
              
              //INSERIR OS VALORES NOS ATRIBUTOS COM
              //OS DADOS VINDOS DAS COLUNAS DB
              art.setIdArtista(res.getInt("cod_artista"));
              art.setArtista(res.getString("nome"));
              art.setGenero(res.getInt("cod_genero"));
              art.setNacionalidade(res.getString("nacionalidade"));
              art.setSolo(res.getInt("solo"));
              
              //INSERIR O OBJETO COMPLETO NA LISTA 
                list.add(art);
        }
        
        //RETORNAR LISTA CHEIA 
        return list; 
    }
    
    //SELECT
    public Artista listById( int i  ) throws SQLException{
         String query =" SELECT * FROM artistas WHERE id_artista =  "+1;
         PreparedStatement prep = conn.prepareStatement(query);
         ResultSet res = prep.executeQuery( );
         
         Artista art  = new Artista( );
         
         if(res.next( )) {
             art.setIdArtista(res.getInt("cod_artista"));
              art.setArtista(res.getString("nome"));
              art.setGenero(res.getInt("cod_genero"));
              art.setNacionalidade(res.getString("nacionalidade"));
              art.setSolo(res.getInt("solo"));
         }
         return art;
    }
    
    //UPTADE
    public void updateArtista(Artista art) throws SQLException{
        String query =  "UPDATE artistas SET nome = ?," 
                + " cod_genero =  ?,  , nacionalidade = ?,"
               +"solo =  ? WHERE cod_artista = ? ";
        
           PreparedStatement prep = conn.prepareStatement(query);
           prep.setString(1, query);
           prep.setString(2, query);
           prep.setString(3, query);
           prep.setString(4, query);
           prep.setString(5, query);
           
    }
 
}//FIM DA CLASSE
