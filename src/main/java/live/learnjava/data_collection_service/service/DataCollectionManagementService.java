 package live.learnjava.data_collection_service.service;

import java.util.List;

import live.learnjava.data_collection_service.bindings.DcCasePlanEntityDTO;
import live.learnjava.data_collection_service.bindings.DcChildEntityDTO;
import live.learnjava.data_collection_service.bindings.DcEducationEntityDTO;
import live.learnjava.data_collection_service.bindings.DcIncomeEntityDTO;
import live.learnjava.data_collection_service.bindings.DcSummaryDTO;
import live.learnjava.data_collection_service.entities.DcChildEntity;

public interface DataCollectionManagementService {
	// getAppId from citizen_application table based on email
	// sir says - get email as @PathVariable
	public Integer getAppIdByEmail(String email); 
	
	public Integer generateCaseNumber(Integer AppId);
	public List<String> showAllPlanNames();
	//save selected plan and case number // to dc_cases table
	public Integer saveCaseAndPlanSelection(DcCasePlanEntityDTO caseEntityDTO);
	public Integer saveIncomeDetails(DcIncomeEntityDTO incomeEntityDTO);
	public Integer saveEducationDetails(DcEducationEntityDTO educationEntityDTO);
	public Integer saveChildrenDetails(List<DcChildEntityDTO> listChildrenDTO);
	public DcSummaryDTO showSummary(Integer caseNumber);
	
	// This is an additional method to add additional child for a given case no.
	public DcChildEntityDTO addChild(DcChildEntityDTO childEntityDTO);

	
}
