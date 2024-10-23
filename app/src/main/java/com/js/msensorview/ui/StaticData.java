package com.js.msensorview.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.regex.Pattern;

public class StaticData {
	
	
	/**********************************************************************************************
    *
    * Simulator => Tittle => Device
    * 시뮬레이터에서 보내주는 데이터를 티틀 디바이스로 보내주는 메소드
    *
    **********************************************************************************************/
    // 기본( 원본 )
    public final static int IRON_WOOD_DRIVER_BACKSWINGSPEED_NOMAL = -150 ;
    public final static int PW_GW_SW_BACKSWINGSPEED_NOMAL = -40 ;
    public final static int LW_BACKSWINGSPEED_NOMAL = -40 ;
    public final static int PT_BACKSWINGSPEED_NOMAL = -10 ;  // JS 2021.04.15  15 >> 12 >>-10
    /// 민감
    public final static int IRON_WOOD_DRIVER_BACKSWINGSPEED_HIGH = -70 ;
    public final static int PW_GW_SW_BACKSWINGSPEED_HIGH = -20 ;
    public final static int LW_BACKSWINGSPEED_HIGH = -20 ;
    public final static int PT_BACKSWINGSPEED_HIGH = -10 ; // JS 2021.04.15  15 >> 12
    /// 매우민감
    public final static int IRON_WOOD_DRIVER_BACKSWINGSPEED_EXPERT = -15 ;
    public final static int PW_GW_SW_BACKSWINGSPEED_EXPERT = -15 ;
    public final static int LW_BACKSWINGSPEED_EXPERT = -15 ;
    public final static int PT_BACKSWINGSPEED_EXPERT = -8 ; // JS 2021.04.15  15 >> 12

    /// 기본( 원본 )
    public final static int IRON_WOOD_DRIVER_BACKSWINGDIFF_NOMAL= 100 ;
    public final static int PW_GW_SW_BACKSWINGDIFF_NOMAL = 25 ;
    public final static int LW_BACKSWINGDIFF_NOMAL = 25 ;
    public final static int PT_BACKSWINGDIFF_NOMAL = 8 ;
    /// 민감
    public final static int IRON_WOOD_DRIVER_BACKSWINGDIFF_HIGH = 50 ;
    public final static int PW_GW_SW_BACKSWINGDIFF_HIGH = 12 ; // JS 2021.04.15  15 >> 12
    public final static int LW_BACKSWINGDIFF_HIGH = 12 ; // JS 2021.04.15  15 >> 12
    public final static int PT_BACKSWINGDIFF_HIGH = 8 ;
    /// 매우민감
    public final static int IRON_WOOD_DRIVER_BACKSWINGDIFF_EXPERT = 10 ;
    public final static int PW_GW_SW_BACKSWINGDIFF_EXPERT = 8 ;  // JS 2021.04.15   10 >> 8
    public final static int LW_BACKSWINGDIFF_EXPERT = 8 ;  // JS 2021.04.15   10 >> 8
    public final static int PT_BACKSWINGDIFF_EXPERT = 6 ;  // JS 2021.04.15   10 >> 8

    /// 기본( 원본 )
    public final static float DRIVER_WOOD_MINIMUMSPEED_NOMAL = 16.0f ;
    public final static float IRON_MINIMUMSPEED_NOMAL = 8.0f ;
    public final static float PW_GW_SW_MINIMUMSPEED_NOMAL = 4.0f ;
    public final static float LW_MINIMUMSPEED_NOMAL = 1.3f ;
    public final static float PT_MINIMUMSPEED_NOMAL = 0.6f ; // JS 2021.04.15  1.0 >> 0.8
    /// 민감
    public final static float DRIVER_WOOD_MINIMUMSPEED_HIGH = 8.0f ;
    public final static float IRON_MINIMUMSPEED_HIGH = 4.0f ;
    public final static float PW_GW_SW_MINIMUMSPEED_HIGH = 2.0f ;
    public final static float LW_MINIMUMSPEED_HIGH = 1.3f ;
    public final static float PT_MINIMUMSPEED_HIGH = 0.4f ;
    /// 매우민감
    public final static float DRIVER_WOOD_MINIMUMSPEED_EXPERT = 1.15f ;
    public final static float IRON_MINIMUMSPEED_EXPERT = 1.15f ;
    public final static float PW_GW_SW_MINIMUMSPEED_EXPERT = 1.15f ;
    public final static float LW_MINIMUMSPEED_EXPERT = 1.15f ;
    public final static float PT_MINIMUMSPEED_EXPERT = 0.2f ;


//   /// 원본 스윙 민감도
//   public final static int IRON_WOOD_DRIVER_BACKSWINGSPEED = -150 ;
//   public final static int PW_GW_SW_LW_BACKSWINGSPEED = -40 ;
//   public final static int PT_BACKSWINGSPEED = -15 ;
//   public final static int IRON_WOOD_DRIVER_BACKSWINGDIFF = 100 ;
//   public final static int PW_GW_SW_LW_BACKSWINGDIFF = 25 ;
//   public final static int PT_BACKSWINGDIFF = 10 ;
//   public final static float DRIVER_WOOD_MINIMUMSPEED = 8.0f ;
//   public final static float IRON_MINIMUMSPEED = 6.0f ;
//   public final static float WEDGE_LONG_MINIMUMSPEED = 4.0f ;
//   public final static float WEDGE_SHORT_MINIMUMSPEED = 1.3f ;
//   public final static float PUTTER_LONG_MINIMUMSPEED = 1.15f ;
//   public final static float PUTTER_SHORT_MINIMUMSPEED = 0.7f ;


