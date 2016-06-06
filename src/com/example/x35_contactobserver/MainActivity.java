package com.example.x35_contactobserver;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //注册一个内容观察者，监听短信数据库的改变
        ContentResolver cr = getContentResolver();
        //Uri:监听哪个uri上的内容提供者发出的通知
        //notifyForDescendents:true_可以接收以uri为开头的通知，false_则不能，只能精确接收该uri发出的通知
        cr.registerContentObserver(Uri.parse("content://sms"), true, new SmsObserver(new Handler()));
    }


    class SmsObserver extends ContentObserver{

		public SmsObserver(Handler handler) {
			super(handler);
			// TODO Auto-generated constructor stub
		}
    	//收到数据改变的通知时，此方法调用
		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			
			Toast.makeText(MainActivity.this, "监听到新短信通知", Toast.LENGTH_LONG).show();
		}
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
