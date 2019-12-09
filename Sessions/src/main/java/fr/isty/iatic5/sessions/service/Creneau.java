
package fr.isty.iatic5.sessions.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.isty.iatic5.archilog.sessions.config.SqlUtils;

/************************************************************/
/**
 * 
 */
//@Service
public class Creneau {
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private LocalTime debut;
	/**
	 * 
	 */
	private LocalTime fin;
	/**
	 * 
	 */
	private LocalDate jour;
	/**
	 * 
	 */
	public Classe classe;
	public UniteEnseignement uniteEnseignement;

	/**
	 * 
	 * @param id
	 * @param debut
	 * @param fin
	 * @param jour
	 */
	public Creneau(String id, LocalTime debut, LocalTime fin, LocalDate jour) {
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.jour = jour;
	}

	public void save() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("INSERT INTO CRENEAU VALUES('%s','%s','%s','%s','%s','%s')", this.id,
				this.debut.toString(), this.fin.toString(), this.jour.toString(),
				this.classe == null ? "" : this.classe.getId(),
				this.uniteEnseignement == null ? "" : this.uniteEnseignement.getId()));
		SqlUtils.disconnect();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalTime getDebut() {
		return debut;
	}

	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public UniteEnseignement getUniteEnseignement() {
		return uniteEnseignement;
	}

	public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
		this.uniteEnseignement = uniteEnseignement;
	}

	public void update() {
		SqlUtils.connect();
		System.out.print("sa classe : "+this.classe);
		SqlUtils.requestUpdate(String.format(
				"UPDATE CRENEAU SET debut='%s',fin='%s',jour='%s',classe='%s',uniteEnseignement='%s' WHERE id='%s'",
				this.debut.toString(), this.fin.toString(), this.jour.toString(),
				this.classe == null ? "" : this.classe.getId(),
				this.uniteEnseignement == null ? "" : this.uniteEnseignement.getId(),
						this.id));

		System.out.print(" ligne crenau maj");
		SqlUtils.disconnect();
	}

	public void delete() {
		SqlUtils.connect();
		SqlUtils.requestUpdate(String.format("DELETE FROM CRENEAU WHERE id='%s'", this.id));
		SqlUtils.disconnect();

	}

	public static Creneau getById(String id) {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM CRENEAU WHERE id='%s'", id));

		try {
			Creneau creneau = new Creneau(set.getString("id"), LocalTime.parse(set.getString("debut")),
					LocalTime.parse(set.getString("fin")), LocalDate.parse(set.getString("jour")));
			SqlUtils.disconnect();
			return creneau;
		} catch (SQLException e) {
			e.printStackTrace();
			SqlUtils.disconnect();
			return null;
		}
	}

	public static List<Creneau> getAll() {
		SqlUtils.connect();
		ResultSet set = SqlUtils.requestSelect(String.format("SELECT * FROM CRENEAU"));

		List<Creneau> result = new ArrayList<Creneau>();

		try {
			while (set.next()) {
				Creneau creneau = new Creneau(set.getString("id"), LocalTime.parse(set.getString("debut")),
						LocalTime.parse(set.getString("fin")), LocalDate.parse(set.getString("jour")));
				result.add(creneau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			SqlUtils.disconnect();
			return null;
		}
		SqlUtils.disconnect();
		return result;
	}

	@Override
	public String toString() {
		return "" + id + " ; " + debut + " ; " + fin + " ; " + jour + "\n";
	}

};
