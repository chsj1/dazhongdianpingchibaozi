package com.example.runningmantest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_runing_man);
        
        
    }

    
    public void showmeidialog(View v){
    	System.out.println("--------->你单击了美团的对话框");
    	
    	CustomProgressDialog dialog = new CustomProgressDialog(this, "黄俊东是一个大帅哥...", R.anim.frame);
    	dialog.show();
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
