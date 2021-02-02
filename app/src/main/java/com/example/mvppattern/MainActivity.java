package com.example.mvppattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvppattern.Presenter.ILoginPresenter;
import com.example.mvppattern.Presenter.LoginPresenter;
import com.example.mvppattern.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

  EditText usernameET,passwordET;
  Button loginBT;
  ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        loginBT = findViewById(R.id.login);

        iLoginPresenter = new LoginPresenter(this);

        loginBT.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            iLoginPresenter.onLogin(usernameET.getText().toString(),passwordET.getText().toString());
          }
        });
    }


  @Override
  public void onLoginResult(String message) {
    Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
  }
}
