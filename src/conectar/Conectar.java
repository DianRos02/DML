package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {

    public static void main(String[] args) throws Exception {
        //List<clientes> clientes=new ArrayList<>();
        //int id = 13;
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comercio", "root", "");
        //String q="SELECT *FROM clientes";
        //para traer datos de un solo cliente
        //String q = "SELECT *FROM clientes where id_cliente=?";
        //PreparedStatement ps = c.prepareStatement(q);
        //getById(ps, 1);
        //getById(ps, 2);
        //Statement stm= c.createStatement();
        //ResultSet rs= stm.executeQuery(q);

        /*while(rs.next()){
           int id_cliente=rs.getInt("id_cliente");
          String nombre=rs.getString("nombre");
          String apellido=rs.getString("apellido");
          System.out.println(id_cliente + " " + nombre + " " + apellido);
          //clientes.add(new clientes(id_cliente,nombre,apellido); */
        PreparedStatement psi=c.prepareStatement("insert into clientes(nombre,apellido,dni) values (?,?,?)");
        insert(psi,"Juan","Lopez",103);
        insert(psi,"Diego","Ramos",174);
        
        
        PreparedStatement psa=c.prepareStatement("update clientes set nombre=?, apellido=? where id_cliente =?");
        update(psa,"Hector","Gomez",2);
        update(psa,"Jorge","Rodas",1);
        
         PreparedStatement p=c.prepareStatement("delete from clientes where id_cliente =?");
        delete(p,7);
       
        
        
         
    }
    private static void insert(PreparedStatement ps,String nombre, String apellido,int dni) throws Exception{
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setInt(3, dni);
        ps.execute();
            
    }
    private static void update(PreparedStatement psa, String nombre, String apellido,int id) throws Exception{
        psa.setString(1, nombre);
        psa.setString(2, apellido);
        psa.setInt(3, id);
        psa.execute();
        
    }
    private static void delete(PreparedStatement p,int id) throws Exception{
        p.setInt(1, id);
        p.execute();
        
        
        
    }
    
  /*public static void getById(PreparedStatement ps, int id) throws Exception {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));

        }
    }*/
    //return clientes;
   
}