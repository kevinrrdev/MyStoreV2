package com.example.kechaval.mystorev2.modules.cake.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.kechaval.mystorev2.R;
import com.example.kechaval.mystorev2.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {


    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        //do
        setStatusBarTranslucent(true);
        startAnimation();

    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_transition);
        ivLogo.startAnimation(animation);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this,
                            LoginActivity.class);

                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }



}
