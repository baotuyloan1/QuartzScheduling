package com.example.quartzscheduling.quartzJob.service.impl;

import com.example.quartzscheduling.quartzJob.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author BAO 7/18/2023
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void handleUser() {
    System.out.println("handle User message");
    }
}
