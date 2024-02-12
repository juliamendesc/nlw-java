package tech.juliamendesc.certification_nlw.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HasCertificationDTO {
	private String email;
	private String technology;
}
