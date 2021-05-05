package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText plaintextEt,keyEt;
    TextView encryptionTv;
    Button encryptBtn;
    String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plaintextEt = findViewById(R.id.plaintext_et);
        keyEt = findViewById(R.id.key_et);
        encryptionTv = findViewById(R.id.encrypted_tv);
        encryptBtn = findViewById(R.id.encrypt_btn);

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plaitext = plaintextEt.getText().toString();
                int key = Integer.parseInt(keyEt.getText().toString().trim());
                for (int i = 0; i < plaitext.length(); i++) {
                    for (int j = 0; j <26 ; j++) {
                        if (plaitext.charAt(i) == lowerCase.charAt(j)){
                            char lower = lowerCase.charAt((j + key) % 26);
                            result +=lower;
                            encryptionTv.setText(""+result);

                        }else if (plaitext.charAt(i) == upperCase.charAt(j)){
                            char upper = upperCase.charAt((j + key) % 26);
                            result+=upper;
                            encryptionTv.setText(""+result);

                        }
                    }
                }
            }
        });
    }
}