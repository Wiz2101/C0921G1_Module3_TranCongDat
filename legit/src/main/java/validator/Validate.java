package validator;

import java.util.regex.Pattern;

public class Validate {
    public static boolean patientCode(String code){
        Pattern pattern = Pattern.compile("^PT\\-\\d{5}$");
        if (pattern.matcher(code).matches()){
            return true;
        }
        return false;
    }

    public static boolean medicalRecordCode(String code){
        Pattern pattern = Pattern.compile("^MC\\-\\d{5}$");
        if (pattern.matcher(code).matches()){
            return true;
        }
        return false;
    }

    public static boolean name(String name){
        Pattern pattern = Pattern.compile("^(([A-Z]|[a-z])[a-z]?+\\s?)+$");
        if (pattern.matcher(name).matches()){
            return true;
        }
        return false;
    }
}
