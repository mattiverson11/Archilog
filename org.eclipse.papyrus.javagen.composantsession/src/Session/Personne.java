// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Session;

enum Status {
	Eleve, Enseignant
};

/************************************************************/
/**
 * 
 */
public class Personne extends SqlUtils {
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
		this.connect();
		this.requestUpdate(String.format("INSERT INTO PERSONNE VALUES('?','?','?','?','?')", this.id, this.prenom,
				this.nom, this.mail, this.status == Status.Eleve ? "Eleve" : "Enseignant"));
		this.disconnect();
	}
	
	public void update() {
		this.connect();
		this.requestUpdate(String.format("UPDATE PERSONNE SET prenom='?',nom='?',mail='?',status='?' WHERE id='?'", this.prenom,
				this.nom, this.mail, this.status == Status.Eleve ? "Eleve" : "Enseignant" ,this.id));
		this.disconnect();
	}
	public Personne(String id, String prenom, String nom, String mail, Status status) {

		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.status = status;
	}
};