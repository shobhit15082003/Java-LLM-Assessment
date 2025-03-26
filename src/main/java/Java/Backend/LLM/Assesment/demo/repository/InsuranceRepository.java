package Java.Backend.LLM.Assesment.demo.repository;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

    List<Insurance> findByAgeAndGenderAndIncome(Integer age, String gender, Double income);
}
