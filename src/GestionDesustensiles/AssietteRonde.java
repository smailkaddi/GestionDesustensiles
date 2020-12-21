package GestionDesustensiles;


import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AssietteRonde extends Assiette{
	
	Conection con = new Conection();

	private int id;
	private double rayon;
	
	public AssietteRonde() {}
	public AssietteRonde(int Id,double Rayon,int Anne_de_fabrication) {
		super (Anne_de_fabrication);
		this.id = Id;
		this.rayon = Rayon;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRayon() {
		return rayon;
	}
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t Rayon    : " + this.rayon ;
	}
	
	
	//insert
	public void create_data(double rayon,int anne_de_fabrication) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query="INSERT INTO `assietteronde`(`rayon` , `anne_de_fabrication`) VALUES (?,?)";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, rayon);
			ps.setDouble(2, anne_de_fabrication);
			ps.executeUpdate();
			System.out.println(" \n AssietteRonde Ajoute Avec Succes ");
		}catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//select
	public void read_data() throws SQLException {
		//First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		
		
		con.rs = con.stat.executeQuery("SELECT COUNT(*) As total FROM assietteronde ;");
		while(con.rs.next()) {
			System.out.println(" -------> total:  " + "\t" +con.rs.getInt("total") );
		}
		
		con.rs = con.stat.executeQuery("SELECT * FROM `assietteronde`");
		while(con.rs.next()) {
			System.out.println(" -------> ID:  " + "\t" +con.rs.getInt("id") + "\n \t Rayon: " + con.rs.getDouble("rayon") + " \n \t Anne De Fabrication: " + con.rs.getInt("anne_de_fabrication"));
		}
	}
	

	//Methode 1 for update
	//update
	public void update_data(int id ,double rayon ,int anne_de_fabrication) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE `assietteronde` SET `rayon`=?,`anne_de_fabrication`=? WHERE `id`=?";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, rayon);
			ps.setInt(2, anne_de_fabrication);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");

			
		}catch (Exception e){
			
		}
	}
	
	
	
}
