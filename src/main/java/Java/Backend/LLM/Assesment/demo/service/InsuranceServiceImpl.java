package Java.Backend.LLM.Assesment.demo.service;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import Java.Backend.LLM.Assesment.demo.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService{
        private final InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<Insurance> getAllInsurance(){
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance purchaseInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public String downloadInsurance(Integer age, String gender, Double income) {
        return "";
    }

}
