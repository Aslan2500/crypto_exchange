package com.example.crypto_exchange.util;

import com.example.crypto_exchange.exception.PhoneFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {

    public static final String PHONE_REGEX = "(\\+7|7|8)\\d{10}";

    private static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches(PHONE_REGEX);
    }

    public static String convertToStandardFormat(String phoneNumber){
        if(!isValidPhoneNumber(phoneNumber))
            throw new PhoneFormatException("Phone format is not correct");
        final Matcher matcher = Pattern.compile(PHONE_REGEX).matcher(phoneNumber);
        int prefixLength = matcher.group(1).length();
        return "+7" + phoneNumber.substring(prefixLength);
    }
}
