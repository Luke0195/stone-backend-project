package br.com.starwarsproject.domain.enums;

import lombok.Getter;

@Getter
public enum AuthRole {

    USER("USER");

    private final String value;

     AuthRole(String x){
        this.value =  x;
    }
}
