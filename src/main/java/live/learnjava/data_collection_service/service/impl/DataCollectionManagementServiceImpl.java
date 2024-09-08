package live.learnjava.data_collection_service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.learnjava.data_collection_service.bindings.CitizenAppRegistrationEntityDTO;
import live.learnjava.data_collection_service.bindings.DcCasePlanEntityDTO;
import live.learnjava.data_collection_service.bindings.DcChildEntityDTO;
import live.learnjava.data_collection_service.bindings.DcEducationEntityDTO;
import live.learnjava.data_collection_service.bindings.DcIncomeEntityDTO;
import live.learnjava.data_collection_service.bindings.DcSummaryDTO;
import live.learnjava.data_collection_service.entities.CitizenAppRegistrationEntity;
import live.learnjava.data_collection_service.entities.DcCasePlanEntity;
import live.learnjava.data_collection_service.entities.DcChildEntity;
import live.learnjava.data_collection_service.entities.DcEducationEntity;
import live.learnjava.data_collection_service.entities.DcIncomeEntity;
import live.learnjava.data_collection_service.entities.PlanEntity;
import live.learnjava.data_collection_service.repositories.ICitizenApplicationRegistrationRepository;
import live.learnjava.data_collection_service.repositories.IDcCasePlanRepository;
import live.learnjava.data_collection_service.repositories.IDcChildRepository;
import live.learnjava.data_collection_service.repositories.IDcEducationRepository;
import live.learnjava.data_collection_service.repositories.IDcIncomeRepository;
import live.learnjava.data_collection_service.repositories.IPlanRepository;
import live.learnjava.data_collection_service.service.DataCollectionManagementService;

@Service
public class DataCollectionManagementServiceImpl implements DataCollectionManagementService {
	// get all repositories

	@Autowired
	private ICitizenApplicationRegistrationRepository citizenARRepo;

	@Autowired
	private IDcCasePlanRepository caseRepo;

	@Autowired
	private IDcChildRepository childRepo;

	@Autowired
	private IDcEducationRepository educationRepo;

	@Autowired
	private IDcIncomeRepository incomeRepo;

	@Autowired
	private IPlanRepository planRepo;

	// This is an extra method I am providing as a convenience method.
	@Override
	public Integer getAppIdByEmail(String email) {
		Optional<CitizenAppRegistrationEntity> opt = citizenARRepo.findByEmail(email);
		if (opt.isPresent()) {
			CitizenAppRegistrationEntity citizen = opt.get();
			Integer appId = citizen.getAppId();
			return appId;
		}
		return 0;
	}

	// use for {screen #2}
	@Override
	public Integer generateCaseNumber(Integer AppId) {
		Optional<CitizenAppRegistrationEntity> opt = citizenARRepo.findById(AppId);
		if (opt.isPresent()) {
			DcCasePlanEntity caseEntity = new DcCasePlanEntity();
			// save app-id in JR701_DC_CASES
			// plan-id not available yet - later
			// case-no will be generated automatically during save operation
			// partial data insertion
			caseEntity.setAppId(AppId);
			DcCasePlanEntity savedEntity = caseRepo.save(caseEntity);
			return savedEntity.getCaseNo();
		}
		return 0;
	}

	// This method is for {screen-2}
	@Override
	public List<String> showAllPlanNames() {
		List<PlanEntity> plans = planRepo.findAll();
		// this should come from repo plan_category
		List<String> plansNames = plans.stream().map(plan -> plan.getPlanName()).collect(Collectors.toList());
		return plansNames;
	}

	// this method is for {screen-2}
	@Override
	public Integer saveCaseAndPlanSelection(DcCasePlanEntityDTO casePlanEntityDTO) {
		// Load DcCaseEntity object from DB - because this obj will not have plan-id
		// that we will set below
		Optional<DcCasePlanEntity> opt = caseRepo.findById(casePlanEntityDTO.getCaseNo());
		if (opt.isPresent()) {
			DcCasePlanEntity caseEntity = opt.get();
			caseEntity.setPlanId(casePlanEntityDTO.getPlanId());
			Integer caseNo = caseRepo.save(caseEntity).getCaseNo(); // update object operation
			return caseNo;
		}
		return 0;
	}

	// This methods is for {screen-3}
	@Override
	public Integer saveIncomeDetails(DcIncomeEntityDTO incomeEntityDTO) {
		DcIncomeEntity incomeEntity = new DcIncomeEntity();
		BeanUtils.copyProperties(incomeEntityDTO, incomeEntity);
		Integer caseNo = incomeRepo.save(incomeEntity).getCaseNo();
		return caseNo;
	}

