package com.example.rutapp.util;

import android.content.Context;

import com.example.rutapp.R;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class UniversalImageLoader {

    private Context context;

    public UniversalImageLoader(Context context){
        this.context = context;
    }

    public void Inicializar() {
        DisplayImageOptions options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.loading)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(options)
                .memoryCache(new LruMemoryCache(20 * 1024 * 1024))
                .memoryCacheSize(20 * 1024 * 1024)
                .build();
        ImageLoader.getInstance().init(config);
    }

}
