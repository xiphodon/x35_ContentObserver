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
        
        //ע��һ�����ݹ۲��ߣ������������ݿ�ĸı�
        ContentResolver cr = getContentResolver();
        //Uri:�����ĸ�uri�ϵ������ṩ�߷�����֪ͨ
        //notifyForDescendents:true_���Խ�����uriΪ��ͷ��֪ͨ��false_���ܣ�ֻ�ܾ�ȷ���ո�uri������֪ͨ
        cr.registerContentObserver(Uri.parse("content://sms"), true, new SmsObserver(new Handler()));
    }


    class SmsObserver extends ContentObserver{

		public SmsObserver(Handler handler) {
			super(handler);
			// TODO Auto-generated constructor stub
		}
    	//�յ����ݸı��֪ͨʱ���˷�������
		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			
			Toast.makeText(MainActivity.this, "�������¶���֪ͨ", Toast.LENGTH_LONG).show();
		}
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
