package ifam.edu.dra.chatcompromisso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifam.edu.dra.chatcompromisso.model.Compromisso;
import ifam.edu.dra.chatcompromisso.service.CompromissoService;

@RestController
@RequestMapping("/compromisso")
public class CompromissoController {

	@Autowired
	CompromissoService compromissoService;

	@PostMapping
	ResponseEntity<Compromisso> criarCompromissos(@RequestBody Compromisso compromisso) {
		compromissoService.criarCompromisso(compromisso);
		return ResponseEntity.created(null).body(compromisso);
	}

	@GetMapping
	ResponseEntity<List<Compromisso>> listaCompromissos() {
		List<Compromisso> compromissos = compromissoService.listaCompromissos();
		if (compromissos.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(compromissos);
		return ResponseEntity.ok(compromissos);
	}

	@GetMapping("/{id}")
	ResponseEntity<Compromisso> listaCompromissoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(compromissoService.listaCompromisso(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}

	@PutMapping("/{id}")
	ResponseEntity<Compromisso> editarCompromisso(@PathVariable Long id, @RequestBody Compromisso compromisso) {
		try {
			return ResponseEntity.accepted().body(compromissoService.editarCompromisso(id, compromisso));
		} catch (UnsupportedOperationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Compromisso> excluirCompromisso(@PathVariable Long id) {
		try {
			compromissoService.excluirCompromisso(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Compromisso());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}

	@PostMapping("/aceitar/{id}")
	ResponseEntity<Compromisso> aceitarCompromisso(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(compromissoService.aceitarCompromisso(id));
		} catch (UnsupportedOperationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}

	@PostMapping("/negar/{id}")
	ResponseEntity<Compromisso> negarCompromisso(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(compromissoService.negarCompromisso(id));
		} catch (UnsupportedOperationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}

	@PutMapping("/cancelar/{id}")
	ResponseEntity<Compromisso> cancelarCompromisso(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(compromissoService.cancelarCompromisso(id));
		} catch (UnsupportedOperationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Compromisso());
		}
	}
}
