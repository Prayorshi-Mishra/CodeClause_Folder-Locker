package main.actions;

import main.LoginBackground;
import main.MainPage;

public class LoginScreenCloseThread extends Thread{

        public void run(){
            MainPage.mainGround.setVisible(false);
            for(int i=715; i>=1; i--){

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LoginBackground.loginBackground.setLocation(i,0);
            }
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
}
