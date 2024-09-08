package live.learnjava.data_collection_service.bindings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcEducationEntityDTO {
	private Integer educationId;
	private Integer caseNo;	
	private String highestQualification;
	private Integer passOutYear;
}
