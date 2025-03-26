package Java.Backend.LLM.Assesment.demo.repository;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

}
