package GestionDesustensiles;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Ustensile {
	
	Conection con = new Conection();
	
	private int id;
	private int anne_de_fabrication;
	

	public Ustensile(int Id,int Anne_de_fabrication){
		this.id = Id;
		this.anne_de_fabrication = Anne_de_fabrication;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnne_de_fabrication() {
		return anne_de_fabrication;
	}
	public void setAnne_de_fabrication(int anne_de_fabrication) {
		this.anne_de_fabrication = anne_de_fabrication;
	}
	
	@Override
	public String toString() {
		return  "\n \t ---------------- \n \t Anne de Fabrication    : " + this.anne_de_fabrication ;
	}
	
	public Ustensile(){
		
	}
	

	
	public void afficherValeurTotale(int choix) throws SQLException {
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);
		int yearUstentile = 0;
		int Calculvaut = 0;
		int vaut = 0;
		
		
		if(choix == 1 ) {
			//SELECT anne_de_fabrication FROM cuillere 
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM cuillere");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					vaut = vaut + (Calculvaut - 50);
				}
			}
			System.out.println(" -------> Valeur Totale De Cuillere:  " + "\t" + vaut + "DH");
		}else if(choix == 2) {
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM assietteronde");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					vaut = vaut + (Calculvaut - 50);
				}
			}
			System.out.println(" -------> Valeur Totale De AssietteRonde:  " + "\t" + vaut + "DH");
		}else if(choix == 3) {
			con.Connect();
			con.stat = con.conn.createStatement();
			con.rs = con.stat.executeQuery("SELECT anne_de_fabrication FROM assiettecarree");
			
			while(con.rs.next()) {
				yearUstentile = con.rs.getInt("anne_de_fabrication");
				Calculvaut = yearNow - yearUstentile;
				if (Calculvaut > 50) {
					//vaut2 =  (Calculvaut - 50) * 5;
					vaut = vaut + ((Calculvaut - 50) * 5);
				}
			}
			System.out.println(" -------> Valeur Totale De AssietteCarree:  " + "\t" + vaut + "DH");
		}
	}
	
	
	//Methode 2 for update
	//update
	public void update_global_data(int id ,double rayonORcoteORlongeur ,int anne_de_fabrication ,int choix) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		try {
			String query ="";
			String messagesucces ="";
			if (choix == 1) {
				//assietteronde
				query = "UPDATE `assietteronde` SET `rayon`=?,`anne_de_fabrication`=? WHERE `id`=?";
				messagesucces =" \t modification assietteronde avec succes";
			}else if (choix == 2) {
				//assiettecarree
				query = "UPDATE `assiettecarree` SET `cote`=?,`anne_de_fabrication`=? WHERE `id`=?";
				messagesucces =" \t modification assiettecarree avec succes";
			}else if (choix == 3) {
				//cuillere
				query = "UPDATE `cuillere` SET `longeur`=?,`anne_de_fabrication`=? WHERE `id`=?";
				messagesucces =" \t modification cuillere avec succes";
			}
			//String query = "UPDATE `assietteronde` SET `rayon`=?,`anne_de_fabrication`=? WHERE `id`=?";
			ps=con.conn.prepareStatement(query);
			ps.setDouble(1, rayonORcoteORlongeur);
			ps.setInt(2, anne_de_fabrication);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println(messagesucces);
		}catch (Exception e){
			
		}
	}
}
