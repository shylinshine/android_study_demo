import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.getwebconnection.R;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {
    private WebView show;
    private TextView result_show;
    private Handler myHander;
    private String result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        show=(WebView) findViewById(R.id.show);
        result_show=(TextView) findViewById(R.id.result);

        myHander =new Handler(){
            public void handleMessage(Message msg){
                if(msg.what==0x11){
                    result_show.setText(result);
                    show.loadDataWithBaseURL(null,result,"text/html","gbk",null);
                }
            }
        };
        new Thread(){
            try {
                URL httpUrl=new URl("http://www.qq.com/");
                HttpURLConnection conn=(HttpURLConnection) httpUrl.openConnection();
                conn.setConnectTimeout(5*1000);
                conn.setRequestMethod("GET");
                InputStream iStream =conn.getInputStream();
                result=readData(iStream,"gbk");

                myHander.sendEmptyMessage(0x11);
            } catch(Exception ex){
                ex.printStackTrace();

            }
        }
    }.start();
}
public  static String readData(InputStream inputStream,St)

}