    public static final String SHARED_NAME = "tittle_data";
    public static final String SHARED_LOGIN_INFO = "login";
    public static final String SHARED_CLUBS_INFO = "clubs";

    public static final String MY_PROFILE_IMAGE = "profile_img";
    public static final String MY_PROFILE_IMAGE_USE = "profile_img_use"; /// 0 : 사용 1 : 안함
    public static final String MY_PROFILE_NAME = "profile_name";
    public static final String MY_PROFILE_COUNTRY = "profile_country";
    public static final String MY_PROFILE_BIRTH = "profile_birth";
    public static final String MY_PROFILE_GENDER = "profile_sex";
    public static final String MY_PROFILE_HEIGHT = "profile_height";
    public static final String MY_PROFILE_WEIGHT = "profile_weight";
    public static final String MY_PROFILE_HANDICAP = "profile_handicap";
    public static final String MY_PROFILE_LUNAR = "profile_career";
    public static final String MY_PROFILE_TYPE = "profile_type";

    public static final String LOGIN_ID = "id";
    public static final String LOGIN_ID_OLD = "id_old";
    public static final String LOGIN_ID_NEW = "id_new";
    public static final String LOGIN_PASSWORD = "pass";

    public static final String HOLE_INFO = "hole";
    public static final String PAR_INFO = "par";

    public static final String BATTERY_LEVEL = "battery";

    public static final String FIRMWARE_VERSION = "firmware";

    public static final String CALL_REFUSE = "refuse";

    public static final String CLUB_INFO = "club_info";

    public static final String MAIN_SWING_DISTANCE_UNIT = "swing_distance_unit" ;
    public static final String MAIN_SWING_DISTANCE = "swing_distance" ;
    public static final String MAIN_HEAD_SPEED_UNIT = "head_speed_unit" ;
    public static final String MAIN_HEAD_SPEED = "head_speed" ;
    public static final String MAIN_TEMPO = "tempo" ;
    public static final String MAIN_CLUB_PATH_DIR = "club_path_dir" ;
    public static final String MAIN_CLUB_PATH = "club_path" ;
    public static final String MAIN_FACE_ANGLE_DIR = "face_angle_dir" ;
    public static final String MAIN_FACE_ANGLE = "face_angle" ;
    public static final String MAIN_SWING_TYPE = "swing_type" ;
    public static final String MAIN_SENSOR_SPEED = "sensor_speed" ;
    public static final String MAIN_CLUB_RELEASE_RATE = "club_release_rate" ;
    public static final String MAIN_MOTION = "motion" ;

    public static final String ECHO_EVENT = "echo_event" ;
    public static final String ECHO_RESULT = "echo_result" ;

    public static final String CLUBINFO_DRIVER = "driver" ;
    public static final String CLUBINFO_WOOD = "wood";
    public static final String CLUBINFO_LONG_IRON = "long_Iron";
    public static final String CLUBINFO_MIDDLE_IRON = "middle_Iron";
    public static final String CLUBINFO_SHORT_IRON = "short_Iron";
    public static final String CLUBINFO_WEDGE = "wedge";
    public static final String CLUBINFO_PUTTER = "putter";

    public static final String COURSE_SEARCH_COUNTRY = "course_search_country_id";
    public static final String COURSE_SEARCH_REGION = "course_search_state_id";

    public static final String SETTING_TRIGGER = "setting_trigger"; /// 0 : 실행, 1 : 실행안함
    public static final String SETTING_TTS_TYPE = "setting_tts_type";

    public static final String DATA_UVB = "data_uvb" ;
    public static final String DATA_UVC = "data_uvc" ;

