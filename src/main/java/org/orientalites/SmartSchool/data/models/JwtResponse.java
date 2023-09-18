package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class JwtResponse {
    private final String token;

    public JwtResponse(String token) {
        super();
        this.token = token;
    }
}
