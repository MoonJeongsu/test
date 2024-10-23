package com.js.msensorview;

import static android.content.ContentValues.TAG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fsn.cauly.CaulyAdInfo;
import com.fsn.cauly.CaulyAdInfoBuilder;
import com.fsn.cauly.CaulyInterstitialAd;
import com.fsn.cauly.CaulyInterstitialAdListener;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;
import com.js.msensorview.dialog.BasicPopup;

public class AndroidSensorActivity extends Activity implements SensorEventListener, CaulyInterstitialAdListener {
    /** Called when the activity is first created. */
	
	SensorManager sm;
	SensorEventListener accL;
	SensorEventListener oriL;
	SensorEventListener ligL;
	SensorEventListener magL;
	SensorEventListener preL;
	SensorEventListener proxL;
	SensorEventListener tempL;
	
	Sensor oriSensor; // 방향
	Sensor accSensor; // 가속도
	Sensor rotSensor; // 회전
	Sensor ligSensor; // 밝기
	Sensor magSensor; // 자기
	Sensor preSensor; // 압력
	Sensor proxSensor; // 근접
	Sensor tempSensor; // 온도
	
	float maxAccX;
	float maxAccY;
	float maxAccZ;
	
	TextView ori, acc, rot, lig, mag, pre, prox, temp;
	TextView maxAcc;
	EditText m_oInput;
	EditText m_oInput2;
	
	TextView m_oTeslaXYZ;
	TextView m_oWaring;
	TextView m_oPitch;
	TextView m_oPitchText;
	TextView m_oPosY;
	TextView m_oPosX;
	TextView m_oPosZ;
	TextView m_oTime;
	TextView m_oLoadXyz;
	
	
	SharedPreferences setting;
	SharedPreferences.Editor editor;
	
	Vibrator m_oVibe;
	
	Clock m_oClock;

    SharedPreferences sharedPref;

    // 아래와 같이 전면 광고 표시 여부 플래그를 사용하면, 전면 광고 수신 후, 노출 여부를 선택할 수 있다.
    private boolean showInterstitial = false;
    private static final String APP_CODE = "WHLNO12J";

    private Context mContext = null;
//	InterstitialAd interstitialAd;
//    AdView main_Banner_AdView;
//    AdRequest adRequest;


	
	public static final String STRSAVEPATH = Environment.
            getExternalStorageDirectory()+"/magneticSavefolder/";
    public static final String STRSAVEPATH2 = Environment.
            getExternalStorageDirectory()+"/magneticSavefolder2/";
    public static final String SAVEFILEPATH = "MyFile.txt";
    // 권한 요청 코드
    private static final int STORAGE_PERMISSION_CODE = 100;

//    public MainHandler mainHandler = new MainHandler();

    // 전면 광고 생성
    CaulyInterstitialAd interstial;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

        //jstest240902
        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ClickInt", 0);
        editor.apply();

        setContentView(R.layout.main);

        mContext = this;
//        PermissionSetting();
        checkFilePermission(mContext);
        // 외부 저장소 권한 체크 및 요청
//        checkStoragePermission();

        // CaulyAdInfo 생성
        CaulyAdInfo adInfo = new CaulyAdInfoBuilder(APP_CODE).build();

        // 전면 광고 생성
        interstial = new CaulyInterstitialAd();
        interstial.setAdInfo(adInfo);
        interstial.setInterstialAdListener(this);

        // 전면광고 노출 후 back 버튼 사용을 막기 원할 경우 disableBackKey();을 추가한다
        // 단, requestInterstitialAd 위에서 추가되어야 합니다.
        interstial.disableBackKey();

        // 광고 요청. 광고 노출은 CaulyInterstitialAdListener의 onReceiveInterstitialAd에서 처리한다.
//        interstial.requestInterstitialAd(this);
        // 전면 광고 노출 플래그 활성화
//        showInterstitial = true;
        //

       //폴더 생성
        File dir = makeDirectory(STRSAVEPATH);
        
