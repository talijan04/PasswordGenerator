package rs.in.talijan04.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_DIGIT = 10;

    TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPassword = (TextView) findViewById(R.id.txtPassword);

        String temp_password = passwordGenerator(NUM_DIGIT);
        txtPassword.setText(temp_password);

        initDataFun();
    }


    private void initDataFun() {

        txtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp_password = passwordGenerator(NUM_DIGIT);
                txtPassword.setText(temp_password);
            }
        });
    }


    private String passwordGenerator(int digit){

        String lower_cases = "qwertyuiopasdfghjklzxcvbnm";
        String upper_cases = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String signs = "~!@#$%^&*_+=-";

        String password = "";

        for(int i = 0; i < digit; i++){
            int rand = (int)(3 * Math.random());

            if (i == 0) {
                rand = 1;
            }

            switch(rand){
                case 0:
                    password += String.valueOf((int) (9 * Math.random()));
                    break;
                case 1:
                    rand = (int)(lower_cases.length() * Math.random());
                    password += String.valueOf(lower_cases.charAt(rand));
                    break;
                case 2:
                    rand = (int)(upper_cases.length() * Math.random());
                    password += String.valueOf(upper_cases.charAt(rand));
                    break;
                case 3:
                    rand = (int)(signs.length() * Math.random());
                    password += String.valueOf(signs.charAt(rand));
                    break;
            }
        }

        return password;
    }
}