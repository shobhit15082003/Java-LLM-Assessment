package Java.Backend.LLM.Assesment.demo.service;

import Java.Backend.LLM.Assesment.demo.model.Insurance;

import java.util.List;

public interface InsuranceService {

    List<Insurance> getAllInsurance();
    Insurance purchaseInsurance(Insurance insurance);
    String downloadInsurance(Integer age,String gender, Double income);
}
