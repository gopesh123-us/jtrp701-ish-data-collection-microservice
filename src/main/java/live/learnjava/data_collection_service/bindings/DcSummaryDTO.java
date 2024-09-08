package live.learnjava.data_collection_service.bindings;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class DcSummaryDTO {
	private CitizenAppRegistrationEntityDTO citizenAppRegistrationEntityDTO;
	private DcCasePlanEntityDTO dcCaseEntityDTO;
	private DcEducationEntityDTO dcEducationEntityDTO;
	private List<DcChildEntityDTO> listDcChildEntityDTO;
	private DcIncomeEntityDTO dcIncomeEntityDTO;
	private String planName;	
}
