package live.learnjava.data_collection_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.data_collection_service.entities.PlanEntity;

public interface IPlanRepository extends JpaRepository<PlanEntity, Integer>{
		
}
