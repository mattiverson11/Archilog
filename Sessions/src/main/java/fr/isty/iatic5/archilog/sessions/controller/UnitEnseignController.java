package fr.isty.iatic5.archilog.sessions.controller;

import io.swagger.annotations.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.isty.iatic5.sessions.service.SessionImplementation;
import fr.isty.iatic5.sessions.service.UniteEnseignement;

@RestController
@RequestMapping(value = "/manipulUniteEnseign")
@Api(value = "APIManipulUniteEnseign")

public class UnitEnseignController {

	/**
	 * Creation d'une nouvelle entite d'enseignement classeBody param1
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping(path = "/create/newentitenseign", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut créer une entite d'enseignement", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully message post"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> createNewEntiteEnseign(@RequestBody String classeBody) {
		try {

			SessionImplementation sessionImplementation = new SessionImplementation();
			sessionImplementation.createEU(classeBody);

		} catch (Exception e) {
			System.out.print("Erreur lors de l'appel de l'API /create/newentitenseign");

		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	/**
	 * Affichage de toutes les lignes de la table UE
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping(path = "/get/getEntiteEnseign", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut afficher une UE", httpMethod = "GET", response = UniteEnseignement.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully message get"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<List<UniteEnseignement>> getClasse() {
		List<UniteEnseignement> listEU = null;

		try {
			listEU = UniteEnseignement.getAll();

		} catch (Exception e) {
			System.out.print("Erreur lors de l'appel de l'API /get/getClasse");
		}
		return new ResponseEntity<>(listEU, HttpStatus.OK);

	}

	/**
	 * Suppression d'une entite d'enseignement classeBody param1
	 * 
	 * @return
	 */
	@ResponseBody
	@DeleteMapping(path = "/delete/deletentitenseign", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut supprimer une entite d'enseignement", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully message delete"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> deleteEntiteEnseign(@RequestBody String classeBody) {
		try {

			SessionImplementation sessionImplementation = new SessionImplementation();
			sessionImplementation.deleteEU(classeBody);

		} catch (Exception e) {

		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
}
