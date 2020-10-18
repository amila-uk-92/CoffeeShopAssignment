package com.global.coffeeshop.controller;

import com.global.coffeeshop.controller.dto.request.LoginDto;
import com.global.coffeeshop.controller.dto.response.AuthenticationResponseDto;
import com.global.coffeeshop.exception.CoffeeShopCustomException;
import com.global.coffeeshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody LoginDto loginDto) throws CoffeeShopCustomException {
        return new ResponseEntity<>(authService.authenticationCheck(loginDto), HttpStatus.OK);
    }
}