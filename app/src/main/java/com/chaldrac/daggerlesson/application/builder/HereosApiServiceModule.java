package com.chaldrac.daggerlesson.application.builder;

import com.chaldrac.daggerlesson.api.HeroApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HereosApiServiceModule {
    private static final String BASE_URL = "http://coemygroup.fr/";
    private static final String BASE_URL_2 = "https://api.github.com/";

    @AppScope
    @Provides
    HeroApi provideApiService(OkHttpClient client, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory){
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL_2).addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();

        return retrofit.create(HeroApi.class);
    }
}
