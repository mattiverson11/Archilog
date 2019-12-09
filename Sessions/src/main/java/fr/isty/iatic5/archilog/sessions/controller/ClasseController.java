package fr.isty.iatic5.archilog.sessions.controller;

import io.swagger.annotations.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.isty.iatic5.sessions.service.Classe;
import fr.isty.iatic5.sessions.service.SessionImplementation;


@RestController
@RequestMapping(value = "/manipulClasse")
@Api(value = "APIManipulClasse")

public class ClasseController {

	//@Autowired
	//SessionImplementation sessionImplementation;

	/**
	 * Creation d'une nouvelle classe classeBody param1
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping(path = "/create/newClasse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut créer une classe", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> createNewClass(@RequestBody String classeBody) {

		try {
			SessionImplementation sessionImplementation = new SessionImplementation ();
			sessionImplementation.createClasse(classeBody);

		} catch (Exception e) {
			   System.out.print("Erreur lors de l'appel de l'API /create/newClasse");

		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	/**
	 * Affichage de toutes les lignes de la table Classe
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping(path = "/get/getClasse", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut afficher une classe", httpMethod = "GET", response = Classe.class,
	responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<List<Classe>> getClasse() {
		List<Classe> listClass = null ;

		try {
			listClass = Classe.getAll();

		} catch (Exception e) {
         System.out.print("Erreur lors de l'appel de l'API /get/getClasse");
		}
		return new ResponseEntity<>(listClass,HttpStatus.OK);

	}
	
	/**
	 * Suppression d'une classe classeBody param1
	 * 
	 * @return
	 */
	@ResponseBody
	@DeleteMapping(path = "/delete/deleteClasse", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "L'utilisateur peut supprimer une classe", httpMethod = "DELETE")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to run is not found") })

	public ResponseEntity<Void> deleteNewClass(@RequestBody String classeBody) {
		try {

			SessionImplementation sessionImplementation = new SessionImplementation();
			sessionImplementation.deleteClasse(classeBody);
			

		} catch (Exception e) {
			
	         System.out.print("Erreur lors de l'appel de l'API /delete/deleteclasse");

		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
}
