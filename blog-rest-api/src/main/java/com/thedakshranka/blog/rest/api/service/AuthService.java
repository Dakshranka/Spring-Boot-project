package com.thedakshranka.blog.rest.api.service;

import com.thedakshranka.blog.rest.api.payload.LoginDto;
import com.thedakshranka.blog.rest.api.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
