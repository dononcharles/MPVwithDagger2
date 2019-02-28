package com.chaldrac.daggerlesson.ui.splash.core;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.chaldrac.daggerlesson.R;
import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import com.google.android.material.button.MaterialButton;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import kotlin.Unit;

public class SplashView {
    private View view;

    @BindView(R.id.enterSplash) MaterialButton enterSplash;

    public SplashView(SplashScreenActivity context){
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash_screen, parent, true);
        ButterKnife.bind(this, view);
    }

    Observable<Unit> enterSplashOnClick(){
        return RxView.clicks(enterSplash);
    }

    public View constructView(){
        return view;
    }

}
