package dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterRequestValidator implements Validator {
    private static final String nameRegExp =
            "^[_A-Za-z0-9-\\+](\\.[_A-Za-z0-9-]+)$";
    private Pattern pattern;

    public RegisterRequestValidator() {
        pattern = Pattern.compile(nameRegExp);
    }



    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }



    public void validate(Object target, Errors errors) {
        RegisterRequest regReq = (RegisterRequest) target;
        if(regReq.getName() == null || regReq.getName().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        }  else {
            Matcher matcher = pattern.matcher(regReq.getName());
            if(!matcher.matches()) {
                errors.rejectValue("email", "bad");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
        if(!regReq.getPassword().isEmpty()) {
            if(!regReq.isPasswordEqualToConfirmPassword()) {
                errors.rejectValue("confirmPassword", "nomatch");
            }
        }
    }

}