    public static final String SWING_SEQUENCE_SERVER = "swing_sequence_server" ;
    public static final String SWING_SEQUENCE_LOCAL = "swing_sequence_local" ;
    public static final String SWING_SEQUENCE_DELETE = "swing_sequence_delete" ;
    public static final String SWING_SEQUENCE_INSERT = "swing_sequence_insert" ;

    public static final String PATH_GOLF_DB = "path_golf_db" ;
    public static final String PATH_LIST_JSON = "path_list_json" ;
    public static final String PATH_INIT_PACKET = "path_init_packet" ;

    public static final String IS_FIRMWARE_UPDATE = "is_firmware_update" ;

    public static final String IS_UPDATE_MANUAL = "is_update_manual" ;

    public static final String IS_RAW_DATA_STEP = "is_raw_data_step" ; /// 1 : wait, 2 : address, 3 : backswing
    public static final String BACKSWING_SPEED = "back_swing_speed" ;
    public static final String BACKSWING_DIFF = "back_swing_diff" ;
    public static final String MINIMUM_SPEED = "minimum_speed" ;
    public static final String ADDRESS_ANG_MIN = "address_ang_min" ;
    public static final String ADDRESS_ANG_MAX = "address_ang_max" ;

    final public static String categoryName[] =
    {
            "Driver", "Wood", "Long Iron", "Middle Iron", "Short Iron", "Wedge", "Putter"
    } ;

    final public static String shortName[][] =
    {
            {"D"},
            {"W7", "W5", "W3"},
            {"I4", "I3"},
            {"I7", "I6", "I5"},
            {"I9", "I8"},
            {"LW", "SW", "GW", "PW"},
            {"PT"},
    } ;

    final public static String fullName[][] =
    {
            {"Driver"},
            {"7-wood", "5-wood", "3-wood"},
            {"4-iron", "3-iron"},
            {"7-iron", "6-iron", "5-iron"},
            {"9-iron", "8-iron"},
            {"LW", "SW", "GW", "PW"},
            {"PT"},
    } ;

    final public static String clubName[ ] =
    {
            "Driver",
            "2-Wood", "3-Wood", "4-Wood", "5-Wood", "6-Wood", "7-Wood", "8-Wood",
            "1-Iron", "2-Iron", "3-Iron", "4-Iron", "5-Iron", "6-Iron", "7-Iron", "8-Iron", "9-Iron",
            "PW", "GW", "SW", "LW",
            "PT"
    } ;

//    public static int getClubImage(String name)
//    {
//        if (name.equals("Driver"))
//            return R.drawable.img_club_driver_big;
//        else if (name.equals("Wood"))
//            return R.drawable.img_club_wood_big;
//        else if (name.equals("Wedge"))
//            return R.drawable.img_club_wedge_big;
//        else if (name.equals("Putter"))
//            return R.drawable.img_club_putter_big;
//        else
//            return R.drawable.img_club_iron_big;
//    }

    /// 클럽 패킷 정보
    public static byte[ ] m_iClub = { 0x21, 0x31, 0x61, 0x71 } ;

    /**
     * 암호화
     * @param data : MDN or 이메일 등 ..
     * @return
     */
//    public static String getEncryptData(String data) {
//
//        String returnValue = null;
//
//        Seed128Cipher seed = null;
//        try {
//            seed = new Seed128Cipher(ServerURL.mEncryptKey);
//
//            returnValue = URLEncoder.encode(seed.encrypt(data), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return returnValue;
//    }
    /**
     * 암호화
     * @param data : MDN or 이메일 등 ..
     * @return
     */
//    public static String getNotcoderEncryptData(String data) {
//
//        String returnValue = null;
//
//        Seed128Cipher seed = null;
//        try {
//            seed = new Seed128Cipher(ServerURL.mEncryptKey);
//
//            returnValue = seed.encrypt(data) ;
//        } catch (UnsupportedEncodingException e) {
//
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return returnValue;
//    }

