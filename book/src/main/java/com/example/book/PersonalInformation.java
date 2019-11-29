package com.example.book;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class PersonalInformation extends AppCompatActivity  {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
//    private TextView tv_main_title,tv_back;
////    private SwipeBackLayout layout;
//    private TextView tv_nickName, tv_signature, tv_user_name, tv_sex;
//    private RelativeLayout rl_nickName, rl_sex, rl_signature,rl_head, rl_title_bar;
//    private String spUserName;
//    private static final int CHANGE_NICKNAME = 1;   //修改昵称的自定义常量
//    private static final int CHANGE_SIGNATURE = 2; //修改签名的自定义常量
//    private static final int CROP_PHOTO1 = 3;       //裁剪图片
//    private static final int CROP_PHOTO2 = 4;       //裁剪本地图片
//    private static final int SAVE_PHOTO = 5;        //修改签名的自定义常量
////    private ImageViewRoundOval iv_photo;
//    private Bitmap head;                                //头像Bitmap
//    private static String path = "/sdcard/TopLine/myHead/"; //sd路径
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
//                R.layout.base, null);
//        layout.attachToActivity(this);
//        setContentView(R.layout.personnalinformation);
//        //从SharedPreferences中获取登录时的用户名
//        spUserName = UtilsHelper.readLoginUserName(this);
//        init();
//        initData();
//        setListener();
//    }
//    private void init(){
//        tv_main_title= (TextView)findViewById(R.id.tv_main_title);
//        tv_main_title.setText("个人资料");
//        rl_title_bar= (RelativeLayout)findViewById(R.id.title_bar);
//        rl_title_bar.setBackgroundColor(getResources().getColor(R.color.
//                rdTextColorPress));
//        tv_back= (TextView) findViewById(R.id.tv_back);
//        tv_back.setVisibility(View.VISIBLE);
//        rl_nickName = (RelativeLayout) findViewById(R.id.rl_nickName);
//        rl_sex = (RelativeLayout) findViewById(R.id.rl_sex);
//        rl_signature = (RelativeLayout) findViewById(R.id.rl_signature);
//        tv_nickName = (TextView) findViewById(R.id.tv_nickName);
//        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
//        tv_sex = (TextView) findViewById(R.id.tv_sex);
//        tv_signature = (TextView) findViewById(R.id.tv_signature);
//        rl_head= (RelativeLayout) findViewById(R.id.rl_head);
//        iv_photo = (ImageViewRoundOval) findViewById(R.id.iv_head_icon);
//    }
//    /**
//     * 获取数据
//     */
//    private void initData() {
//        UserBean bean = null;
//        bean = DBUtils.getInstance(this).getUserInfo(spUserName);
//        //首先判断一下数据库是否有数据
//        if (bean == null) {
//            bean = new UserBean();
//            bean.setUserName(spUserName);
//            bean.setNickName("问答精灵");
//            bean.setSex("男");
//            bean.setSignature("传智播客问答精灵");
//            iv_photo.setImageResource(R.drawable.default_head);
//            //保存用户信息到数据库
//            DBUtils.getInstance(this).saveUserInfo(bean);
//        }
//        setValue(bean);
//    }
//    /**
//     * 为界面控件设置值
//     */
//    private void setValue(UserBean bean) {
//        tv_nickName.setText(bean.getNickName());
//        tv_user_name.setText(bean.getUserName());
//        tv_sex.setText(bean.getSex());
//        tv_signature.setText(bean.getSignature());
//        Bitmap bt = BitmapFactory.decodeFile(bean.getHead()); //从SD卡中找头像，转换成Bitmap
//        if (bt != null) {
//            @SuppressWarnings("deprecation")
//            Drawable drawable = new BitmapDrawable(bt);      //转换成drawable
//            iv_photo.setImageDrawable(drawable);
//        } else {
//            iv_photo.setImageResource(R.drawable.default_head);
//        }
//    }
//    /**
//     * 设置控件的点击监听事件
//     */
//    private void setListener() {
//        tv_back.setOnClickListener(this);
//        rl_nickName.setOnClickListener(this);
//        rl_sex.setOnClickListener(this);
//        rl_signature.setOnClickListener(this);
//        rl_head.setOnClickListener(this);
//    }
//    /**
//     * 控件的点击事件
//     */
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tv_back:      //返回键的点击事件
//                this.finish();
//                break;
//            case R.id.rl_nickName: //昵称的点击事件
//                String name = tv_nickName.getText().toString(); //获取昵称控件上的数据
//                Bundle bdName = new Bundle();
//                bdName.putString("content", name);                //传递界面上的昵称数据
//                bdName.putString("title", "昵称");
//                bdName.putInt("flag", 1);                           //flag传递1时表示是修改昵称
//                //跳转到个人资料修改界面
//                enterActivityForResult(ChangeUserInfoActivity.class,CHANGE_NICKNAME, bdName);
//                break;
//            case R.id.rl_sex:       //性别的点击事件
//                String sex = tv_sex.getText().toString(); //获取性别控件上的数据
//                sexDialog(sex);
//                break;
//            case R.id.rl_signature:  //签名的点击事件
//                String signature = tv_signature.getText().toString(); //获取签名控件上的数据
//                Bundle bdSignature = new Bundle();
//                bdSignature.putString("content", signature);            //传递界面上的签名数据
//                bdSignature.putString("title", "签名");
//                bdSignature.putInt("flag", 2);                            //flag传递2时表示是修改签名
//                //跳转到个人资料修改界面
//                enterActivityForResult(ChangeUserInfoActivity.class,CHANGE_SIGNATURE, bdSignature);
//                break;
//            case R.id.rl_head:       //头像的点击事件
//                showTypeDialog();
//                break;
//            default:
//                break;
//        }
//    }
//    private void showTypeDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        final AlertDialog dialog = builder.create();
//        View view = View.inflate(this, R.layout.dialog_select_photo, null);
//        TextView tv_select_gallery = (TextView) view.findViewById(
//                R.id.tv_select_gallery);
//        TextView tv_select_camera = (TextView) view.findViewById(R.id.tv_select_camera);
//        tv_select_gallery.setOnClickListener(new View.OnClickListener() { //在相册中选取
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
//                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                        "image/*");
//                startActivityForResult(intent1, 3);
//                dialog.dismiss();
//            }
//        });
//        tv_select_camera.setOnClickListener(new View.OnClickListener() { //调用照相机
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                intent2.putExtra(MediaStore.EXTRA_OUTPUT,
//                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
//                                spUserName+"_head.jpg")));
//                startActivityForResult(intent2, 4); //采用ForResult打开
//                dialog.dismiss();
//            }
//        });
//        dialog.setView(view);
//        dialog.show();
//    }
//    /**
//     * 设置性别的弹出框
//     */
//    private void sexDialog(String sex){
//        int sexFlag=0;
//        if("男".equals(sex)){
//            sexFlag=0;
//        }else if("女".equals(sex)){
//            sexFlag=1;
//        }
//        final String items[]={"男","女"};
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);//先得到构造器
//        builder.setTitle("性别"); //设置标题
//        builder.setSingleChoiceItems(items,sexFlag,new DialogInterface
//                .OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                //第二个参数which是默认选中的哪个项
//                Toast.makeText(UserInfoActivity.this,items[which],
//                        Toast.LENGTH_SHORT).show();
//                setSex(items[which]);
//            }
//        });
//        builder.create().show();
//    }
//    /**
//     * 更新界面上的性别数据
//     */
//    private void setSex(String sex){
//        tv_sex.setText(sex);
//        //更新数据库中的性别字段
//        DBUtils.getInstance(UserInfoActivity.this).updateUserInfo("sex",sex,
//                spUserName);
//    }
//    /**
//     * 获取回传数据时需使用的跳转方法，第一个参数to表示需要跳转到的界面，
//     * 第二个参数requestCode表示一个请求码，第三个参数b表示跳转时传递的数据
//     */
//    public void enterActivityForResult(Class<?> to, int requestCode, Bundle b) {
//        Intent i = new Intent(this, to);
//        i.putExtras(b);
//        startActivityForResult(i, requestCode);
//    }
//    /**
//     * 回传数据
//     */
//    private String new_info; //最新数据
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case CROP_PHOTO1:
//                if (resultCode == RESULT_OK) {
//                    cropPhoto(data.getData()); //裁剪图片
//                }
//                break;
//            case CROP_PHOTO2:
//                if (resultCode == RESULT_OK) {
//                    File temp = new File(Environment.getExternalStorageDirectory() +"/"+
//                            spUserName+"_head.jpg");
//                    cropPhoto(Uri.fromFile(temp)); //裁剪图片
//                }
//                break;
//            case SAVE_PHOTO:
//                if (data != null) {
//                    Bundle extras = data.getExtras();
//                    head = extras.getParcelable("data");
//                    if (head != null) {
//                        String fileName=setPicToView(head); //保存在SD卡中
//                        //保存头像地址到数据库中
//                        DBUtils.getInstance(UserInfoActivity.this).updateUserInfo("head",
//                                fileName,spUserName);
//                        iv_photo.setImageBitmap(head); //用ImageView显示出来
//                        //发送广播更新“我”的界面中的头像
//                        Intent intent = new Intent(
//                                UpdateUserInfoReceiver.ACTION.UPDATE_USERINFO);
//                        intent.putExtra(
//                                UpdateUserInfoReceiver.INTENT_TYPE.TYPE_NAME,
//                                UpdateUserInfoReceiver.INTENT_TYPE.UPDATE_HEAD);
//                        intent.putExtra("head", fileName);
//                        sendBroadcast(intent);
//                    }
//                }
//                break;
//            case CHANGE_NICKNAME:  //个人资料修改界面回传过来的昵称数据
//                if (data != null) {
//                    new_info = data.getStringExtra("nickName");
//                    if (TextUtils.isEmpty(new_info)) {
//                        return;
//                    }
//                    tv_nickName.setText(new_info);
//                    //更新数据库中的昵称字段
//                    DBUtils.getInstance(UserInfoActivity.this).updateUserInfo(
//                            "nickName", new_info, spUserName);
//                }
//                break;
//            case CHANGE_SIGNATURE: //个人资料修改界面回传过来的签名数据
//                if (data != null) {
//                    new_info = data.getStringExtra("signature");
//                    if (TextUtils.isEmpty(new_info)) {
//                        return;
//                    }
//                    tv_signature.setText(new_info);
//                    //更新数据库中的签名字段
//                    DBUtils.getInstance(UserInfoActivity.this).updateUserInfo(
//                            "signature", new_info, spUserName);
//                }
//                break;
//        }
//    }
//    /**
//     * 调用系统的裁剪功能
//     */
//    public void cropPhoto(Uri uri) {
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.setDataAndType(uri, "image/*");
//        intent.putExtra("crop", "true");
//        //aspectX aspectY 是宽高的比例
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        //outputX outputY 是裁剪图片宽高
//        intent.putExtra("outputX", 150);
//        intent.putExtra("outputY", 150);
//        intent.putExtra("return-data", true);
//        startActivityForResult(intent, SAVE_PHOTO);
//    }
//    private String setPicToView(Bitmap mBitmap) {
//        String sdStatus = Environment.getExternalStorageState();
//        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { //检测sd是否可用
//            return "";
//        }
//        FileOutputStream b = null;
//        File file = new File(path);
//        file.mkdirs(); //创建文件夹
//        String fileName = path + spUserName+"_head.jpg"; //图片名字
//        try {
//            b = new FileOutputStream(fileName);
//            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b); //把数据写入文件
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                //关闭流
//                b.flush();
//                b.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return fileName;
//    }
//
//}