        m_ofile = new File(STRSAVEPATH);
        
        m_oToday = new Date (); 
        
        m_oClock = new Clock();
        m_oClock.setDaemon(true);
		m_oClock.start();
        
        sm = (SensorManager)getSystemService(SENSOR_SERVICE); 
        
        m_oVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);         
        
        if(sm == null)
        {
        	Toast.makeText(getApplicationContext(), "No MAGNETIC Sensor", Toast.LENGTH_SHORT).show();
        }
        
        oriSensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION); // 방향
        accSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // 가속도
        rotSensor = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE); // 회전
        ligSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT); // 밝기
        magSensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); // 자력
        preSensor = sm.getDefaultSensor(Sensor.TYPE_PRESSURE); // 압력
        proxSensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY); // 근접
        tempSensor = sm.getDefaultSensor(Sensor.TYPE_TEMPERATURE); // 온도
        
//        ori = (TextView)findViewById(R.id.ori);
//        acc = (TextView)findViewById(R.id.acc);
//        rot = (TextView)findViewById(R.id.rot);
//        lig = (TextView)findViewById(R.id.lig);
        mag = (TextView)findViewById(R.id.mag);
//        pre = (TextView)findViewById(R.id.pre);
//        prox = (TextView)findViewById(R.id.prox);
//        temp = (TextView)findViewById(R.id.temp);
//        maxAcc = (TextView)findViewById(R.id.maxAcc);
        
//        m_oInput = (EditText) findViewById(R.id.newitem);
        // jstest150729
//        m_oInput2 = (EditText) findViewById(R.id.newitem1);
        
        m_oTeslaXYZ = (TextView)findViewById(R.id.teslaxyz);
  
        // jstest150729
        m_oWaring = (TextView)findViewById(R.id.waring);
        
        m_oPitch =  (TextView)findViewById(R.id.pitch);
        m_oPitchText = (TextView)findViewById(R.id.pitchtext);
        m_oPosY = (TextView)findViewById(R.id.ypos1);
        m_oPosX = (TextView)findViewById(R.id.xpos1);
        m_oPosZ = (TextView)findViewById(R.id.zpos1);
        
