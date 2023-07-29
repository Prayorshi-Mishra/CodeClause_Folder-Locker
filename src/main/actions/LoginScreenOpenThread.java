package main.actions;

import main.LoginBackground;
import main.MainPage;

public class LoginScreenOpenThread extends Thread{

    @Override
    public void run(){
        for(int i=1; i<=715; i++){

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LoginBackground.loginBackground.setLocation(i,0);
        }
        MainPage.mainGround.setVisible(true);
    }
}
