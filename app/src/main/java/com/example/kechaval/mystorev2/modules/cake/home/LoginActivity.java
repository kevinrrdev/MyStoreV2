package com.example.kechaval.mystorev2.modules.cake.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kechaval.mystorev2.R;
import com.example.kechaval.mystorev2.base.BaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.etLoginID)
    TextInputEditText etLoginID;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;
    @BindView(R.id.tvSignup)
    TextView tvSignup;

    private FirebaseAuth mAuth;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        //do
        setStatusBarTranslucent(true);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.btnLogin, R.id.tvSignup})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btnLogin:
                showDialog("Ingresando..");
                mAuth.signInWithEmailAndPassword(etLoginID.getText().toString(), etPassword.getText().toString())
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                hideDialog();
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (!user.getEmail().equals("")){
                                    Intent intentMainActivity = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intentMainActivity);
                                    Toast.makeText(LoginActivity.this, "Bienvenido",
                                            Toast.LENGTH_SHORT).show();
                                    //showDialog("¡Bienvenido!");
                                    finish();
                                }

                            } else {
                                hideDialog();
                                // If sign in fails, display a message to the user.
                                Log.d(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Email o Password Incorrecto.",
                                        Toast.LENGTH_SHORT).show();
                            }
                            // ...
                        });
                break;
            case R.id.tvSignup:
                Intent intentSignUp = new Intent(this,RegisterActivity.class);
                startActivity(intentSignUp);
                break;
        }
    }
}
