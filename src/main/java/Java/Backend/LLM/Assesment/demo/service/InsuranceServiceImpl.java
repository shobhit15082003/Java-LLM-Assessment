package Java.Backend.LLM.Assesment.demo.service;

import Java.Backend.LLM.Assesment.demo.model.Insurance;
import Java.Backend.LLM.Assesment.demo.repository.InsuranceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.util.*;
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
      try {
          List<Insurance> policies;

          // Apply filters if parameters are provided
          if (age != null || gender != null || income != null) {
              if (age != null && gender != null && income != null) {
                  policies = insuranceRepository.findByAgeAndGenderAndIncome(age, gender, income);
              } else if (age != null && gender != null) {
                  policies = insuranceRepository.findByAgeAndGender(age, gender);
              } else if (age != null && income != null) {
                  policies = insuranceRepository.findByAgeAndIncome(age, income);
              } else if (gender != null && income != null) {
                  policies = insuranceRepository.findByGenderAndIncome(gender, income);
              } else if (age != null) {
                  policies = insuranceRepository.findByAge(age);
              } else if (gender != null) {
                  policies = insuranceRepository.findByGender(gender);
              } else {
                  policies = insuranceRepository.findByIncome(income);
              }
          } else {
              policies = insuranceRepository.findAll();
          }

          // Check if policies list is empty
          if (policies == null || policies.isEmpty()) {
              return createJsonResponse(200, "No matching policies found", new ArrayList<>());
          }

          // Convert policies to response format
          List<Map<String, Object>> policyList = policies.stream().map(policy -> {
              Map<String, Object> policyMap = new HashMap<>();
              policyMap.put("PolicyName", policy.getPolicyHolderName());
              policyMap.put("Provider", policy.getProvider());
              policyMap.put("Age", policy.getAge());
              policyMap.put("Gender", policy.getGender());
              policyMap.put("Income", policy.getIncome());
              policyMap.put("CoverageAmount", policy.getCoverageAmount());
              return policyMap;
          }).collect(Collectors.toList());

          return createJsonResponse(200, "Filtered insurance policies retrieved", policyList);

      } catch (Exception e) {
          e.printStackTrace();
          return "{ \"statusCode\": 500, \"error\": \"An unexpected error occurred\" }";
      }
  }

    // Helper method for creating JSON responses
    private String createJsonResponse(int statusCode, String message, List<Map<String, Object>> data) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", statusCode);
        response.put("message", message);
        response.put("data", data);
        return new ObjectMapper().writeValueAsString(response);
    }



    @Override
    public Insurance createInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

}
