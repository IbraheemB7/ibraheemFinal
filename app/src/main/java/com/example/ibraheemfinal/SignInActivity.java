package com.example.ibraheemfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void checkEmailPassw(){
        boolean isALLOK = true;//يحوي نتيحة فحص الحقول ان كانت سليمه
        String email = etEmail.getText().toString();// استخراج النص من حقل الايميل
        String password = etPassword.getText().toString();//استخراج نص كلمة المرور
        // قحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@")==false)
        {
            // تعديل المتغير ليدل على ان القحص يعطي نتيجة خاطئه
            isALLOK = false;
            //عرض ملاحظة خطا على الشاشة داحل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if(password.length() < 8 || password.contains("") == true)
        {
            isALLOK = false;
            etPassword.setError("Wrong Password");
        }
        if (isALLOK)
            Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();







    }







}