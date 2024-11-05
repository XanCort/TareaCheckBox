package com.example.tareacheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public CheckBox checkBox1, checkBox2, checkBox3;
    public ArrayList<String> seleccionados;
    public Button botonEnviar;


    private CompoundButton.OnCheckedChangeListener acrivar = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String text = buttonView.getText().toString();

            if (isChecked) {
                if (!seleccionados.contains(text)) {
                    seleccionados.add(text);
                }
            } else {
                seleccionados.remove(text);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        botonEnviar = findViewById(R.id.botonComer);
        seleccionados = new ArrayList<>();

        checkBox1.setOnCheckedChangeListener(acrivar);
        checkBox2.setOnCheckedChangeListener(acrivar);
        checkBox3.setOnCheckedChangeListener(acrivar);



        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!seleccionados.isEmpty()){
                    ((TextView) findViewById(R.id.textView)).setText(seleccionados.toString());
                }else {
                    ((TextView) findViewById(R.id.textView)).setText("");
                    Toast.makeText(MainActivity.this,"No hay opciones seleccionadas",Toast.LENGTH_SHORT).show();
                }

            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}