    /**
     * 복호화
     * @param data
     * @return
     */
//    public static String getDecryptData(String data) {
//
//        if(data == null){
//            return null;
//        }
//
//        String returnValue = null;
//
//        Seed128Cipher seed = null;
//        try {
//            seed = new Seed128Cipher(ServerURL.mEncryptKey);
//            returnValue = seed.decrypt( data );
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace( ) ;
//        }
//
//        return returnValue;
//    }

//    // SHA256으로 암호화
//    public static String getSHA256(String str){
//        String SHA = "";
//        try{
//            MessageDigest sh = MessageDigest.getInstance("SHA-256");
//            sh.update(str.getBytes());
//            byte byteData[] = sh.digest();
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0 ; i < byteData.length ; i++){
//                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
//            }
//
//            SHA = sb.toString();
//        }catch(NoSuchAlgorithmException e){
//            SHA = null;
//        }
//
//        return SHA;
//    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    public static boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    /**
     * getPreferencesInt 값 불러오기 (Int 형)
     * @param context
     * @param dataTag
     * @param default_data
     * @return SaveData 저장되어있는 int형 값
     */
    public static int getPreferencesInt(Context context, String dataTag, int default_data){
        SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(dataTag, default_data);
    }

    /**
     * getPreferencesStr 값 불러오기 (String 형)
     * @param context
     * @param dataTag
     * @param default_data
     * @return SaveData 저장되어있는 String형 값
     */
    public static String getPreferencesStr(Context context, String dataTag, String default_data){
        SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
        return pref.getString(dataTag, default_data);
    }

    /**
     * getPreferencesBoolean 값 불러오기 (boolean 형)
     * @param context
     * @param dataTag
     * @param default_data
     * @return
     */
    public static boolean getPreferencesBoolean(Context context, String dataTag, boolean default_data){
        SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
        return pref.getBoolean(dataTag, default_data);
    }

    // --------------------------------------------------------------------------------------
    // 값 저장 -------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------

    /**
     * savePreferencesInt 값 저장하기 (int 형)
     * @param context
     * @param dataTag
     * @param putData
     */
    public static void savePreferencesInt(Context context, String dataTag, int putData){
        try {
            SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt(dataTag, putData);
            editor.commit();
        } catch (Exception e) {

        }

    }

    /**
     * savePreferencesStr 값 저장하기 (String 형)
     * @param context
     * @param dataTag
     * @param putData
     */
    public static void savePreferencesStr(Context context, String dataTag, String putData){
        try {
            SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(dataTag, putData);
            editor.commit();
        } catch (Exception e) {

        }
    }

    /**
     * savePreferencesBoolean 값 저장하기 (boolean 형)
     * @param context
     * @param dataTag
     * @param putData
     */
    public static void savePreferencesBoolean(Context context, String dataTag, boolean putData){
        try {
            SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(dataTag, putData);
            editor.commit();
        } catch (Exception e) {

        }
    }

//    public static String getSessionId(Context mContext) {
//        try {
//            String loginInfo = StaticData.getPreferencesStr(mContext, StaticData.SHARED_LOGIN_INFO, "");
//
//            if (loginInfo.equals("")) return null;
//
//            Gson gson = new Gson();
//            IntroLoginResult result = gson.fromJson(loginInfo, IntroLoginResult.class);
//            return result.getUser_info().getSid();
//        } catch ( Exception e ) {
//            e.printStackTrace( ) ;
//            return null ;
//        }
//    }
//
//    private static ClubInfo mClub_info = null ;
//    public static ClubInfo getClubInfo( Context mContext ) {
//        try {
//            String clubInfo = StaticData.getPreferencesStr( mContext, StaticData.SHARED_CLUBS_INFO, "" ) ;
//            if ( !clubInfo.equals( "" ) ) {
//                Gson gson = new Gson();
//
//                IntroMainResult result = gson.fromJson(clubInfo, IntroMainResult.class);
//
//                return result.getIntro_info( ).getClub_info( ) ;
//            } else {
//                try {
//                    if( mClub_info != null ) {
//                        return mClub_info ;
//                    }
//                    InputStream inputStream = mContext.getResources( ).openRawResource( R.raw.club_info ) ;
//                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( ) ;
//
//                    int ctr ;
//                    try {
//                        ctr = inputStream.read( ) ;
//                        while ( ctr != -1 ) {
//                            byteArrayOutputStream.write( ctr ) ;
//                            ctr = inputStream.read( ) ;
//                        }
//                        byteArrayOutputStream.close( ) ;
//                        inputStream.close( ) ;
//                    } catch ( IOException e ) {
//                        e.printStackTrace( ) ;
//                    }
//                    LogMJS.e( "Text Data : " + byteArrayOutputStream.toString( ) ) ;
//                    clubInfo = byteArrayOutputStream.toString( ) ;
//
//                    if ( clubInfo.equals( "" ) ) return null;
//
//                    Gson gson = new Gson();
//
//                    mClub_info = gson.fromJson( clubInfo, ClubInfo.class ) ;
//                    return mClub_info ;
//                } catch ( Exception e ){
//                    e.printStackTrace( ) ;
//                    return null ;
//                }
//            }
//        } catch ( Exception e ){
//            e.printStackTrace( ) ;
//            return null ;
//        }

//    }

//    public static UserInfo getUserInfo( Context mContext ) {
//        try {
//            String userInfo = StaticData.getPreferencesStr(mContext, StaticData.SHARED_LOGIN_INFO, "");
//
//            if (userInfo.equals("")) return null;
//
//            Gson gson = new Gson();
//
//            IntroLoginResult result = gson.fromJson(userInfo, IntroLoginResult.class);
//
//            return result.getUser_info() ;
//        } catch ( Exception e ) {
//            e.printStackTrace( ) ;
//            return null;
//        }
//    }
//
//    public static AppInfo getAppInfo(Context mContext){
//        try {
//            String appInfo = StaticData.getPreferencesStr(mContext, StaticData.SHARED_CLUBS_INFO, "");
//
//            if (appInfo.equals("")) return null;
//
//            Gson gson = new Gson();
//
//            IntroMainResult result = gson.fromJson(appInfo, IntroMainResult.class);
//
//            return result.getIntro_info().getApp_info() ;
//        } catch ( Exception e ) {
//            e.printStackTrace( ) ;
//            return null;
//        }
//    }

    /**
     * 세팅된 클럽의 바이트 정보를 가져오는 메소드
     */
//    public static byte getSettingClubInfo( Context context, byte club )
//    {
//        List< Club > list = null ;
//        byte[ ] pos = new byte[ ]{ } ;
//
//        switch( club )
//        {
//            case 0x11 : /// Driver
//                list = StaticData.getClubInfo( context ).getDriver() ;
//                pos = serverClub(list, club) ;
//                break;
//            case 0x21 : /// Wood
//                list = StaticData.getClubInfo( context ).getWood() ;
//                pos = serverClub(list, club) ;
//                break;
//            case 0x31 : /// Long Iron
//                list = StaticData.getClubInfo( context ).getIron_long() ;
//                pos = serverClub(list, club) ;
//                break;
//            case 0x41 : /// Middle Iron
//                list = StaticData.getClubInfo( context ).getIron_middle() ;
//                pos = serverClub(list, club) ;
//                break;
//            case 0x51 : /// Short Iron
//                list = StaticData.getClubInfo( context ).getIron_short();
//                pos = serverClub(list, club) ;
//                break;
//            case 0x61 : /// Wedge
//                list = StaticData.getClubInfo( context ).getWedge();
//                pos = serverClub(list, club) ;
//                break;
//            case 0x71 : /// Putter
//                list = StaticData.getClubInfo( context ).getPutter();
//                pos = serverClub(list, club) ;
//                break;
//            default :
//                return 0x00 ;
//        }
//
//        if( list != null && list.size() > 0 )
//        {
//            for( int i = 0 ; i < list.size( ) ; i ++ )
//            {
//                if( StaticData.getPreferencesStr( context, list.get( i ).getSub_cate_name( ) + 1, "" ).length( ) > 0 )
//                {
//                    LogMJS.e( " * SETTING_CLUB_DATA :  " + pos[ i ] + " = " + list.get( i ).getSub_cate_name( ) ) ;
//                    return pos[ i ] ;
//                }
//            }
//        }
//
//        return 0x00 ;
//    }

    /// 서버에서 내려주는 클럽 리스트
//    private static byte[ ] serverClub( List<Club> list, byte club )
//    {
//        byte[ ] bt = new byte[ ]{ } ;
//
//        switch ( club )
//        {
//            case 0x11 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ )
//                {
//                    if( list.get( i ).getSub_cate_name().equals( "Driver" ) ){
//                        bt[ i ] = 0x11 ;
//                    }
//                }
//                break ;
//            case 0x21 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "2-Wood" ) ){
//                        bt[ i ] = 0x21 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "3-Wood" ) ){
//                        bt[ i ] = 0x22 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "4-Wood" ) ){
//                        bt[ i ] = 0x23 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "5-Wood" ) ){
//                        bt[ i ] = 0x24 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "6-Wood" ) ){
//                        bt[ i ] = 0x25 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "7-Wood" ) ){
//                        bt[ i ] = 0x26 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "8-Wood" ) ){
//                        bt[ i ] = 0x27 ;
//                    }
//                }
//                break ;
//            case 0x31 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "1-Iron" ) ){
//                        bt[ i ] = 0x31 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "2-Iron" ) ){
//                        bt[ i ] = 0x32 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "3-Iron" ) ){
//                        bt[ i ] = 0x33 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "4-Iron" ) ){
//                        bt[ i ] = 0x34 ;
//                    }
//                }
//                break ;
//            case 0x41 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "5-Iron" ) ){
//                        bt[ i ] = 0x41 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "6-Iron" ) ){
//                        bt[ i ] = 0x42 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "7-Iron" ) ){
//                        bt[ i ] = 0x43 ;
//                    }
//                }
//                break ;
//            case 0x51 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "8-Iron" ) ){
//                        bt[ i ] = 0x51 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "9-Iron" ) ){
//                        bt[ i ] = 0x52 ;
//                    }
//                }
//                break ;
//            case 0x61 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "PW" ) ){
//                        bt[ i ] = 0x61 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "GW" ) ){
//                        bt[ i ] = 0x62 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "SW" ) ){
//                        bt[ i ] = 0x63 ;
//                    } else if( list.get( i ).getSub_cate_name().equals( "LW" ) ){
//                        bt[ i ] = 0x64 ;
//                    }
//                }
//                break ;
//            case 0x71 :
//                for ( int i = 0 ; i < list.size( ) ; i ++ ) {
//                    if( list.get( i ).getSub_cate_name().equals( "PT" ) ){
//                        bt[ i ] = 0x71 ;
//                    }
//                }
//                break ;
//        }
//        return bt ;
//    }


    /* 선택된 클럽의 저장된 거리 정보를 가져오는 메소드 */
//    public static int getSettingClubData( Context context, byte club, int pos )
//    {
//        List< Club > list = null ;
//        int data = 0 ;
//
//        switch( club )
//        {
//            case 0x11 : /// Driver
//                list = StaticData.getClubInfo(context).getDriver();
//                break ;
//            case 0x21 : /// Wood
//                list = StaticData.getClubInfo(context).getWood();
//                break ;
//            case 0x31 : /// Iron
//                list = new ArrayList<Club>();
//                list.addAll(StaticData.getClubInfo(context).getIron_long());
//                list.addAll(StaticData.getClubInfo(context).getIron_middle());
//                list.addAll(StaticData.getClubInfo(context).getIron_short());
//                break ;
//            case 0x41 : /// Wedge
//                list = StaticData.getClubInfo(context).getWedge();
//                break;
//            case 0x51 : /// Putter
//                list = StaticData.getClubInfo(context).getPutter();
//                break ;
//        }
//
//        for( int i = 0 ; i < list.size( ) ; i ++ )
//        {
//            if( StaticData.getPreferencesStr( context, list.get( i ).getSub_cate_name( ) + pos, "" ).length( ) > 0 )
//            {
//                data = Integer.parseInt( StaticData.getPreferencesStr( context, list.get( i ).getSub_cate_name( ) + pos, "" ) ) ;
//                return data ;
//            }
//        }
//
//        return 0 ;
//    }
//    /* 전체 클럽의 저장된 거리 정보를 가져오는 메소드 */
//    public static List getAllSettingClubData( Context context )
//    {
//        List< Club > list = new ArrayList< Club >( ) ;
//        List< Club > settingList = new ArrayList< Club >( ) ;
//        list.addAll( StaticData.getClubInfo(context).getDriver( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getWood( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getIron_long( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getIron_middle( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getIron_short( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getWedge( ) ) ;
//        list.addAll( StaticData.getClubInfo(context).getPutter( ) ) ;
//
//        for( int i = 0 ; i < list.size( ) ; i ++ )
//        {
//            if( StaticData.getPreferencesStr( context, list.get( i ).getSub_cate_name( ) + 1, "" ).length( ) > 0 )
//            {
//                settingList.add( list.get( i ) ) ;
//            }
//        }
//
//        return settingList ;
//    }
//
//    /* 스윙타입 가져오는 메소드 */
//    public static String getSwingType( Context context, byte swingType )
//    {
//        String type = null ;
//
//        switch ( swingType )
//        {
//            case 0x00 : /// Push
//            case 0x01 : /// Push Draw
//            case 0x02 : /// Push Fade
//            case 0x07 : /// Fade
//            case 0x0a : /// Slice
//            case 0x0b : /// Pull Hook
//            case 0x0c : /// Push Slice
//                type = context.getString( R.string.classification7 ) ; /// Fade1
////                type = context.getString( R.string.classification0 ) ; /// Push1
////                type = context.getString( R.string.classification1 ) ; /// Push Draw1
////                type = context.getString( R.string.classification2 ) ; /// Push Fade1
////                type = context.getString( R.string.classification10 ) ; /// Slice1
////                type = context.getString( R.string.classification11 ) ; /// Push Hook1
////                type = context.getString( R.string.classification12 ) ; /// Push Slice <
//                break ;
//
//            case 0x03 : /// Pull
//            case 0x04 : /// Pull Draw
//            case 0x05 : /// Pull Fade
//            case 0x06 : /// Draw
//            case 0x09 : /// Hook
//            case 0x0d : /// Pull Hook
//            case 0x0e : /// Pull Slice1
//                type = context.getString( R.string.classification6 ) ; /// Draw1
////                type = context.getString( R.string.classification3 ) ; /// Pull1
////                type = context.getString( R.string.classification4 ) ; /// Pull Draw1
////                type = context.getString( R.string.classification5 ) ; /// Pull Fade1
////                type = context.getString( R.string.classification9 ) ; /// Hook1
////                type = context.getString( R.string.classification13 ) ; /// Pull Hook <
////                type = context.getString( R.string.classification14 ) ; /// Pull Slice1
//                break ;
//
//            case 0x08 : /// Straight
//                type = context.getString( R.string.classification8 ) ; /// Straight
//                break ;
//            default : /// NONE
//                type = context.getString( R.string.classification15 ) ; /// NONE
//                break ;
//        }
//
//        return type ;
//    }

    public static final int SENSITIVITY_NOMAL = 0 ;
	public static final int SENSITIVITY_HIGH = 1 ;
	public static final int SENSITIVITY_EXPERT = 2 ;
    /* 스윙 민감도를 설정하는 메소드 */
    public static void getSwingSenstivity( Context mContext, int club_code, int sensi )
    {
        int sens = SENSITIVITY_NOMAL;

        if(sensi == SENSITIVITY_NOMAL)
        {
            sens = SENSITIVITY_NOMAL;
        }
        else if(sensi == SENSITIVITY_HIGH){
            sens = SENSITIVITY_HIGH;
        }
        else if(sensi == SENSITIVITY_EXPERT)
        {
            sens = SENSITIVITY_EXPERT;
        }

        switch ( club_code )
        {
            case 1 : /// 드라이버
            case 2 : /// 우드3
            case 3 : /// 우드5
            case 4 : /// 우드7
                if( sens == SENSITIVITY_NOMAL ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_NOMAL ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_NOMAL ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, DRIVER_WOOD_MINIMUMSPEED_NOMAL + "" ) ;
                } 
                else if( sens == SENSITIVITY_HIGH ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_HIGH ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_HIGH ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, DRIVER_WOOD_MINIMUMSPEED_HIGH + "" ) ;
                } else if( sens == SENSITIVITY_EXPERT ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_EXPERT ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_EXPERT ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, DRIVER_WOOD_MINIMUMSPEED_EXPERT + "" ) ;
                }
                break ;

            case 5 : /// 아이언4
            case 6 : /// 아이언5
            case 7 : /// 아이언6
            case 8 : /// 아이언7
            case 9 : /// 아이언8
            case 10 : /// 아이언9
                if( sens == SENSITIVITY_NOMAL ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_NOMAL ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_NOMAL ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, IRON_MINIMUMSPEED_NOMAL + "" ) ;
                } else if( sens == SENSITIVITY_HIGH ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_HIGH ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_HIGH ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, IRON_MINIMUMSPEED_HIGH + "" ) ;
                } else if( sens == SENSITIVITY_EXPERT ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, IRON_WOOD_DRIVER_BACKSWINGSPEED_EXPERT ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, IRON_WOOD_DRIVER_BACKSWINGDIFF_EXPERT ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, IRON_MINIMUMSPEED_EXPERT + "" ) ;
                }
                break ;

            case 11 : /// 피칭웨지
            case 12 : /// 갭웨지
            case 13 : /// 샌드웨지
                if( sens == SENSITIVITY_NOMAL ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PW_GW_SW_BACKSWINGSPEED_NOMAL ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PW_GW_SW_BACKSWINGDIFF_NOMAL ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PW_GW_SW_MINIMUMSPEED_NOMAL + "" ) ;
                } else if( sens == SENSITIVITY_HIGH ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PW_GW_SW_BACKSWINGSPEED_HIGH ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PW_GW_SW_BACKSWINGDIFF_HIGH ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PW_GW_SW_MINIMUMSPEED_HIGH + "" ) ;
                } else if( sens == SENSITIVITY_EXPERT ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PW_GW_SW_BACKSWINGSPEED_EXPERT ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PW_GW_SW_BACKSWINGDIFF_EXPERT ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PW_GW_SW_MINIMUMSPEED_EXPERT + "" ) ;
                }
                break ;
            case 14 : /// 로브웨지
                if( sens == SENSITIVITY_NOMAL ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, LW_BACKSWINGSPEED_NOMAL ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, LW_BACKSWINGDIFF_NOMAL ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, LW_MINIMUMSPEED_NOMAL + "" ) ;
                } else if( sens == SENSITIVITY_HIGH ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, LW_BACKSWINGSPEED_HIGH ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, LW_BACKSWINGDIFF_HIGH ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, LW_MINIMUMSPEED_HIGH + "" ) ;
                } else if( sens == SENSITIVITY_EXPERT ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, LW_BACKSWINGSPEED_EXPERT ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, LW_BACKSWINGDIFF_EXPERT ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, LW_MINIMUMSPEED_EXPERT + "" ) ;
                }
                break ;
            case 15 : /// 퍼터
                if( sens == SENSITIVITY_NOMAL ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PT_BACKSWINGSPEED_NOMAL ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PT_BACKSWINGDIFF_NOMAL ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PT_MINIMUMSPEED_NOMAL + "" ) ;
                } else if( sens == SENSITIVITY_HIGH ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PT_BACKSWINGSPEED_HIGH ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PT_BACKSWINGDIFF_HIGH ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PT_MINIMUMSPEED_HIGH + "" ) ;
                } else if( sens == SENSITIVITY_EXPERT ) {
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_SPEED, PT_BACKSWINGSPEED_EXPERT ) ;
                    StaticData.savePreferencesInt( mContext, StaticData.BACKSWING_DIFF, PT_BACKSWINGDIFF_EXPERT ) ;
                    StaticData.savePreferencesStr( mContext, StaticData.MINIMUM_SPEED, PT_MINIMUMSPEED_EXPERT + "" ) ;
                }
                break ;
        }

    }

    /**********************
     * 값 삭제
     * @param context
     *********************/

    /** 값(ALL Data) 삭제하기 */
    public static void removeAllPreferences(Context context){
        SharedPreferences pref = context.getSharedPreferences(SHARED_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    /**유저정보 값 삭제하기 */
    public static void removeUserInfo(Context context){
        try {
            SharedPreferences pref = context.getSharedPreferences( SHARED_NAME, Activity.MODE_PRIVATE ) ;
            SharedPreferences.Editor editor = pref.edit();
            editor.remove( StaticData.SHARED_LOGIN_INFO ) ;
            editor.commit( ) ;
        } catch (Exception e) {

        }
    }

    /**문자열 값 삭제하기 */
    public static void removePreferencesStr( Context context, String dataTag ) {
        try {
            SharedPreferences pref = context.getSharedPreferences( SHARED_NAME, Activity.MODE_PRIVATE ) ;
            SharedPreferences.Editor editor = pref.edit();
            editor.remove( dataTag ) ;
            editor.commit( ) ;
        } catch (Exception e) {

        }
    }

//    /* 클럽에 세팅된 모든 데이터를 지우는 메소드 */
//    public static void removeAllClubSettingData( Context context )
//    {
//        try {
//            List< Club > list = new ArrayList< Club >( ) ;
//            list.addAll( StaticData.getClubInfo(context).getDriver( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getWood( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getIron_long( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getIron_middle( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getIron_short( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getWedge( ) ) ;
//            list.addAll( StaticData.getClubInfo(context).getPutter( ) ) ;
//
//            for( int i = 0 ; i < list.size( ) ; i ++ )
//            {
//                try {
//                    StaticData.removePreferencesStr( context, list.get( i ).getSub_cate_name( ) + 1 ) ;
//                    StaticData.removePreferencesStr( context, list.get( i ).getSub_cate_name( ) + 2 ) ;
//                    StaticData.removePreferencesStr( context, list.get( i ).getSub_cate_name( ) + 3 ) ;
//                } catch ( Exception e ) {
//                    e.printStackTrace( ) ;
//                }
//            }
//
//        } catch ( Exception e ) {
//            e.printStackTrace( ) ;
//        }
//    }
    /* 클럽에 세팅된 데이터를 지우는 메소드 */
    public static void removeClubSettingData( Context context, String clubName )
    {
        try {
            StaticData.removePreferencesStr( context, clubName + 1 ) ;
            StaticData.removePreferencesStr( context, clubName + 2 ) ;
            StaticData.removePreferencesStr( context, clubName + 3 ) ;
        } catch ( Exception e ) {
            e.printStackTrace( ) ;
        }
//        if( clubName.indexOf( "Driver" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getDriver( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getDriver( ).get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, clubName + 1 ) ;
//                StaticData.removePreferencesStr( context, clubName + 2 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Wood" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getWood( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getWood( ).get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Long" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getIron_long( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getIron_long( ).get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Middle" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getIron_middle( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getIron_middle( ).get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Short" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getIron_short( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getIron_short( ).get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Wedge" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getWedge( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getWedge( ).get(i).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//                StaticData.removePreferencesStr( context, name + 3 ) ;
//            }
//        }
//        else if( clubName.indexOf( "Putter" ) != -1 )
//        {
//            for ( int i = 0 ; i < StaticData.getClubInfo( context ).getPutter( ).size( ) ; i++ )
//            {
//                String name = StaticData.getClubInfo( context ).getPutter().get( i ).getSub_cate_name( ) ;
//                StaticData.removePreferencesStr( context, name + 1 ) ;
//                StaticData.removePreferencesStr( context, name + 2 ) ;
//                StaticData.removePreferencesStr( context, name + 3 ) ;
//            }
//        }
    }
}
