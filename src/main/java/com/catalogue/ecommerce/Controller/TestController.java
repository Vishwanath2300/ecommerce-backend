package com.catalogue.ecommerce.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public class testing{

        public testing(String test){
            this.test=test;
        }
        public String getTest() {

            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        private String test;


    }

    @GetMapping("/test")

    private ResponseEntity<?> testing(){
        String result="working successfully";
        return ResponseEntity.ok(new testing(result));

    }
}
