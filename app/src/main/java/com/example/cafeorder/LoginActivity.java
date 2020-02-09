package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //создаём перпеменные для получения логина и пароля
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //связываем
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    //делаем кнопку
    public void onClickCreateOrder(View view) {
        //получаем данные из пароля и логина, приводим к стринг и убираем пробелы
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        //делаем проверку на пустоту
        if (!name.isEmpty() && !password.isEmpty()) {
            //делаем переход
            Intent intent = new Intent(this, CreateOrderActivity.class);
            //вкладываем имя и пароль
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
            //если не не ок - вызываем тост
        } else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_LONG).show();
        }

    }
}
