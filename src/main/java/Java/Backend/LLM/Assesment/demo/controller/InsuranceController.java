package Java.Backend.LLM.Assesment.demo.controller;

import Java.Backend.LLM.Assesment.demo.dto.ResponseWrapper;
import Java.Backend.LLM.Assesment.demo.model.Insurance;
import Java.Backend.LLM.Assesment.demo.service.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<Insurance>>> getAllInsurance(){
        List<Insurance>policies=insuranceService.getAllInsurance();
        return ResponseEntity.ok(new ResponseWrapper<>(200,"Insurance policie fetched successfully",policies));
    }

    @PostMapping("/purchase")
    public ResponseEntity<ResponseWrapper<Insurance>> purchaseInsurance(@RequestBody Insurance insurance){
        Insurance savedInsurance = insuranceService.purchaseInsurance(insurance);
        return ResponseEntity.ok(new ResponseWrapper<>(201,"Insurance purchased successfully",savedInsurance));

    }

    @GetMapping("/download")
    public ResponseEntity<ResponseWrapper<String>> downloadInsurance(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Double income) {
        String policyDetails = insuranceService.downloadInsurance(age,gender,income);

        if(policyDetails.isEmpty()){
            return ResponseEntity.ok(new ResponseWrapper<>(404,"No matching insurance policies found",""));
        }
        return ResponseEntity.ok(new ResponseWrapper<>(200,"Filtered insurance poilicies retrieved",policyDetails));
    }
}
