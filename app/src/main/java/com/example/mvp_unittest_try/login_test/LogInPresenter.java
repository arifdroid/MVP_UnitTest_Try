package com.example.mvp_unittest_try.login_test;

public class LogInPresenter {

    private LogInView view;

    //we want to pass view, instead of activity,
    //better to pass interface. like view, and have the activity implemented.

    //constructor
    public LogInPresenter(LogInView view, LoginService service){

        this.view = view;
    }


    public void onClickButtonFromActivity() {
    }
}
