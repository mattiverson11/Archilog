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
public class Session{
	public Session() {
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
	private String classe;
	/**
	 * 
	 */
	private String creneau;
	/**
	 * 
	 */
	private String UE;
	/**
	 * 
	 */
	
	/**
	 * 
	 * @param id
	 * @param classe
	 * @param creneau
	 * @param UE
	 */
	public Session(String id,String idclase, String creneau, String UE) {
		this.id = id;
		this.classe = classe;
		this.creneau = creneau;
		this.UE = UE;
	}

	public void save() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("INSERT INTO SESSION VALUES('%s','%s','%s','%s')",this.id, this.classe,
				this.creneau, this.UE));
		SqlUtils.disconnect();
	}

	public void update() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("UPDATE SESSION SET id ='%s',classe='%s',creneau='%s' WHERE id='%s'",
				this.id,this.creneau, this.classe, this.UE));
		SqlUtils.disconnect();
	}

	public void delete() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("DELETE FROM SESSION WHERE id='%s'", this.id));
		SqlUtils.disconnect();

	}

	public static Session getById(String id) {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM SESSION WHERE id='%s'", id));
		

		try {
			Session session = new Session(set.getString("id"), set.getString("classe"), set.getString("creneau"), set.getString("UE"));
			SqlUtils.disconnect();
			return session;
		} catch (SQLException e) {
			e.printStackTrace();
			SqlUtils.disconnect();
			return null;
		}
		
	}

	@Override
	public String toString() {
		return "" + id + " ; " + classe + " ; " + creneau + "; " + UE + " \n";
	}

	public static List<Session> getAll() {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM SESSION "));
	
		List<Session> result = new ArrayList<Session>();

		try {
			while (set.next()) {
				Session session = new Session(set.getString("id"), set.getString("classe"), set.getString("creneau"), set.getString("UE"));
				result.add(session);
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

	public String getclasse() {
		return classe;
	}

	public void setclasse(String classe) {
		this.classe = classe;
	}

	public String getcreneau() {
		return creneau;
	}

	public void setcreneau(String creneau) {
		this.creneau = creneau;
	}

	public String getUE() {
		return UE;
	}

	public void setUE(String UE) {
		this.UE = UE;
	}

};
