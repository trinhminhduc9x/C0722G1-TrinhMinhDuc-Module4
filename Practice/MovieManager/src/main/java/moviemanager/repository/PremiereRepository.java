package moviemanager.repository;

import moviemanager.model.Premiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiereRepository extends JpaRepository<Premiere,Integer> {

}
