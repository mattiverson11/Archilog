package fr.isty.iatic5.archilog.sessions.controller;

import io.swagger.annotations.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.isty.iatic5.sessions.service.Creneau;
import fr.isty.iatic5.sessions.service.SessionImplementation;

@RestController
@RequestMapping(value = "/manipulCreneau")
@Api(value = "APIManipulCreneau")

public class CreneauConroller {

	/**
	 * Creation d'un nouveau creneau classeBody 
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping(path = "/create/newcreneau", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut créer un nouveau creneau", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully post message"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> createNewClass(@RequestBody String classeBody) {
		try {

			SessionImplementation sessionImplementation = new SessionImplementation();
			sessionImplementation.createCreneau(classeBody);

		} catch (Exception e) {
			System.out.println("Erreur lors de l'appel de l'API /create/newCreneau : " + e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	/**
	 * Affichage de toutes les lignes de la table Creneau
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping(path = "/get/getCreneau", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut afficher un creneau", httpMethod = "GET", response = Creneau.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<List<Creneau>> getCreneau() {
		List<Creneau> listCreneau = null;

		try {
			listCreneau = Creneau.getAll();

		} catch (Exception e) {
			System.out.println("Erreur lors de l'appel de l'API /get/getCreneau : " + e.getMessage());
		}
		return new ResponseEntity<>(listCreneau, HttpStatus.OK);

	}

	/**
	 * Suppression d'un creneau classeBody 
	 * 
	 * @return
	 */
	@ResponseBody
	@DeleteMapping(path = "/delete/deletecreneau", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut supprimer un creneau", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully delete message"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> deleteCreneau(@RequestBody String classeBody) {
		try {

			SessionImplementation sessionImplementation = new SessionImplementation();
			sessionImplementation.deleteCreneau(classeBody);

		} catch (Exception e) {
			System.out.println("Erreur lors de l'appel de l'API /delete/deletecreneau :" + e.getMessage());

		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
