
package fr.isty.iatic5.sessions.service;

import org.springframework.stereotype.Service;

import fr.isty.iatic5.archilog.sessions.config.SqlUtils;

enum Status {
	Eleve, Enseignant
};

/************************************************************/
/**
 * 
 */
@Service
public class Personne{
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String prenom;
	/**
	 * 
	 */
	private String nom;
	/**
	 * 
	 */
	private String mail;
	/**
	 * 
	 */
	private Status status;

	/**
	 * 
	 * @param id
	 * @param prenom
	 * @param nom
	 * @param mail
	 * @param status
	 */

	/*
	 * public void save() {} public void update() {} public void delete() {} 
	 * public static Personne getById(String id) {} public static List<Personne>getAll(){}
	 * public static List<Personne>getAllByFilter(HashMap<String,String>filters){}
	 */

	public void save() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("INSERT INTO PERSONNE VALUES('?','?','?','?','?')", this.id, this.prenom,
				this.nom, this.mail, this.status == Status.Eleve ? "Eleve" : "Enseignant"));
		SqlUtils.disconnect();
	}
	
	public void update() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("UPDATE PERSONNE SET prenom='?',nom='?',mail='?',status='?' WHERE id='?'", this.prenom,
				this.nom, this.mail, this.status == Status.Eleve ? "Eleve" : "Enseignant" ,this.id));
		SqlUtils.disconnect();
	}
	public Personne(String id, String prenom, String nom, String mail, Status status) {

		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.status = status;
	}
};
