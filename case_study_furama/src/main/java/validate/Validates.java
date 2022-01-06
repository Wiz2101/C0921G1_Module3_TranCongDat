package validate;

import java.util.regex.Pattern;

public class Validates {
    public static boolean customerIdName(String customerIdName){
        Pattern pattern = Pattern.compile("^KH\\-\\d{5}$");
        if(pattern.matcher(customerIdName).matches()){
            return true;
        }
        return false;
    }

    public static boolean serviceID(String serviceID){
        Pattern pattern = Pattern.compile("^DV\\-\\d{5}$");
        if (pattern.matcher(serviceID).matches()){
            return true;
        }
        return false;
    }

    public static boolean phoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})$");
        if (pattern.matcher(phoneNumber).matches()){
            return true;
        }
        return false;
    }

    public static boolean idCard(String idCard){
        Pattern pattern = Pattern.compile("^(\\d{9})|(\\d{12})$");
        if (pattern.matcher(idCard).matches()){
            return true;
        }
        return false;
    }

    public static boolean email(String email){
        Pattern pattern = Pattern.compile("^\\w{1,30}\\@(([a-z]|\\d)+)\\.(([a-z]|\\d)+)$");
        if (pattern.matcher(email).matches()){
            return true;
        }
        return false;
    }

    public static boolean numberOfFloors(int numberOfFloors){
        if (numberOfFloors > 0){
            return true;
        }
        return false;
    }

    public static boolean salary(double salary){
        if (salary > 0){
            return true;
        }
        return false;
    }

    public static boolean cost(double cost){
        if (cost > 0){
            return true;
        }
        return false;
    }

    public static boolean deposit(double deposit){
        if (deposit > 0){
            return true;
        }
        return false;
    }

    public static boolean contractTotalMoney(double contractTotalMoney){
        if (contractTotalMoney > 0){
            return true;
        }
        return false;
    }
}
