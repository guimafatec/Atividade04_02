package br.edu.fateczl.atividade04_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private Button btnCalc;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etValor = findViewById(R.id.etValor);
        btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);
        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc() {
        int valor = Integer.parseInt(etValor.getText().toString());
        if (valor < 100 || valor > 999) {
            tvRes.setText("Valor Incorreto");
            return;
        }
        int unidade = valor / 10;
        valor /= 10;
        int dezena = valor / 10;
        valor /= 10;
        int centena = valor / 10;

        String res;
        res = "CENTENA = " + centena + "\n";
        res += "DEZENA = " + dezena + "\n";
        res += "UNIDADE = " + unidade + "\n";
        tvRes.setText(res);
    }
}