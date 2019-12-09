package fr.isty.iatic5.sessions.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.isty.iatic5.archilog.sessions.config.SqlUtils;

/************************************************************/
/**
 * 
 */
//@Service
public class Classe{
	public Classe() {
		super();
	}

	/**
	 * 
	 */
	// test commit

	private String id;
	/**
	 * 
	 */
	private int promotion;
	/**
	 * 
	 */
	private String filiere;
	/**
	 * 
	 */
	public Personne[] personne;

	/**
	 * 
	 * @param id
	 * @param promotion
	 * @param filiere
	 */
	public Classe(String id, int promotion, String filiere) {
		this.id = id;
		this.promotion = promotion;
		this.filiere = filiere;
	}

	public void save() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("INSERT INTO CLASSE VALUES('%s',%s,'%s')", this.id,
				String.valueOf(this.promotion), this.filiere));
		SqlUtils.disconnect();
	}

	public void update() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("UPDATE CLASSE SET promotion=%s,filiere='%s' WHERE id='%s'",
				String.valueOf(this.promotion), this.filiere, this.id));
		SqlUtils.disconnect();
	}

	public void delete() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("DELETE FROM CLASSE WHERE id='%s'", this.id));
		SqlUtils.disconnect();

	}

	public static Classe getById(String id) {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM CLASSE WHERE id='%s'", id));
		

		try {
			Classe classe = new Classe(set.getString("id"), set.getInt("promotion"), set.getString("filiere"));
			SqlUtils.disconnect();
			return classe;
		} catch (SQLException e) {
			e.printStackTrace();
			SqlUtils.disconnect();
			return null;
		}
		
	}

	@Override
	public String toString() {
		return "" + id + " ; " + promotion + " ; " + filiere + " \n";
	}

	public static List<Classe> getAll() {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM CLASSE "));
	
		List<Classe> result = new ArrayList<Classe>();

		try {
			while (set.next()) {
				Classe classe = new Classe(set.getString("id"), set.getInt("promotion"), set.getString("filiere"));
				result.add(classe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			SqlUtils.disconnect();
			return null;
		}
		SqlUtils.disconnect();
		return result;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public Personne[] getPersonne() {
		return personne;
	}

	public void setPersonne(Personne[] personne) {
		this.personne = personne;
	}
};
