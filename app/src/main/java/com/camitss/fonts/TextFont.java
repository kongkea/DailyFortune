package com.camitss.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.Choreographer;
import android.view.View;
import android.widget.TextView;

import java.util.jar.Attributes;

/**
 * Created by kongkea on 12/22/2014.
 */
public class TextFont extends TextView {

    private final static String NAME = "FONTHANUMAN";
    private static LruCache<String, Typeface> sTypefaceLruCache = new LruCache<String, Typeface>(12);

    public TextFont(Context context, AttributeSet attributes, int defStyle){
        super(context, attributes, defStyle);
        if(!isInEditMode()){
            init();
        }

    }

    public TextFont(Context context, AttributeSet attributes){
        super(context,attributes);
        if(!isInEditMode()){
            init();
        }

    }

    public TextFont(Context context){
        super(context);
        if (!isInEditMode()){
            init();
        }

    }



    public void init(){
        Typeface typeface = sTypefaceLruCache.get(NAME);
        if(typeface == null){
            typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Hanuman.ttf");
            sTypefaceLruCache.put(NAME, typeface);
        }

        setTypeface(typeface);
    }
}