	@Override
	public Integer saveEducationDetails(DcEducationEntityDTO educationEntityDTO) {
		DcEducationEntity educationEntity = new DcEducationEntity();
		BeanUtils.copyProperties(educationEntityDTO, educationEntity);
		Integer caseNo = educationRepo.save(educationEntity).getCaseNo();
		return caseNo;
	}

	@Override
	public Integer saveChildrenDetails(List<DcChildEntityDTO> listChildrenDTO) {

		listChildrenDTO.forEach(child -> {
			DcChildEntity childEntity = new DcChildEntity();
			BeanUtils.copyProperties(child, childEntity);
			childRepo.save(childEntity);
		});
		// In the database, we save three records. All records have the same case no.
		// Pick up any record or first record and get the caseNo and return it.
		return listChildrenDTO.get(0).getCaseNo();
	}

	@Override
	public DcSummaryDTO showSummary(Integer caseNo) {
		// user all repos
		DcSummaryDTO summary = new DcSummaryDTO();

		// set plan name on the summary page {screen-6}
		Optional<DcCasePlanEntity> opt = caseRepo.findById(caseNo);
		if (opt.isPresent()) {
			DcCasePlanEntityDTO casePlanEntityDTO = new DcCasePlanEntityDTO();
			DcCasePlanEntity casePlanEntity = opt.get();
			Integer appId = casePlanEntity.getAppId(); // to get citizen details
			Integer planId = casePlanEntity.getPlanId();
			BeanUtils.copyProperties(casePlanEntity, casePlanEntityDTO);
			//set casePlanEntityDTO anyways - redundant information to see appid, planid, caseid
			
			
			Optional<PlanEntity> planOpt = planRepo.findById(planId);
			if (planOpt.isPresent()) {
				PlanEntity planEntity = planOpt.get();
				casePlanEntityDTO.setPlanName(planEntity.getPlanName());
				summary.setPlanName(planEntity.getPlanName());
				summary.setDcCaseEntityDTO(casePlanEntityDTO);
			}
			// set CitizenAppRegistrationEntityDTO
			Optional<CitizenAppRegistrationEntity> citizenOpt = citizenARRepo.findById(appId);
			if (citizenOpt.isPresent()) {
				CitizenAppRegistrationEntityDTO citizenEntityDTO = new CitizenAppRegistrationEntityDTO();
				CitizenAppRegistrationEntity citizenEntity = citizenOpt.get();
				BeanUtils.copyProperties(citizenEntity, citizenEntityDTO);
				summary.setCitizenAppRegistrationEntityDTO(citizenEntityDTO);
			}
		}

		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNo(caseNo);
		DcIncomeEntityDTO incomeEntityDTO = new DcIncomeEntityDTO();
		BeanUtils.copyProperties(incomeEntity, incomeEntityDTO);
		summary.setDcIncomeEntityDTO(incomeEntityDTO);

		DcEducationEntity educationEntity = educationRepo.findByCaseNo(caseNo);
		DcEducationEntityDTO educationEntityDTO = new DcEducationEntityDTO();
		BeanUtils.copyProperties(educationEntity, educationEntityDTO);
		summary.setDcEducationEntityDTO(educationEntityDTO);

		List<DcChildEntity> children = childRepo.findByCaseNo(caseNo);
		List<DcChildEntityDTO> listChildDTO = new ArrayList<DcChildEntityDTO>();
		children.stream().forEach(childEntity -> {
			// convert into dto
			DcChildEntityDTO childDTO = new DcChildEntityDTO();
			BeanUtils.copyProperties(childEntity, childDTO);
			listChildDTO.add(childDTO);
		});
		summary.setListDcChildEntityDTO(listChildDTO);

		return summary;
	}

	// adding this extra method to save additional child
	@Override
	public DcChildEntityDTO addChild(DcChildEntityDTO childEntityDTO) {
		DcChildEntity childEntity = new DcChildEntity();
		BeanUtils.copyProperties(childEntityDTO, childEntity);
		DcChildEntity savedChild = childRepo.save(childEntity);
		DcChildEntityDTO childDTO = new DcChildEntityDTO();
		BeanUtils.copyProperties(savedChild, childDTO);
		return childDTO;
	}

}
