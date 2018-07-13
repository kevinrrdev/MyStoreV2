package com.example.kechaval.mystorev2.modules.cake.details;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kechaval.mystorev2.R;
import com.example.kechaval.mystorev2.base.BaseActivity;
import com.example.kechaval.mystorev2.helper.ImageHandler;
import com.example.kechaval.mystorev2.mvp.model.Cake;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {

    public static final String CAKE = "cake";

    @BindView(R.id.cakeImage) protected ImageView mCakeImage;
    @BindView(R.id.cakeTitle) protected TextView mCakeTitle;
    @BindView(R.id.cakeDescription) protected TextView mCakeDescription;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCakeImage.setTransitionName("cakeImageAnimation");
        }

        showBackArrow();

        Cake cake = (Cake) intent.getSerializableExtra(CAKE);
        setTitle("Cake Detail");

        mCakeTitle.setText(cake.getTitle());
        mCakeDescription.setText(cake.getDetailDescription());

        Glide.with(this).load(cake.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new ImageHandler(mCakeImage));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

