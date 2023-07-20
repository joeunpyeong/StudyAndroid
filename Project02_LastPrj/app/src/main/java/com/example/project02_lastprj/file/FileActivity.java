package com.example.project02_lastprj.file;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.project02_lastprj.R;
import com.example.project02_lastprj.common.RetrofitClient;
import com.example.project02_lastprj.common.RetrofitInterface;
import com.example.project02_lastprj.databinding.ActivityFileBinding;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileActivity extends AppCompatActivity {
    //갤러리 또는 카메라에서 발생되는 이미지를 File형태로 바꾸고 해당하는 파일을 Multipart형태로 Spring전송.
    ActivityFileBinding binding;
    private final int REQ_GALLERY = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Glide.with(this).load("http://192.168.0.116:8080/middle/img//andimg.jpg").into(binding.imgv);

        binding.imgv.setOnClickListener(v->{
            showDialog();
        });
    }

    public void showDialog(){
        String[] dialog_item = { "갤러리" , "카메라"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("사진 업로드 방식");
        builder.setSingleChoiceItems(dialog_item , -1 , (dialog, i) -> {
            if(dialog_item[i].equals("갤러리")){
                showGallery();
            }else if(dialog_item[i].equals("카메라")){
                //카메라 로직
            }
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        //startActivity(intent);//단순 실행 결과를 알수가없다.
        startActivityForResult(intent , REQ_GALLERY );
    }

    //startActivityForResult로 띄운 액티비티가 종료 되면 반드시 ↓메소드가 실행됨.
    //카메라 액티비티의 종료인지 , 갤러리 액티비티의 종료인지 , 그외에 액티비티 종료인지를 구분할수있는 변수가 필요하다.
    //requestCode<- 내가 넣어놨던 코드가 그대로 다시들어옴.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_GALLERY && resultCode==RESULT_OK){
            //갤러리 액티비티가 종료 되었다.
            Log.d("갤러리", "onActivityResult: "+data.getData());
            Log.d("갤러리", "onActivityResult: "+data.getData().getPath());
            Glide.with(this).load(data.getData()).into(binding.imgv);//갤러리 이미지가 잘 붙는지
            String img_path = getRealPath(data.getData());

            //MultiPart 형태로 전송(File)
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"),new File(img_path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file","test.jpg",fileBody);
            RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
            api.clientSendFile("file.f",new HashMap<>(),filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    t.getMessage();
                }
            });


            //MultiPart Spring 처리(RequestMapping(Controller))가 MultiPart를 받으려면 어떻게 했을까?
            //form태그 :태그 사이에 있는 모든 입력 양식을 감싸는 태그로 ,name ,action 등의 속성을 가지고 있는 전송용 태그
            //encType :폼 데이터 서버로 전송될때 "파일을 담고 있다면 " 데이터에 인코딩 과정이 필요하다.
            //multipart/form-data <-파일 데이터느 ㄴ담겨지는 영역이 다르기 때문에 여러부분 (Multi)Body(Part)
        }
    }
    public  String getRealPath(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Cursor cursor = getContentResolver().query(contentUri,proj,null,null);
            if (cursor.moveToFirst()){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                res = cursor.getString(column_index);
            }
            cursor.close();//다 썼으니까 닫음.
        }
        Log.d("TAG", "getRealPath: 커서"+res);
        return res;
    }
}