 /**
  *
  * @Package:        com.example.book
  * @ClassName:      MainActivity
  * @Description:    APP打开后主要的activity，导航栏按钮绑定四个点击事件，点击后创建对应的fragment。
  * @Author:         方侠
  * @CreateDate:     2019/11/29 14:12
  * @UpdateUser:     更新者
  * @UpdateDate:     2019/11/29 14:12
  * @UpdateRemark:   更新内容
  * @Version:        1.0
  */
package com.example.book;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 定义导航栏四个按钮对应的4个Fragment对象
    private FirstPage firstyear_fg;
    private Mine mine_fg;
    private Search search_fg;
    private Circle circle_fg;

    // 导航栏每个按钮对应的布局
    private LinearLayout firstpageLayout;
    private LinearLayout circleLayout;
    private LinearLayout messageLayout;
    private LinearLayout mineLayout;
//    导航栏每个按钮对应的布局下的图片
    private ImageView firstpageImg;
    private ImageView circleImg;
    private ImageView messageImg;
    private ImageView mineImg;
//    导航栏每个按钮对应的布局下的文本
    private TextView firstpageText;
    private TextView circleText;
    private TextView messageText;
    private TextView mineText;

    // 定义几个颜色
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int dark = 0xff000000;

    // 定义FragmentManager对象管理器
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView(); // 初始化界面控件
        setChioceItem(0);   // 初始化页面加载时显示第一个选项卡
    }

    private void initView() {
        // 初始化底部导航栏的控件
        firstpageImg = (ImageView) findViewById(R.id.firstpage_img);
        circleImg = (ImageView) findViewById(R.id.circle_img);
        messageImg = (ImageView) findViewById(R.id.message_img);
        mineImg = (ImageView) findViewById(R.id.mine_img);

        firstpageText = (TextView) findViewById(R.id.firstpage_text);
        circleText = (TextView) findViewById(R.id.circle_text);
        messageText = (TextView) findViewById(R.id.message_text);
        mineText = (TextView) findViewById(R.id.mine_text);

        firstpageLayout = (LinearLayout) findViewById(R.id.firstpage_layout);
        circleLayout = (LinearLayout) findViewById(R.id.circle_Layout);
        messageLayout = (LinearLayout) findViewById(R.id.message_Layout);
        mineLayout = (LinearLayout) findViewById(R.id.mine_Layout);

        firstpageLayout.setOnClickListener(MainActivity.this);
        circleLayout.setOnClickListener(MainActivity.this);
        messageLayout.setOnClickListener(MainActivity.this);
        mineLayout.setOnClickListener(MainActivity.this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstpage_layout:
                setChioceItem(0);
                break;
            case R.id.circle_Layout:
                setChioceItem(1);
                break;
            case R.id.message_Layout:
                setChioceItem(2);
                break;
            case R.id.mine_Layout:
                setChioceItem(3);
                break;
            default:
                break;
        }
    }

    private void setChioceItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clearChioce(); // 清空, 重置选项, 隐藏所有Fragment
        hideFragments(fragmentTransaction);
        switch (index) {
            case 0:
//                firstImage.setImageResource(R.drawable.XXXX); 需要的话自行修改
                firstpageText.setTextColor(dark);
                firstpageLayout.setBackgroundColor(gray);

                // 如果fg1为空，则创建一个并添加到界面上
                if (firstyear_fg == null) {
                    firstyear_fg = new FirstPage();
                    fragmentTransaction.add(R.id.content, firstyear_fg);

                } else {
                    // 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(firstyear_fg);
                }
                break;
            case 1:
//                secondImage.setImageResource(R.drawable.XXXX);
                circleText.setTextColor(dark);
                circleLayout.setBackgroundColor(gray);

                if (circle_fg == null) {
                    circle_fg = new Circle();
                    fragmentTransaction.add(R.id.content, circle_fg);
                } else {
                    fragmentTransaction.show(circle_fg);
                }

                break;

            case 2:
//                thirdImage.setImageResource(R.drawable.XXXX);
                messageText.setTextColor(dark);
                messageLayout.setBackgroundColor(gray);

                if (search_fg == null) {
                    search_fg = new Search();
                    fragmentTransaction.add(R.id.content, search_fg);
                } else {
                    fragmentTransaction.show(search_fg);
                }

                break;

            case 3:
//                fourthImage.setImageResource(R.drawable.XXXX);
                mineText.setTextColor(dark);
                mineLayout.setBackgroundColor(gray);

                if (mine_fg == null) {
                    mine_fg = new Mine();
                    fragmentTransaction.add (R.id.content, mine_fg);
                } else {
                    fragmentTransaction.show(mine_fg);
                }

                break;
        }

        fragmentTransaction.commit();   // 提交

    }

    /**
     * 当选中其中一个选项卡时，其他选项卡重置为默认
     */
    private void clearChioce() {
//        firstImage.setImageResource(R.drawable.XXX);
        firstpageText.setTextColor(gray);
        firstpageLayout.setBackgroundColor(whirt);

//        secondImage.setImageResource(R.drawable.XXX);
        circleText.setTextColor(gray);
        circleLayout.setBackgroundColor(whirt);

        //        thirdImage.setImageResource(R.drawable.XXX);
        messageText.setTextColor(gray);
        messageLayout.setBackgroundColor(whirt);

        //        fourthImage.setImageResource(R.drawable.XXX);
        mineText.setTextColor(gray);
        mineLayout.setBackgroundColor(whirt);
    }

    /**
     * 隐藏Fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (firstyear_fg != null) {
            fragmentTransaction.hide(firstyear_fg);
        }

        if (circle_fg != null) {
            fragmentTransaction.hide(circle_fg);
        }

        if (search_fg != null) {
            fragmentTransaction.hide(search_fg);
        }

        if (mine_fg != null) {
            fragmentTransaction.hide(mine_fg);
        }
    }

    public MainActivity getMainActivity() {
        return this;
    }

}
