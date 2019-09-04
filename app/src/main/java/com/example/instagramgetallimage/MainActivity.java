package com.example.instagramgetallimage;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText edtUserName;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private Button btnTaiAnh;
    private TextView tvCapNhatCookie;
    private Button btnGetID;
    private static String NAME_A = "NAME_A";
    private final String query_hash = "f2405b236d85e8296cf30347c9f08c2a";
    private static final int OK_R = 1999;
    public static String EXTEN_OK = "ok";
    public static String COOKIE = "cookie";
    public static String ID = "id";
    public String cookieLoad = "";
    public boolean isGetCookie = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNoficationChannel();
        init();

        cookieLoad = readCookie();
        checkAndRequestPermissions();
        onclick();
    }

    private void createNoficationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serverNofication = new NotificationChannel(
                    CHANNEL_ID,
                    "Notification Service",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(serverNofication);
        }
    }

    private void init() {
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        btnTaiAnh = (Button) findViewById(R.id.btnTaiAnh);
        tvCapNhatCookie = (TextView) findViewById(R.id.tvCapNhatCookie);
        btnGetID = (Button) findViewById(R.id.btnGetID);
    }

    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    private void onclick() {
        btnGetID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String link = edtUserName.getText().toString();
                if (link.isEmpty() || cookieLoad.isEmpty()) {
                    if (!isGetCookie) {
                        cookieLoad = readCookie();
                    } else {
                        Toast.makeText(getApplicationContext(), "Cookie hoặc url rỗng ", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
                if (!link.endsWith("/")) {
                    link += "/";
                }
                new GetID(edtUserName).execute(link, cookieLoad);
            }
        });
        btnTaiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = edtUserName.getText().toString();
                if (link.isEmpty() || cookieLoad.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Cookie hoặc url rỗng", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, StartDownload.class);
                intent.putExtra(ID, edtUserName.getText().toString());
                intent.putExtra(COOKIE, cookieLoad);
                startService(intent);
            }
        });
        tvCapNhatCookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InstagramGetCookie.class);
                intent.putExtra(NAME_A, "");
                startActivityForResult(intent, OK_R);
            }
        });
    }

    private void updateCookie(String cookie) {
        try {
            FileOutputStream fos = openFileOutput("cookie.dat", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(cookie);
            osw.close();
            fos.close();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Lỗi truy xuất file cookie", Toast.LENGTH_SHORT).show();
        }
    }

    private String readCookie() {
        String data = "";
        try {
            FileInputStream fis = openFileInput("cookie.dat");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            data = bufferedReader.readLine();
            bufferedReader.close();
            fis.close();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Cookie chưa có dữ liệu vui lòng cập nhật cookie", Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == OK_R) {
            if (resultCode == RESULT_OK) {
                updateCookie(data.getStringExtra(InstagramGetCookie.NEW_T));
            }
        }
    }

    // Class get url image
//    class GetImage extends AsyncTask<String,String, ArrayList<String> >{
//        String id;
//
//        public GetImage(String id) {
//            this.id = id;
//        }
//
//
//        private ArrayList<String> listURL = new ArrayList<>();
//        @Override
//        protected  ArrayList<String>  doInBackground(String... strings) {
//            FileOutputStream fos;
//            OutputStreamWriter osw = null;
//            try {
//                fos = openFileOutput("list.txt",MODE_PRIVATE);
//                osw = new OutputStreamWriter(fos);
//                getUrl(strings[0],strings[1],strings[2],osw,0);
//                osw.close();
//                fos.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return listURL;
//
//        }
//
//        @Override
//        protected void onPostExecute( ArrayList<String>  s) {
//            super.onPostExecute(s);
////
//                int i=0;
//                PRDownloaderConfig prDownloaderConfig = PRDownloaderConfig.newBuilder().setConnectTimeout(9999999)
//                        .build();
//                PRDownloader.initialize(getApplicationContext(),prDownloaderConfig);
//                final String directory_path = Environment.getExternalStorageDirectory().getPath() + "/"+id+"/";
//                File file = new File(directory_path);
//                if (!file.exists()) {
//                    file.mkdirs();
//                }
//                final Random rand =new Random();
//                Log.d("Start dowload", "onStartCommand: ");
//                int t=0;
//                try {
//                    FileInputStream fis = openFileInput("list.txt");
//                    BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
//                    doload(0,directory_path,new Random(),bf);
//                    bf.close();
//                    fis.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//        public void doload(final int i, final String directory_path, final Random rand, BufferedReader bf) throws IOException {
//            String item = "";
//            if((item = bf.readLine()) != null){
//                String duoi = ".jpg";
//                if(item.contains(".mp4")){
//                    duoi = ".mp4";
//                }
//                Log.d("Link", "doload: " + item);
//                int pr = PRDownloader.download(item,directory_path,(System.currentTimeMillis()+rand.nextInt(1000)) +duoi)
//                        .build()
//                        .start(new OnDownloadListener() {
//                            @Override
//                            public void onDownloadComplete() {
//                                Log.d("Download", "onDownloadComplete: " + i);
//                                leng++;
//                            }
//                            @Override
//                            public void onError(Error error) {
//                                Log.d("OnError", "onError: " );
//                            }
//                        });//kumikun.ai/
//
//                doload(i+1,directory_path,rand, bf);
//
//            }else {
//                Log.d("Download", "doload: Errror");
//            }
//        }
//        private void getUrl(String link, String cookie, String id , OutputStreamWriter osw, int dem){
//            try{
//                if(osw == null){
//                    Toast.makeText(getApplicationContext(),"Error open file",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Log.d("1", "getUrl: "+dem);
//                URL url = new URL(link);
//                HttpURLConnection http = (HttpURLConnection) url.openConnection();
//                http.setConnectTimeout(100000);
//                http.setRequestMethod("GET");
//                http.setRequestProperty("Cookie",cookie);
//                http.connect();
//                if(http.getResponseCode() == HttpURLConnection.HTTP_OK){
//                    BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
//                    String line;
//                    StringBuffer outputJson = new StringBuffer();
//                    while ((line = br.readLine()) != null){
//                        outputJson.append(line);
//                    }
//                    br.close();
//                    Moshi moshi = new Moshi
//                            .Builder()
//                            .build();
//                    JsonAdapter<TestClass> jsonAdapter = moshi.adapter(TestClass.class);
//                    TestClass test = jsonAdapter.fromJson(outputJson.toString());
//                    if(test.status.equalsIgnoreCase("ok")){
//                        if(!test.data.user.edge_owner_to_timeline_media.page_info.isHas_next_page() || test.data.user.edge_owner_to_timeline_media.page_info == null||test.data.user.edge_owner_to_timeline_media.page_info.getEnd_cursor().isEmpty()){
//                            return;
//                        }
//                        String nextPage = "https://www.instagram.com/graphql/query/?query_hash="+query_hash+"&variables={\"id\":\""+id+"\",\"first\":30,\"after\":\""+test.data.user.edge_owner_to_timeline_media.page_info.getEnd_cursor()+"\"}";
//                        Edge[] edge = test.data.user.edge_owner_to_timeline_media.edges;
//                        for(Edge item : edge){
//                            if(!item.node.is_video){
//                                Display_Resources1[] resources = item.node.display_resources;
//                                osw.append(resources[resources.length-1].src+"\n");
//                            }else{
//                                osw.append(item.node.video_url+"\n");
//                            }
//                            dem++;
//                        }
//
//                        System.gc();
//                        getUrl(nextPage,cookie,id, osw, dem);
//                    }
//                    System.gc();
//                }
//
//            }catch (Exception e){
//            }
//
//        }
//    }

    // Class Get ID
    class GetID extends AsyncTask<String, String, String> {
        public EditText edt;

        public GetID(EditText edt) {
            this.edt = edt;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0] + "?__a=1");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setConnectTimeout(100000);
                http.setRequestMethod("GET");
                http.setRequestProperty("Cookie", strings[1]);
                http.connect();

                if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    String line;
                    StringBuffer outputJson = new StringBuffer();
                    while ((line = br.readLine()) != null) {
                        outputJson.append(line);
                    }
                    return outputJson.toString();
                }
                return "";
            } catch (Exception e) {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.isEmpty()) {
                return;
            }
            String[] idListData = s.split("\"");
            for (int i = 0; i < idListData.length; i++) {
                if (idListData[i].equals("logging_page_id")) {
                    String[] id = idListData[i + 2].split("_");
                    edt.setText(id[1]);
                    return;
                }
            }
        }
    }
}
