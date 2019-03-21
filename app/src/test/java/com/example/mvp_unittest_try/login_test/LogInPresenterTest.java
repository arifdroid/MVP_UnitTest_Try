package com.example.mvp_unittest_try.login_test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//unit testing

@RunWith(MockitoJUnitRunner.class)
public class LogInPresenterTest {

    //we mock the view, and service

    @Mock
    private LogInView view;
    @Mock
    private LoginService service;

    private LogInPresenter presenter;

    //so the data input will be implemented with MOCKito.

    //before we start to test, we need to mock our input
    //now we need reference to our presenter
    @Before
    public void setUp() throws Exception {

        presenter = new LogInPresenter(view,service);

    }

    @Test
    public void shouldShowErrorIfUsernameEmpty()throws Exception  {


        //we set expectation , when username is empty, should return zero.
        when(view.getUsername()).thenReturn("");
        presenter.onClickButtonFromActivity();

        //we want to show error

        verify(view).showUserNameError("error user name");
    }
}