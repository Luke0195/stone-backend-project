package br.com.starwarsproject.utils;

import org.apache.commons.lang3.StringUtils;

public class FormatterUtil {

    private FormatterUtil(){}


    public  static String maskCreditCard(String value){
      return StringUtils.overlay(value, StringUtils.repeat("*", value.length() -4), 0, value.length() -4);
    }
}
