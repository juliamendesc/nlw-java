package tech.juliamendesc.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import tech.juliamendesc.certification_nlw.modules.students.dto.HasCertificationDTO;

@Service
public class HasCertificationUseCase {

	public boolean execute(HasCertificationDTO hasCertificationDTO) {
		if (hasCertificationDTO.getEmail().equals("batatinha@gmail.com") && hasCertificationDTO.getTechnology().equals("react")) {
			return true;
		}
		return false;
	}
}
