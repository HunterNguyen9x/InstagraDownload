package com.example.instagramgetallimage;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class StartDownload extends Service {
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private int success = 0;
    private int error = 0;
    NotificationCompat.Builder builder;
    NotificationManagerCompat notificationManagerCompat;
    private final String query_hash = "f2405b236d85e8296cf30347c9f08c2a";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String id = intent.getStringExtra(MainActivity.ID);
        String cookie = intent.getStringExtra(MainActivity.COOKIE);
        if (id.isEmpty() || cookie.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Lỗi ID hoặc cookie bị trống", Toast.LENGTH_SHORT).show();
            stopSelf();
            return START_NOT_STICKY;
        }
        thongbao("Tiến trình URL", "Bắt đầu quá trình lấy url ảnh");
        String uri = "https://www.instagram.com/graphql/query/?query_hash=" + query_hash + "&variables=" + "{\"id\":\"" + id + "\",\"first\":30}";
        new GetImage(id).execute(uri, cookie, id);
        return START_NOT_STICKY;
    }

    // cài đặt thông báo tiến trình
    public void thongbao(String title, String messess) {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(messess)
                .setOnlyAlertOnce(true);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
        startForeground(1, builder.build());
    }

    //================

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service Error", "onDestroy: Bị thoát service này ... xem lại đi");
    }

    class GetImage extends AsyncTask<String, String, String> {
        private String id;
        private int dem;

        public GetImage(String id) {
            this.id = id;
        }

        @Override
        protected String doInBackground(String... strings) {
            getURL(strings[0], strings[1], strings[2]);
            return null;
        }

        @Override
        protected void onCancelled() {
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            DownloadImage(id);
        }

        /**
         * tải ảnh về đọc url từ file
         *
         * @param id
         */
        public void DownloadImage(String id) {
            PRDownloaderConfig prDownloaderConfig = PRDownloaderConfig.newBuilder().setConnectTimeout(9999999)
                    .build();
            PRDownloader.initialize(getApplicationContext(), prDownloaderConfig);
            final String directory_path = Environment.getExternalStorageDirectory().getPath() + "/" + id + "/";
            File file = new File(directory_path);
            if (!file.exists()) {
                file.mkdirs();
            }
            final Random rand = new Random();
            try {
                builder.setContentText("Bắt đầu tải...");
                notificationManagerCompat.notify(1, builder.build());
                FileInputStream fis = openFileInput("list.txt");
                BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
                doload(0, directory_path, new Random(), bf);
                bf.close();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void doload(final int i, final String directory_path, final Random rand, BufferedReader bf) throws IOException {
            String item = "";
            if ((item = bf.readLine()) != null) {
                String duoi = ".jpg";
                if (item.contains(".mp4")) {
                    duoi = ".mp4";
                }

                int pr = PRDownloader.download(item, directory_path, (System.currentTimeMillis() + rand.nextInt(1000)) + duoi)
                        .build()
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                success++;
                                builder.setContentText("Thành công: " + success + " ảnh    Thất bại: " + error);
                                notificationManagerCompat.notify(1, builder.build());
                                if (success + error >= dem - 1) {
                                    builder.setContentText("Kết thúc quá trình tải ảnh");
                                    notificationManagerCompat.notify(1, builder.build());
                                    stopSelf();
                                }
                            }

                            @Override
                            public void onError(Error error2) {
                                error++;
                                builder.setContentText("Thành công: " + success + " ảnh    Thất bại: " + error);
                                notificationManagerCompat.notify(1, builder.build());
                                if (success + error >= dem - 1) {
                                    builder.setContentText("Kết thúc quá trình tải ảnh");
                                    notificationManagerCompat.notify(1, builder.build());
                                    stopSelf();
                                }
                            }
                        });//kumikun.ai/

                doload(i + 1, directory_path, rand, bf);

            } else {

            }
        }

        /**
         * Hàm lấy URL của ảnh rồi ghi vào file
         *
         * @param strings
         */
        private void getURL(String... strings) {
            FileOutputStream fos;
            OutputStreamWriter osw = null;
            try {
                fos = openFileOutput("list.txt", MODE_PRIVATE);
                osw = new OutputStreamWriter(fos);
                doingGetURL(strings[0], strings[1], strings[2], osw);
                osw.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void doingGetURL(String link, String cookie, String id, OutputStreamWriter osw) {
            try {
                if (osw == null) {
                    Log.d("Error open file", "Error file");
                    return;
                }
                Log.d("1", "getUrl: " + dem);
                URL url = new URL(link);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setConnectTimeout(100000);
                http.setRequestMethod("GET");
                http.setRequestProperty("Cookie", cookie);
                http.connect();
                if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    String line;
                    StringBuffer outputJson = new StringBuffer();
                    while ((line = br.readLine()) != null) {
                        outputJson.append(line);
                    }
                    br.close();
                    Moshi moshi = new Moshi
                            .Builder()
                            .build();
                    JsonAdapter<TestClass> jsonAdapter = moshi.adapter(TestClass.class);
                    TestClass test = jsonAdapter.fromJson(outputJson.toString());
                    if (test.status.equalsIgnoreCase("ok")) {
                        if (!test.data.user.edge_owner_to_timeline_media.page_info.isHas_next_page() || test.data.user.edge_owner_to_timeline_media.page_info == null || test.data.user.edge_owner_to_timeline_media.page_info.getEnd_cursor().isEmpty()) {
                            return;
                        }
                        String nextPage = "https://www.instagram.com/graphql/query/?query_hash=" + query_hash + "&variables={\"id\":\"" + id + "\",\"first\":30,\"after\":\"" + test.data.user.edge_owner_to_timeline_media.page_info.getEnd_cursor() + "\"}";
                        Edge[] edge = test.data.user.edge_owner_to_timeline_media.edges;
                        for (Edge item : edge) {
                            if (!item.node.is_video) {
                                Display_Resources1[] resources = item.node.display_resources;
                                osw.append(resources[resources.length - 1].src + "\n");
                            } else {
                                osw.append(item.node.video_url + "\n");
                            }
                            dem++;
                        }
                        builder.setContentText("Dữ liệu được tải: " + dem);
                        notificationManagerCompat.notify(1, builder.build());

                        doingGetURL(nextPage, cookie, id, osw);
                    }
                    System.gc();
                }

            } catch (Exception e) {
            }

        }


    }
}
