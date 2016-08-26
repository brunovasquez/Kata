package org.fundacionjala.cata;

/**
 * Created by BrunoVasquez on 8/26/2016.
 */
public class ValidatorEAN {


    public boolean validate(String code) {
        int valour = 0;
        int sum = 0;
        for (int i = 0; i < code.length(); i++) {
            int number = code.charAt(i) - '0';

            if (i == i % 2)
                valour = number * 1;
            else
                valour = number * 0;

            sum += valour;
        }


        if (code.length() - 1 == 10 - (sum % 10))
            return true;

        return false;
    }


}