//        m_oTime = (TextView)findViewById(R.id.time);
//        m_oLoadXyz = (TextView)findViewById(R.id.load_xyz);
        
        maxAccX = -10;
        maxAccY = -10;
        maxAccZ = -10;
        
        setting = getSharedPreferences("setting", 0);
        editor= setting.edit();

        findViewById(R.id.call2).setOnClickListener(mClickListener);
        findViewById(R.id.call3).setOnClickListener(mClickListener);

        initLayout();
        
    }

    public static void checkFilePermission(Context mContext){

        // [안드로이드 os 11 버전 이상 체크 수행 실시]
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) && !isFileGranted(mContext)){
            // [안드로이드 R 버전 이상 파일 접근 권한 필요]
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
            Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
            intent.setData(uri);
            mContext.startActivity(intent);
        }
        else if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) && isFileGranted(mContext)) {
            Log.i("---","---");
            Log.w("//===========//","================================================");
            Log.i("","\n"+"[C_Permission >> checkFilePermission() :: 앱 파일 접근 권한 상태 확인]");
            Log.i("","\n"+"[상태 :: "+"앱 파일 접근 권한 부여된 상태"+"]");
            Log.w("//===========//","================================================");
            Log.i("---","---");
        }
        else {
            Log.i("---","---");
            Log.d("//===========//","================================================");
            Log.i("","\n"+"[C_Permission >> checkFilePermission() :: 앱 파일 접근 권한 상태 확인]");
            Log.i("","\n"+"[상태 :: "+"Android 11 버전 미만 단말기"+"]");
            Log.d("//===========//","================================================");
            Log.i("---","---");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private static boolean isFileGranted(Context mContext) {
        boolean granted = false; // 권한 부여 상태값 저장

        try {
            // [파일 접근 권한이 허용 된 경우]
            if (Environment.isExternalStorageManager() == true){
                granted = true;
            }
            else {
                granted = false;
            }
        }
        catch (Throwable why) {
            //why.printStackTrace();
        }

        return granted;
    }

    @Override
    public void onReceiveInterstitialAd(CaulyInterstitialAd caulyInterstitialAd, boolean b) {
            caulyInterstitialAd.show();
    }

    @Override
    public void onFailedToReceiveInterstitialAd(CaulyInterstitialAd caulyInterstitialAd, int i, String s) {

    }

    @Override
    public void onClosedInterstitialAd(CaulyInterstitialAd caulyInterstitialAd) {

    }

    @Override
    public void onLeaveInterstitialAd(CaulyInterstitialAd caulyInterstitialAd) {

    }

    int m_listpos;
    
    float[] xyz = new float[3];
    String m_sTotalMeeting;
    private Date m_oToday;
    private Handler mHandler;
    boolean m_bThread = false;
    
    class Clock extends Thread
    {
    	public void run()
    	{
    		while(true)
    		{
//				 
    			Handler mHandler = new Handler(Looper.getMainLooper());
    			
    			mHandler.postDelayed(new Runnable() {

	    				@Override
	    				public void run() {
	
	    					if(m_bThread)
	    					{
		    					long now = System.currentTimeMillis();
		    					Date date = new Date(now);
		    					
		    					SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    					String strNow = sdfNow.format(date);
		    					
		    					String mill = Integer.toString(milligauss);
//		    					m_nInputY = Integer.parseInt(m_oInput2.getText().toString());
//		    					String input = Integer.toString(m_nInputY);
		    					
		    					Toast.makeText(getApplicationContext(), "Saving", Toast.LENGTH_SHORT).show();
		    					// 파일 저장 위치
		    					m_sTotalMeeting = m_sTotalMeeting +"\n\n"+"Save Time : "+strNow+"\n"
		    									+"X : "+Float.toString(xyz[0])+"\n"
		    									+"Y : "+Float.toString(xyz[1])+"\n"
		    									+"Z : "+Float.toString(xyz[2])+"\n"
		    									+"Microtesla : "+Float.toString(teslaXYZ)+"\n"
		    									+"Milligauss : "+mill+"\n"
		    									+"Azimuth : "+Float.toString(mOri[0])+"\n"
		    									+"Pitch : "+Float.toString(mOri[1])+"\n"
		    									+"Roll : "+Float.toString(mOri[2]);
//		    									+"Roll : "+Float.toString(mOri[2])+"\n"
//		    									+"Microtesla 범위 입력값 : "+input;
		    					
		    					// Azimuth(방위), Pitch(경사도), Roll(좌우회전) 
		    					//폴더 생성
		    			        File dir = makeDirectory(STRSAVEPATH);
		    			        //파일 생성
		    			        File ofile = makeFile(dir, (STRSAVEPATH+"20"+String.valueOf(m_oToday.getYear()-100)+"."+String.valueOf(m_oToday.getMonth()+1)+"."
		    			        							+String.valueOf(m_oToday.getDate())+"."+String.valueOf(m_oToday.getHours())+"."+String.valueOf(m_oToday.getMinutes())+"."+String.valueOf(m_oToday.getSeconds())+".txt"));
		    			        
		    			        //절대 경로
		    			        Log.i("jstest", "jstest150727 dir = "+getAbsolutePath(dir));
		    			        Log.i("jstest", "jstest150727 file = "+getAbsolutePath(ofile));
		
		    			        //파일 쓰기
		    			        writeFile(ofile , m_sTotalMeeting.getBytes());
	    					}
	
	    				}

    				}, 0);
			        
    			try
    			{
    				Thread.sleep(1000);
    			}
    			catch(InterruptedException e)
    			{
    				Log.d("jstest150727", "jstest150727 InterruptedException e = "+e);
    			}
    		}
    	}
    }
    
    ListView list;
	ArrayList<String> arListView = new ArrayList<String>();
	
    int m_nFileSize;
    String[] m_oListStr = new String[1000];
    File m_ofile;
    
    Button.OnClickListener mClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId()){
			case R.id.call2: // 저장

                //jstest240902
                sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                int myGlobalInt = sharedPref.getInt("ClickInt", 0);

                Log.d("jstest240902", "jstest240902 myGlobalInt: " + myGlobalInt);

                if(myGlobalInt == 1) {
                    m_bThread = true;
                }
				else {
                        Toast.makeText(AndroidSensorActivity.this, "원활한 운영을 위해 광고를 클릭해 주셔야 서비스 이용이 가능 합니다.", Toast.LENGTH_LONG).show();
                    }
				
				break;
			case R.id.call3: // stop
				
				m_bThread = false;
				
				initLayout();
				break;
			}
		}	
    	
    };
    
    private void initLayout() {

        int index;

        arListView.clear();

        // 파일이 1개 이상이면 파일 이름 출력
//        if (m_ofile.listFiles().length > 0) {

        File[] files = m_ofile.listFiles();
        if(files == null) return;

            if (m_ofile.isDirectory() && m_ofile.listFiles().length > 0) {
                for (File f : m_ofile.listFiles()) {
                    index = f.getName().indexOf(".txt");
                    Log.d("", "jstest121229 index = " + index);
                    if (index > 0) {
                        Log.d("", "jstest121229 f.getName() = " + f.getName());
                        m_oListStr[m_nFileSize] = f.getName().substring(0, index);
                        arListView.add(m_oListStr[m_nFileSize]);
                        m_nFileSize++;
                    }
                }
            }

            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    arListView);
            list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);

            list.setDivider(new ColorDrawable(0xff000000));
            list.setDividerHeight(1);
            list.setOnItemClickListener(mItemClickListener);
