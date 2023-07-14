package com.example.clonecoding_discord.cmmon;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {

    // Retrofit을 매번 새로 인스턴스화해서 사용하는것은 매우 귀찮음.
    // 재사용이 가능한구조를 하나만들고 재사용하면 편함.
    private final String TAG = "CommonConn";
    private HashMap<String , Object> paramMap;//파라메터 전송용
    private Context context; // 화면위에 토스트,ProgressDialog를 보여주기위한용도
    private String mapping ; // list.cu,login,member등의 맵핑을 받아오기위한것.
    private ProgressDialog dialog;//모양이 다양하게 커스텀이 가능하니 나중에 바꾸면 된다.
    private JepCallBack callBack;
    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
    }
    public void addParamMap(String key , Object value){
        if(key == null){
            Log.e(TAG, "파라메터 key값이 null이 들어와서 추가 안했음." );
        }else if (value == null){
            Log.e(TAG, "파라메터 value값이 null이 들어와서 추가 안했음.<-?경우에따라서 커스텀해야함." );
        }else{
            paramMap.put(key,value);
        }
    }
    public void onExcute( JepCallBack callBack){
        //2. 옵저버 2
        this.callBack = callBack;
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        //GET방식인지 POST방식인지를 받아와서 처리도 가능하다.(현재는 어려우니까 POST로 고정시켜놓기)
        api.clientPostMethod(mapping , paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d(TAG, "onExcute . onResponse: " +response.body()+paramMap.get("user_id").toString()+paramMap.get("user_pw").toString());
                onPostExcute(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onExcute . onFailure: "+t.getMessage() );
                Toast.makeText(context, "서버와의 연결에 실패했습니다.", Toast.LENGTH_SHORT).show();
                onPostExcute(false , t.getMessage());
            }
        });

    }

    private void onPostExcute(boolean isResult , String data){
        if(dialog != null){
            dialog.dismiss();
        }
        //3. 옵저버 3
        callBack.onResult(isResult, data);
    }

    // 옵저버 패턴 . 감시하다가 어떤 작업이 끝나면 특정 메소드를 실행함. : View.OnClickListner .
    // 1.
    public interface JepCallBack{
        public void onResult(boolean isResult , String data);
    }


}
