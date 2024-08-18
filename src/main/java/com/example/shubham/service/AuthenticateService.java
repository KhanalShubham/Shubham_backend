package com.example.shubham.service;

import com.example.shubham.pojo.AuthenticateRequest;
import com.example.shubham.pojo.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
