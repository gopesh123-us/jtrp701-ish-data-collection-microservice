package live.learnjava.data_collection_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.data_collection_service.entities.CitizenAppRegistrationEntity;

public interface ICitizenApplicationRegistrationRepository
		extends JpaRepository<CitizenAppRegistrationEntity, Integer> {
	public Optional<CitizenAppRegistrationEntity> findByEmail(String email);
}
