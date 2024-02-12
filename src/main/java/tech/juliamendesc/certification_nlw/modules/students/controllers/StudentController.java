package tech.juliamendesc.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.juliamendesc.certification_nlw.modules.students.dto.HasCertificationDTO;
import tech.juliamendesc.certification_nlw.modules.students.useCases.HasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private HasCertificationUseCase hasCertificationUseCase;

	@PostMapping("/hasCertification")
	public String hasCertification(@RequestBody HasCertificationDTO hasCertificationDTO){

		var result = this.hasCertificationUseCase.execute(hasCertificationDTO);

		if (result) {
			return "usuário já fez a prova";
		}

		return "usuário autorizado";
	}
}
