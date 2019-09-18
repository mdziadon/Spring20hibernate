package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int legalAge;

    @Override
    public void initialize(Age constraintAnnotation) {
        this.legalAge = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        if (yearOfBirth == null) {
            return true;
        }
        int age = LocalDate.now().getYear() - yearOfBirth;
        return age >= legalAge;
    }
}
