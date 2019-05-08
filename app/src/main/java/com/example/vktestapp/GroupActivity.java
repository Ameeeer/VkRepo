package com.example.vktestapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.model.VKApiCommunityFull;
import com.vk.sdk.api.model.VKApiModel;

public class GroupActivity extends AppCompatActivity {

    private static final String EXTRA_GROUP_ID = "groupId";

    public static void start(Context context, VKApiModel group) {
        Intent intent = new Intent(context, GroupActivity.class);
        intent.putExtra(EXTRA_GROUP_ID, ((VKApiCommunityFull) group).id);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);
        VKRequest request = new VKApiWall().getById(VKParameters.from(
                VKApiConst.OWNER_ID, 41696672)
        );
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {// ебись сам я устала(((((((((((((
                Object object = response.parsedModel;
                System.out.println(object);
            }
        });
    }

}
