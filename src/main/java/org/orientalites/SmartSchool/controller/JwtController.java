package org.orientalites.SmartSchool.controller;

import org.orientalites.SmartSchool.data.models.JwtRequest;
import org.orientalites.SmartSchool.data.models.JwtResponse;
import org.orientalites.SmartSchool.data.service.StudentDetailService;
import org.orientalites.SmartSchool.data.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired private StudentDetailService sds;

    @Autowired private JwtUtil jwtUtil;

    @PostMapping(value = "/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {

            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }

        UserDetails userDetails = this.sds.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
