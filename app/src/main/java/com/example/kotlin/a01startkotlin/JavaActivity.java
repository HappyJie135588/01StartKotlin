package com.example.kotlin.a01startkotlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.kotlin.a01startkotlin.animal.AnimalDefault;

public class JavaActivity extends AppCompatActivity {

    private TextView tv_hello;
    private Button btn_click;
    private Button btn_click_long;
    private Button btn_toast;
    private Button btn_toast_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        tv_hello = findViewById(R.id.tv_hello);
        btn_click = findViewById(R.id.btn_click);
        btn_click_long = findViewById(R.id.btn_click_long);
        btn_toast = findViewById(R.id.btn_toast);
        btn_toast_long = findViewById(R.id.btn_toast_long);
        btn_click.setOnClickListener(v ->
                btn_click.setText("你点了一下下")
        );
        btn_click.setOnClickListener(v -> {
            btn_click.setText("你点了一下下");
            btn_click.setText("你点了一下下");
            AnimalDefault 公牛 = new AnimalDefault(this, "牛");
            AnimalDefault 母牛 = new AnimalDefault(this, "牛", 0);
        });
    }
}
