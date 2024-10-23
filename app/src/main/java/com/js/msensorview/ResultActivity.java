package com.js.msensorview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity
{
	TextView m_oResult;
	
	Button m_oSend;
	
	private String m_sListStr;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        // ???? ????
//        m_oAds = new InterstitialAd(this);
//        m_oAds.setAdUnitId("ca-app-pub-5842532236919481/6619026714");
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//        
//        m_oAds.loadAd(adRequest);
        
        
//        Log.d("jstest", "jstest150817 m_oAds.isLoaded() = "+m_oAds.isLoaded());
        
//        if(m_oAds.isLoaded())
//        {
//        	m_oAds.show();
//        }
        
        m_oResult = (TextView)findViewById(R.id.result);
        
        Intent intent = getIntent();        
        m_sListStr = intent.getStringExtra("ListStr");
        
        m_oResult.setText(m_sListStr);
        
        findViewById(R.id.call4).setOnClickListener(mClickListener);
	}
	
	 Button.OnClickListener mClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId()){
			case R.id.call4:
				if(m_sListStr.length() > 0)
				{
					Intent i=new Intent(Intent.ACTION_SEND);   
					i.addCategory(Intent.CATEGORY_DEFAULT); 
					i.setType("text/plain");
					i.putExtra(Intent.EXTRA_TEXT, m_sListStr);
			        startActivity(Intent.createChooser(i, "Magnetic Sensor Test by Youn"));
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
				}
				break;
			}
		}
		
		 
	 };

}