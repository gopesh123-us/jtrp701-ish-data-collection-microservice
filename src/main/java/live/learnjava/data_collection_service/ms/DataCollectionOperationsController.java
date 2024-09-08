package live.learnjava.data_collection_service.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import live.learnjava.data_collection_service.bindings.DcCasePlanEntityDTO;
import live.learnjava.data_collection_service.bindings.DcChildEntityDTO;
import live.learnjava.data_collection_service.bindings.DcEducationEntityDTO;
import live.learnjava.data_collection_service.bindings.DcIncomeEntityDTO;
import live.learnjava.data_collection_service.bindings.DcSummaryDTO;
import live.learnjava.data_collection_service.service.DataCollectionManagementService;

@RestController
@RequestMapping("/dc-api")
@Tag(name="dc-api", description="Data Collection Module Microservice")
public class DataCollectionOperationsController {
	@Autowired
	private DataCollectionManagementService dcservice;

	@GetMapping("/getAppid/{email}")
	public ResponseEntity<Integer> getAppIdFromEmail(@PathVariable String email) {
		Integer appId = dcservice.getAppIdByEmail(email);
		return new ResponseEntity<Integer>(appId, HttpStatus.OK);
	}

	@PostMapping("/generateCase/{appId}")
	public ResponseEntity<Integer> generateCaseNumber(@PathVariable Integer appId) {
		Integer caseNo = dcservice.generateCaseNumber(appId);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
	}

	@GetMapping("/showPlanNames")
	public ResponseEntity<List<String>> displayPlanNames() {
		// use service
		List<String> allPlans = dcservice.showAllPlanNames();
		return new ResponseEntity<List<String>>(allPlans, HttpStatus.OK);
	}

	@PutMapping("/updatePlanSelection")
	public ResponseEntity<Integer> saveCaseAndPlanSelection(@RequestBody DcCasePlanEntityDTO caseEntityDTO) {
		// use service
		Integer caseNo = dcservice.saveCaseAndPlanSelection(caseEntityDTO);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.OK);
	}

	@PostMapping("/saveIncome")
	public ResponseEntity<Integer> saveIncomeDetails(@RequestBody DcIncomeEntityDTO incomeEntityDTO) {
		// use service
		Integer caseNo = dcservice.saveIncomeDetails(incomeEntityDTO);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
	}

	@PostMapping("/saveEducation")
	public ResponseEntity<Integer> saveEducation(@RequestBody DcEducationEntityDTO educationDTO) {
		// use service
		Integer caseNo = dcservice.saveEducationDetails(educationDTO);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
	}

	@PostMapping("/saveChildren")
	public ResponseEntity<Integer> saveChildren(@RequestBody List<DcChildEntityDTO> childrenDTO) {
		// use service
		Integer caseNo = dcservice.saveChildrenDetails(childrenDTO);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
	}

	@PostMapping("/addChild")
	public ResponseEntity<DcChildEntityDTO> saveChild(@RequestBody DcChildEntityDTO childDTO) {
		// use service
		DcChildEntityDTO savedChild = dcservice.addChild(childDTO);
		return new ResponseEntity<DcChildEntityDTO>(savedChild, HttpStatus.CREATED);
	}

	@GetMapping("/summary/{caseNo}")
	public ResponseEntity<DcSummaryDTO> getSummary(@PathVariable Integer caseNo) {
		// use service
		DcSummaryDTO dcSummary = dcservice.showSummary(caseNo);
		return new ResponseEntity<DcSummaryDTO>(dcSummary, HttpStatus.OK);
	}
}