//		list.setOnItemLongClickListener(mItemLonhClickListener);
    }
    
    public int listPos;
    
    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView parent, View view, int position, long id) {

            //jstest240902
            sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            int myGlobalInt = sharedPref.getInt("ClickInt", 0);

            Log.d("jstest240902", "jstest240902 myGlobalInt: " + myGlobalInt);

            if(myGlobalInt == 1) {
                m_listpos = position;
//		        //폴더 생성
                File dir = makeDirectory(STRSAVEPATH);
                //파일 생성
                File ofile = makeFile(dir, (STRSAVEPATH + arListView.get(position).toString() + ".txt"));

                arr.clear();
                listPos = position;
                readFile(ofile);
//		          
                Intent intent;
//					
                intent = new Intent(AndroidSensorActivity.this, ResultActivity.class);
//		    		intent.putExtra("ListStr", arListView.get(position).toString());
                intent.putExtra("ListStr", arr.toString());
                startActivity(intent);
            }
            else {
                Toast.makeText(AndroidSensorActivity.this, "원활한 운영을 위해 광고를 클릭해 주셔야 서비스 이용이 가능 합니다.", Toast.LENGTH_LONG).show();
            }
		    		

		}
	};
	
    /**
     * 디렉토리 생성 
     * @return dir
     */
    private File makeDirectory(String dir_path){
        File dir = new File(dir_path);
        if (!dir.exists())
        {
            dir.mkdirs();
            Log.i( "jstest" , "jstest !dir.exists" );
        }else{
            Log.i( "jstest" , "jstest dir.exists" );
        }
 
        return dir;
    }
    
    /**
     * 파일 생성
     * @param dir
     * @return file 
     */
    private File makeFile(File dir , String file_path){
        File file = null;
        boolean isSuccess = false;
        if(dir.isDirectory()){
            file = new File(file_path);
            if(file!=null&&!file.exists()){
                Log.i( "jstest" , "jstest !file.exists" );
                try {
                    isSuccess = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally{
                    Log.i("jstest", "jstest 파일생성 여부 = " + isSuccess);
                }
            }else{
                Log.i( "jstest" , "jstest file.exists" );
            }
        }
        return file;
    }
    
    /**
     * (dir/file) 절대 경로 얻어오기
     * @param file
     * @return String
     */
    private String getAbsolutePath(File file){
        return ""+file.getAbsolutePath();
    }
 
    /**
     * (dir/file) 삭제 하기
     * @param file
     */
    private boolean deleteFile(File file){
        boolean result;
        if(file!=null&&file.exists()){
            file.delete();
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    /**
     * 파일여부 체크 하기
     * @param file
     * @return
     */
    private boolean isFile(File file){
        boolean result;
        if(file!=null&&file.exists()&&file.isFile()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 디렉토리 여부 체크 하기
     * @param dir
     * @return
     */
    private boolean isDirectory(File dir){
        boolean result;
        if(dir!=null&&dir.isDirectory()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 파일 존재 여부 확인 하기
     * @param file
     * @return
     */
    private boolean isFileExist(File file){
        boolean result;
        if(file!=null&&file.exists()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }
     
    /**
     * 파일 이름 바꾸기
     * @param file
     */
    private boolean reNameFile(File file , File new_name){
        boolean result;
        if(file!=null&&file.exists()&&file.renameTo(new_name)){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 디렉토리에 안에 내용을 보여 준다.
     * @param file
     * @return
     */
    private String[] getList(File dir){
        if(dir!=null&&dir.exists())
            return dir.list();
        return null;
    }

    /**
     * 파일에 내용 쓰기
     * @param file
     * @param file_content
     * @return
     */
    private boolean writeFile(File file , byte[] file_content){
        boolean result;
        FileOutputStream fos;
        if(file!=null&&file.exists()&&file_content!=null){
            try {
                fos = new FileOutputStream(file);
                try {
                    fos.write(file_content);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    
    ArrayList<String> arr = new ArrayList<String>();

    String result;
    /**
     * 파일 읽어 오기 
     * @param file
     */
    private void readFile(File file){
        int readcount=0;
        
        String result = "";
        if(file!=null&&file.exists()){
            try {
            	Resources resources = getResources();
            	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(STRSAVEPATH+arListView.get(listPos).toString()+".txt"),"UTF-8"));
            	String readLine = "";
            	int check = 0;
            	
            	while ((readLine = br.readLine())!= null) {
            		arr.add(readLine + "\n");
            	}
            	
            	br.close();
            	
            	for(int i = 0; i < arr.toArray().length; i++)
            	{
            		Log.d("jstest", "jstest1234 arr  = "+arr.get(i));
            	}
            	
            	
                
            } catch (Exception e) {
                e.printStackTrace();
                
                Log.d("jstest", "jstest1234 e = "+e.toString());
            }
        }
        
    }

    /**
     * 파일 복사
     * @param file
     * @param save_file
     * @return
     */
    private boolean copyFile(File file , String save_file){
        boolean result;
        if(file!=null&&file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream newfos = new FileOutputStream(save_file);
                int readcount=0;
                byte[] buffer = new byte[1024];
                while((readcount = fis.read(buffer,0,1024))!= -1){
                    newfos.write(buffer,0,readcount);
                }
                newfos.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = true;
        }else{
            result = false;
        }
        return result;
    }


    
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

        //jstest240902
        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ClickInt", 0);
        editor.apply();

        Toast.makeText(AndroidSensorActivity.this, "원활한 운영을 위해 광고를 클릭해 주셔야 서비스 이용이 가능 합니다.", Toast.LENGTH_LONG).show();

        // 광고 요청. 광고 노출은 CaulyInterstitialAdListener의 onReceiveInterstitialAd에서 처리한다.
        interstial.requestInterstitialAd(this);
		
		sm.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL); // 가속도
		sm.registerListener(this, oriSensor, SensorManager.SENSOR_DELAY_NORMAL); // 방향
		sm.registerListener(this, rotSensor, SensorManager.SENSOR_DELAY_NORMAL); // 회전
		sm.registerListener(this, ligSensor, SensorManager.SENSOR_DELAY_NORMAL); // 밝기
		sm.registerListener(this, magSensor, SensorManager.SENSOR_DELAY_NORMAL); // 자력
		sm.registerListener(this, preSensor, SensorManager.SENSOR_DELAY_NORMAL); // 압력
		sm.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL); // 근접
		sm.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL); // 온도
		
	}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();  // X 좌표
        float y = event.getY();  // Y 좌표

        Log.d("jstest240902", " jstest240902 Touch down at: (" + x + ", " + y + ")");

//jstest240902
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 터치가 시작될 때
                Log.d("jstest240902", " jstest240902 Touch down at: (" + x + ", " + y + ")");

                if((x > 0 || x <= 1050) && (y >0 || y <= 320))
                {
                    sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("ClickInt", 1);
                    editor.apply();
                    Log.d("jstest240902 TouchEvent", "jstest240902 Touch down22 at: (" + x + ", " + y + ")");
                }
                //              Toast.makeText(getContext(), "Touch down at: (" + x + ", " + y + ")", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener(this);
	}

	//종료시에는 반드시 센서의 리스너를 해제해줘야함

	public void onDestroy(){

			super.onDestroy();
			sm.unregisterListener(this);

	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}


	boolean m_bMag = false;
	
	float[] aValues = new float[3];
	float[] mValues = new float[3];
	
	float[] mOri = new float[3];
	
	int m_nInputX;
	int m_nInputY;
	
	String str, str1;
	float teslaXYZ;
	int milligauss;
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized (this) {

		    float [] var = new float[3];

		    for(int i = 0; i < event.values.length; i++)
            {
                var[i]= event.values[i];
            }

//			float var0 = event.values[0];
//			float var1 = event.values[1];
//			float var2 = event.values[2];
			
			switch (event.sensor.getType ()){
	            case Sensor.TYPE_ACCELEROMETER:
//	                aValues = event.values.clone ();
	            	aValues = event.values;
	                break;
	            case Sensor.TYPE_MAGNETIC_FIELD:
//	                mValues = event.values.clone ();
	            	mValues = event.values;
	                break;
	        }
	
	        float[] R = new float[9];
	        float[] orientationValues = new float[9];
	
	        boolean success = SensorManager.getRotationMatrix (R, orientationValues, aValues, mValues);
	        
//	        Log.d("jstest", "jstest success = "+success);
	        
	        if(success)
	        {
	        	float orientation[] = new float[3];
	        	SensorManager.getOrientation (R, orientation);
//	        	Log.d("jstest", "jstest orientation[0] = "+orientation[0]);
//	        	azimut = orientation[0];
	        }
	        
//	        mCustomDrawableView.invalidate();
	        
	        orientationValues[0] = (float)Math.toDegrees (orientationValues[0]);
	        orientationValues[1] = (float)Math.toDegrees (orientationValues[1]);
	        orientationValues[2] = (float)Math.toDegrees (orientationValues[2]);

			
			
			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:

//				acc.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				if(maxAccX < var[0])
					maxAccX = var[0];
				if(maxAccY < var[1])
					maxAccY = var[1];
				if(maxAccZ < var[2])
					maxAccZ = var[2];
				
//				maxAcc.setText("X : " + maxAccX + ", Y : " + maxAccY + ", Z : " + maxAccZ);
				
				break;

			case Sensor.TYPE_ORIENTATION:
				
//				ori.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				
				if(var[0] < 0) var[0] += 360;
				
				m_oPitch.setText("Azimuth(방위) : " + var[0] + "\n"
						+ "pitch(경사도): " + var[1] +"\nroll(좌우회전): " + var[2]);
				
				mOri[0] = var[0];
				mOri[1] = var[1];
				mOri[2] = var[2];
//				if(var0 >= 0 && var0 <= 90)
//				{
//					// 
//					m_oPitchText.setText("방위는 북 동 방향 입니다.");
//				}
//				else if(var0 >= 90 && var0 <= 180)
//				{
//					// 방위는 동 남 방향 입니다.
//					m_oPitchText.setText("방위는 동 남 방향 입니다.");
//				}
//				else if(var0 >= 180 &&  var0 <= 270)
//				{
//					// 방위는 서 남 방향 입니다.
//					m_oPitchText.setText("방위는 서 남 방향 입니다.");
//				}
//				else if(var0 >= 270 && var0 <= 360)
//				{
//					// 방위는 북 서 방향 입니다.
//					m_oPitchText.setText("방위는 북 서 방향 입니다.");
//				} 
				break;
			case Sensor.TYPE_GYROSCOPE:
				
//				rot.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				break;
			case Sensor.TYPE_LIGHT:
				
//				lig.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				
				mag.setText("x:  " + var[0] + ", y = " + var[1] +" , z = " + var[2]);
				
				teslaXYZ = (float)(Math.sqrt((var[0] * var[0]) + (var[1] * var[1])
	                    + (var[2] * var[2])));
				
				milligauss = (int)teslaXYZ * 10; 
				
				try{
//					m_nInputX = Integer.parseInt(m_oInput.getText().toString()); // -
//					m_nInputY = Integer.parseInt(m_oInput2.getText().toString()); //  +
					
//					Log.d("jstest", "jstet m_nInputY = "+m_nInputY + " teslaXYZ = "+teslaXYZ);
//					if(-m_nInputX < (int)teslaXYZ && (int)teslaXYZ < m_nInputY)
//					if((int)teslaXYZ < m_nInputY)
//					{
//						m_oWaring.setText("자석물체가 범위 내 있습니다.");
//						
//					}
//					else
//					{
//						m_oWaring.setText("자석물체가 범위를 벗어 났습니다.");
//						
//						m_oVibe.vibrate(1000);       
//					}
				}
				catch (Exception e) {
					// TODO: handle exception
					
					Log.d("jstest", "jstet exception e = "+e.toString());
				}
				
				str = String.valueOf(teslaXYZ);
				str1 = String.valueOf(milligauss);

				m_oTeslaXYZ.setText("Microtesla(uT) : "+str+"\nMilligauss(mG) : "+str1);
				m_oPosY.setText(""+var[1]);
				m_oPosX.setText(""+var[0]);
				m_oPosZ.setText(""+var[2]);
				
				xyz[0] = var[0];
				xyz[1] = var[1];
				xyz[2] = var[2];
				
				if(orientationValues[0] < 0) orientationValues[0] += 360;
				
				m_oPitch.setText("Azimuth(방위) : " + orientationValues[0] + "\n"
						+ "pitch(경사도): " + orientationValues[1] +"\nroll(좌우회전): " + orientationValues[2]);
				
				if(orientationValues[0] >= 0 && orientationValues[0]<= 90)
				{
					// 
					m_oPitchText.setText("방위는 북 동 방향 입니다.");
				}
				else if(orientationValues[0] >= 90 && orientationValues[0]<= 180)
				{
					// 방위는 동 남 방향 입니다.
					m_oPitchText.setText("방위는 동 남 방향 입니다.");
				}
				else if(orientationValues[0] >= 180 && orientationValues[0]<= 270)
				{
					// 방위는 서 남 방향 입니다.
					m_oPitchText.setText("방위는 서 남 방향 입니다.");
				}
				else if(orientationValues[0] >= 270 && orientationValues[0]<= 360)
				{
					// 방위는 북 서 방향 입니다.
					m_oPitchText.setText("방위는 북 서 방향 입니다.");
				} 

				break;
			case Sensor.TYPE_PRESSURE:
				
//				pre.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				break;
			case Sensor.TYPE_PROXIMITY:
	
//				prox.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				break;
			case Sensor.TYPE_TEMPERATURE:
	
//				temp.setText("x = " + var0 + ", y = " + var1 +" , z = " + var2);
				break;
			
			}
			                          
			                          
		}
	}

    
	
}