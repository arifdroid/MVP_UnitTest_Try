package com.example.mvp_unittest_try.login_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp_unittest_try.R;

public class Login_Activity extends AppCompatActivity implements LogInView{

    // https://www.youtube.com/watch?v=Asc4hU1iSTU

    // https://github.com/vivekjain10/AndroidUnitTesting


    private EditText editTextName;
    private EditText editTextPassword;
    private Button button;
    private TextView textView;

    LogInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        editTextName = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button);

        textView = findViewById(R.id.textView);


        //we need to introduce presenter.

        presenter = new LogInPresenter(this,new LoginService());

        //first usually we write it like this.
        button.setOnClickListener(new View.OnClickListener() {

            //now we can pass all the logic to presenter?
            @Override
            public void onClick(View v) {

                presenter.onClickButtonFromActivity();


                String name = editTextName.getText().toString();
                String pass = editTextPassword.getText().toString();

                if(!name.isEmpty() && !pass.isEmpty()){

                    textView.setText("success");
                }else {
                    textView.setText("failed");
                }
            }
        });

    }

    @Override
    public String getUsername() {
        //get from ui
        return editTextName.getText().toString();
    }

    @Override
    public void showUserNameError(String wrongUsername) {
        editTextName.setError(wrongUsername);
    }
}
