package Java.Backend.LLM.Assesment.demo.service;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import Java.Backend.LLM.Assesment.demo.repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Insurance> policies = insuranceRepository.findAll();

        // Apply filters only if parameters are provided
        if (age != null) {
            policies = policies.stream().filter(policy -> policy.getAge().equals(age)).collect(Collectors.toList());
        }
        if (gender != null) {
            policies = policies.stream().filter(policy -> policy.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
        }
        if (income != null) {
            policies = policies.stream().filter(policy -> policy.getIncome().equals(income)).collect(Collectors.toList());
        }

        if(policies.isEmpty())
            return "";

        return policies.stream()
                .map(policy -> "Policy Name: " + policy.getPolicyHolderName() + "\nProvider: " + policy.getProvider() +
                        "\nAge: " + policy.getAge() + "\nGender: " + policy.getGender() +
                        "\nIncome: " + policy.getIncome() + "\nPremium: $" + policy.getIncome() + "\n")
                .collect(Collectors.joining("\n---------------------------------\n"));
    }

    @Override
    public Insurance createInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

}
