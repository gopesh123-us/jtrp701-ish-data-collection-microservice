package live.learnjava.data_collection_service.bindings;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitizenAppRegistrationEntityDTO {
	private Integer appId;
	private String fullName;
	private String email;
	private Long phoneNo;
	private Long ssn;
	private String gender;
	private LocalDate dob;
	private String stateName;
}
