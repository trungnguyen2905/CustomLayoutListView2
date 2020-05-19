package com.example.customlayoutlistview;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class SendSms {
    private Context context;
    public Boolean composeSmsMessage(String to, String message) {
        if (!TextUtils.isEmpty(to) && !TextUtils.isEmpty(message)) {
            if (checkPermission(Manifest.permission.SEND_SMS)) {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(to.toString(), null, message.toString(), null, null);
                Toast.makeText(context, "Đặt thành công", Toast.LENGTH_SHORT).show();
                return true;

            }
        } else
            Toast.makeText(context, "Nhập số điện thoại ?", Toast.LENGTH_SHORT).show();
        return false;
    }

    private boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(context, permission);
        return check == PackageManager.PERMISSION_GRANTED;
    }

    public SendSms(Context context) {
        this.context = context;
    }
}
