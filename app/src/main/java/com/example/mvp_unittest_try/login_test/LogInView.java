package com.example.mvp_unittest_try.login_test;

public interface LogInView {
    String getUsername();

    void showUserNameError(String wrongUsername);
}
