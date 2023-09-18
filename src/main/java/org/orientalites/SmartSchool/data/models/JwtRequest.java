package org.orientalites.SmartSchool.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequest {
    private String email;
    private String password;
}
