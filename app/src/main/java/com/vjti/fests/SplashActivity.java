package com.vjti.fests;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.vjti.fests.enthusia.EnthusiaStartActivity;
import com.vjti.fests.pratibimb.PratibimbStartActivity;
import com.vjti.fests.technovanza.TechnovanzaStartActivity;


public class SplashActivity extends Activity implements View.OnClickListener {

    private Handler animationHandler;
    private SplashAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getActionBar().hide();
        } catch (NullPointerException ex) {}
        setContentView(R.layout.activity_splash);

        findViewById(R.id.splash_enthusia).setOnClickListener(this);
        findViewById(R.id.splash_pratibimb).setOnClickListener(this);
        findViewById(R.id.splash_technovanza).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        if (animationHandler == null) {
            animationHandler = new Handler();
            animation = new SplashAnimation();
            animationHandler.postDelayed(animation, 1500);
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        if (animation != null && animationHandler != null)
            animationHandler.removeCallbacks(animation);

        animationHandler = null;
        animation = null;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (animation != null && animationHandler != null)
            animationHandler.removeCallbacks(animation);

        animationHandler = null;
        animation = null;
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.splash_enthusia:
                startActivityWithAnim(EnthusiaStartActivity.class, (int) findViewById(R.id.splash_enthusia).getY());
                break;
            case R.id.splash_pratibimb:
                startActivityWithAnim(PratibimbStartActivity.class, (int) findViewById(R.id.splash_pratibimb).getY());
                break;
            case R.id.splash_technovanza:
                startActivityWithAnim(TechnovanzaStartActivity.class, (int) findViewById(R.id.splash_technovanza).getY());
                break;
            default:
                return;
        }
        finish();
    }

    private void startActivityWithAnim(Class<?> activity, int splitY) {
        ActivitySplitAnimationUtil.startActivity(this, new Intent(this, activity), splitY);
    }

    private class SplashAnimation implements Runnable {

        private float E, P, T;

        @Override
        public void run() {

            E = findViewById(R.id.splash_enthusia).getY();
            P = findViewById(R.id.splash_pratibimb).getY();
            T = findViewById(R.id.splash_technovanza).getY();

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(1500);
            animatorSet.playTogether(enthusia(), pratibimb(), technovanza());
            animatorSet.addListener(getListener());
            animatorSet.setInterpolator(new OvershootInterpolator());
            animatorSet.start();

        }

        private AnimatorSet enthusia() {
            ObjectAnimator translate =  ObjectAnimator.ofFloat(findViewById(R.id.splash_enthusia), View.Y, E, T);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(findViewById(R.id.splash_enthusia), View.ROTATION_X, 0, 360);
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1500);
            set.playTogether(translate, rotate);
            return set;
        }

        private AnimatorSet pratibimb() {
            ObjectAnimator translate =  ObjectAnimator.ofFloat(findViewById(R.id.splash_pratibimb), View.Y, P, E);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(findViewById(R.id.splash_pratibimb), View.ROTATION_X, 0, 360);
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1500);
            set.playTogether(translate, rotate);
            return set;
        }

        private AnimatorSet technovanza() {
            ObjectAnimator translate =  ObjectAnimator.ofFloat(findViewById(R.id.splash_technovanza), View.Y, T, P);
            ObjectAnimator rotate = ObjectAnimator.ofFloat(findViewById(R.id.splash_technovanza), View.ROTATION_X, 0, 360);
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1500);
            set.playTogether(translate, rotate);
            return set;
        }

        private Animator.AnimatorListener getListener() {
            return new Animator.AnimatorListener() {

                private void setListener(boolean enable) {
                    if (enable) {
                        findViewById(R.id.splash_enthusia).setOnClickListener(SplashActivity.this);
                        findViewById(R.id.splash_pratibimb).setOnClickListener(SplashActivity.this);
                        findViewById(R.id.splash_technovanza).setOnClickListener(SplashActivity.this);
                    } else {
                        findViewById(R.id.splash_enthusia).setOnClickListener(null);
                        findViewById(R.id.splash_pratibimb).setOnClickListener(null);
                        findViewById(R.id.splash_technovanza).setOnClickListener(null);
                    }
                }

                @Override
                public void onAnimationStart(Animator animator) {
                    setListener(false);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    setListener(true);
                    if (animationHandler != null)
                        animationHandler.postDelayed(animation, 1500);
                }

                @Override
                public void onAnimationCancel(Animator animator) {}

                @Override
                public void onAnimationRepeat(Animator animator) {}
            };
        }
    }

}