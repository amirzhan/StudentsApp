package kz.iitu.StudentsDataApp.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class QuickPasswordEncodingGenerator {
    public static void main(String[] args) {
        String password = "admin";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(password + "  "+passwordEncoder.encode(password));
    }
}
// $2a$10$3Oq5jglznZZ9OTlazgnyp.jhYdqvQ8BvKycUIZCknq0//ELOxXIFC
  //      $2a$10$1UNOM.rnMdmuaVgGxcrMg.yf.aoTeqJXs3uTCgYKugxFME0YD.xai
// $2a$10$9Yl0CiQ16Zxj1AlPhibq3OQXQnrQEz7PaBz3fK/Bhwg1coNj50dEG