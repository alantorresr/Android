package alan.torres.com.appexamen;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreenActivity extends Activity {

    LottieAnimationView lottieAnimationView;
    private static int SPLASH_TIME_OUT = 4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        startCheckAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    private void startCheckAnimation(){
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1f).setDuration(8000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((Float) animation.getAnimatedValue());
            }
        });
        if (lottieAnimationView.getProgress() == 0f){
            animator.setStartDelay(1500);
            animator.start();
        }else {
            lottieAnimationView.setProgress(0f);
        }
    }

    public void Iniciador(){



    }

    public void Eventos(){


    }

}
