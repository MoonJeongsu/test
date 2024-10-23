package com.js.msensorview.dialog;

//import static android.os.Build.VERSION_CODES.R;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.js.msensorview.R;

/**
 * 
 * type- 1 : 버튼 하나, 기본 팝업 
 * 		 2 : 버튼 하나, 포커스메세지(v) 있는 팝업 (등록완료팝업, 연결오류알림팝업) 
 * 		 3 : 버튼(닫기) 하나, 메세지(h) 있는 팝업 (앱버전정보없을때팝업) 
 * 		 4 : 버튼 둘, 기본팝업 (알림팝업) 
 * 		 5 : 버튼 둘, 포커스메세지(v) 있는 팝업 (접수완료팝업) 
 * 		 6 : 버튼 둘, 포커스메세지(h) 있는 팝업 (앱버전정보있을때팝업)
 * 
 */
public class BasicPopup extends Dialog {

	private TextView tv_title;
	
	private LinearLayout ll_defaltcontent;
//	private LinearLayout ll_vfocuscontent;
//	private LinearLayout ll_hfocuscontent;

	private TextView tv_defalt;
//	private TextView tv_vfocus;
//	private TextView tv_vdefalt;
//	private TextView tv_hdefalt;
//	private TextView tv_hfocus;
//	private TextView tv_hcontent;

	public Button bt_firstbutton;
	public Button bt_secondbutton;
	private View.OnClickListener listener1;
	private View.OnClickListener listener2;
	
	private String tag;

	public BasicPopup(final Context context, int resTitle,
                      int resMessage) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(context.getString(resTitle), context.getString(resMessage), "", "확인", null, null);
	}
	
	public BasicPopup(final Context context, String title,
                      String message) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(title, message, "", "확인", null, null);
	}
	
	public BasicPopup(final Context context, int resTitle,
                      int resMessage, int resButton) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(context.getString(resTitle), context.getString(resMessage), "", context.getString(resButton), null, null);
	}
	
	public BasicPopup(final Context context, String title,
                      String message, String button) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(title, message, "", button, null, null);
	}
	
	public BasicPopup(final Context context, int resTitle,
                      int resMessage, int resButton, View.OnClickListener listener) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(context.getString(resTitle), context.getString(resMessage), "", context.getString(resButton), null, listener);
	}
	
	public BasicPopup(final Context context, String title,
                      String message, String button, View.OnClickListener listener) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(title, message, "", button, null, listener);
	}
	
	public BasicPopup(final Context context, int resTitle,
                      int resMessage, int resButton1, View.OnClickListener listener1, int resButton2, View.OnClickListener listener2) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(context.getString(resTitle), context.getString(resMessage), context.getString(resButton1), context.getString(resButton2), listener1, listener2);
	}
	
	public BasicPopup(final Context context, String title,
                      String message, String button1, View.OnClickListener listener1, String button2, View.OnClickListener listener2) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		
		initViews(title, message, button1, button2, listener1, listener2);
	}
	
	private void initViews(String title,
			String message, String button1, String button2, View.OnClickListener listener1, View.OnClickListener listener2){
		setContentView(R.layout.popup_basic);
		
		tv_title = (TextView) findViewById(R.id.tv_title);
		ll_defaltcontent = (LinearLayout) findViewById(R.id.ll_defaltcontent);

		tv_defalt = (TextView) findViewById(R.id.tv_defalt);

		bt_firstbutton = (Button) findViewById(R.id.bt_firstbutton);
		bt_secondbutton = (Button) findViewById(R.id.bt_secondbutton);

		tv_title.setText(title);
		if(message != null && message.length() > 0){
			//message.replace("\n", "<br/>");
			tv_defalt.setText(Html.fromHtml(message));
		}
		
		if(button1 == null || button1.length() == 0){
			bt_firstbutton.setVisibility(View.GONE);
		}
		else{
			bt_firstbutton.setText(button1);
			
			if(listener1 == null){
				this.listener1 = new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						dismiss();
					}
				};
			}
			else{
				this.listener1 = listener1;
			}
			
			bt_firstbutton.setOnClickListener(this.listener1);
			
		}
		
		if(button2 == null || button2.length() == 0){
			bt_secondbutton.setVisibility(View.GONE);
		}
		else{
			bt_secondbutton.setText(button2);
			
			if(listener2 == null){
				this.listener2 = new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						dismiss();
					}
				};
			}
			else{
				this.listener2 = listener2;
			}
			
			bt_secondbutton.setOnClickListener(this.listener2);
		}
		
	}

	@Override
	public void onBackPressed() {
		if(bt_secondbutton.getVisibility() == View.VISIBLE){
			if(listener2 != null){
				listener2.onClick(null);
			}
		}
		else if(bt_firstbutton.getVisibility() == View.VISIBLE){
			if(listener1 != null){
				listener1.onClick(null);
			}
		}
		
		super.onBackPressed();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	

}
