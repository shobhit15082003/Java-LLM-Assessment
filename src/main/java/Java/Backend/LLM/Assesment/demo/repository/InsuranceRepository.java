package Java.Backend.LLM.Assesment.demo.repository;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

    List<Insurance> findByAgeAndGenderAndIncome(Integer age, String gender, Double income);

    List<Insurance> findByAgeAndGender(Integer age, String gender);

    List<Insurance> findByAgeAndIncome(Integer age, Double income);

    List<Insurance> findByGenderAndIncome(String gender, Double income);

    List<Insurance> findByAge(Integer age);

    List<Insurance> findByGender(String gender);

    List<Insurance> findByIncome(Double income);
}
