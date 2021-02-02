package com.example.mvppattern.Presenter;

import com.example.mvppattern.MainActivity;
import com.example.mvppattern.Model.User;
import com.example.mvppattern.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

  ILoginView iLoginView;

  public LoginPresenter(ILoginView iLoginView) {
    this.iLoginView = iLoginView;
  }


  @Override
  public void onLogin(String email, String password) {
    User user = new User(email,password);
    boolean isLoginSuccess = user.isValidData();

    if (isLoginSuccess)
      iLoginView.onLoginResult("Login Successfull");
    else
      iLoginView.onLoginResult("Login Fails");
  }
}
