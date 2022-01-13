package base.main.java.com.example.restservice.constraint;

import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object> {

    private String firstfield_name;
    private String secondfield_name;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
     firstfield_name =constraintAnnotation.first();
     secondfield_name =constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Object firstObj = BeanUtils.getPropertyDescriptor((Class<?>) o, firstfield_name);
            final Object secondObj = BeanUtils.getPropertyDescriptor((Class<?>) o, secondfield_name);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}
        return false;
    }
}
