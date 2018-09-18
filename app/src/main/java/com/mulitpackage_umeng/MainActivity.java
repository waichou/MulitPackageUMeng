package com.mulitpackage_umeng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.umeng.analytics.AnalyticsConfig;

/**
 * 集成渠道参考：
 * http://www.cnblogs.com/0616--ataozhijia/p/4203997.html
 * https://www.cnblogs.com/chenxibobo/p/6434847.html
 * https://blog.csdn.net/eyishion/article/details/70164694
 *
 * 解决问题：Android Studio升级到3.0以后，出现编译问题Error:All flavors must now belong to a named flavor dimension. Learn more at https://d.android.com/r/tools/flavorDimensions-missing-error-message.html
 * 解决方式：https://blog.csdn.net/ling9400/article/details/78414362
 *
 * 获取渠道信息：
 * 参考：https://blog.csdn.net/woshishui5577/article/details/77320040
 *  
 * 定义渠道信息+ [ UMENG_APPKEY + UMENG_CHANNEL] + 打包编译方式
 * 参考：https://blog.csdn.net/dongbaoming/article/details/56666479
 *
 * 腾讯乐固多渠道打包配置
 * 参考：https://blog.csdn.net/u014769864/article/details/72627189
 * 小结：多渠道打包仅针对项目主配置文件androidMifest.xml中application标签中定义<meta>来实现替换定义channel名字
 * 乐固：可以对没有签名的apk进行签名；可以对已经签名的apk进行加固（注意：加固的时候，需要手动签名后，再去执行加固操作！！！！！！）
 */
public class MainActivity extends AppCompatActivity {

    TextView mChannelTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChannelTv = findViewById(R.id.app_version_code__channel_id);
    }

    public void getChannelClick(View view) {

        String channel_name= AnalyticsConfig.getChannel(this);

        mChannelTv.setText("channel="+channel_name + ",version_name="+ AppUtils.getAppVersionName());
    }

}


