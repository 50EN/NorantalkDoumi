/*this is the baseactivity for every MainActivity Class*/

package com.soen.norantalkdoumi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//AppCompatActivity 안드로이드 하위버전(API 11 안드로이드 3.0)도 지원 Activity말고 AppCompatActivity 사용

public class BaseActivity extends AppCompatActivity{
    private static PageListener pageListener;

    public static void setListener(PageListener listener){
            pageListener = listener;
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(pageListener != null){
            pageListener.onActivityCreated(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(pageListener != null){
            pageListener.onActivityStarted(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(pageListener != null){
            pageListener.onActivityResumed(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(pageListener != null){
            pageListener.onActivityPaused(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(pageListener != null){
            pageListener.onActivityStopped(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(pageListener != null){
            pageListener.onActivityDestroyed(this);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if(pageListener != null){
            pageListener.onActivitySaveInstanceState(this);
        }
    }
}