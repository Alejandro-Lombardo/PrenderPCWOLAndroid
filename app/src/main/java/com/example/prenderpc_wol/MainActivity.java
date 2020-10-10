package com.example.prenderpc_wol;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {


    Button btnEnviar;
    EditText ipTxt;
    EditText macTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipTxt = findViewById(R.id.ipText);
        macTxt = findViewById(R.id.macText);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final String ip = ipTxt.getText().toString();
                final String mac = macTxt.getText().toString();

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try
                        {
                            WakeOnLAN.main(new String[]{ip, mac});
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });
    }
}

