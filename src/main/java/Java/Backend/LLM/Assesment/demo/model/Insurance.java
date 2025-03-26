package Java.Backend.LLM.Assesment.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ïnsurance")
public class Insurance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Policy holder name is required.")
    @Column(nullable = false)
    private String policyHolderName;

    @NotBlank(message = "Provider name is required.")
    @Column(nullable = false)
    private String provider;

    @NotNull(message = "Coverage amount is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Coverage amount must be greater than zero.")
    @Column(nullable = false)
    private Double coverageAmount;

    @NotNull(message = "Age is required.")
    @Min(value = 18, message = "Age must be at least 18.")
    @Column(nullable = false)
    private Integer age;

    @NotBlank(message = "Gender is required.")
    @Pattern(regexp = "Male|Female", message = "Gender must be 'Male' or 'Female'.")
    @Column(nullable = false)
    private String gender;

    @NotNull(message = "Income is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Income must be greater than zero.")
    @Column(nullable = false)
    private Double income;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
