package com.example.kechaval.mystorev2.modules.cake.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
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

public class RegisterActivity extends BaseActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btnRegistrar)
    AppCompatButton btnRegistrar;
    @BindView(R.id.fabSalir)
    FloatingActionButton fabSalir;


    private FirebaseAuth mAuth;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        //do
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        setStatusBarTranslucent(true);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }


    @OnClick({R.id.btnRegistrar,R.id.fabSalir})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btnRegistrar:
                showDialog("Registrando.");
                mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                hideDialog();
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (!user.getEmail().equals("")){
                                    Toast.makeText(this, "¡Registro correcto!",
                                            Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                            } else {
                                hideDialog();
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(this, "Registro incorrecto",
                                        Toast.LENGTH_SHORT).show();
                            }
                            // ...
                        });
                break;
            case R.id.fabSalir:
                finish();
                break;
        }


    }
}
