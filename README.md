myview
====
### 1、[功能描述]：
##### 主要用于底部导航栏


### 2、[项目结构简介]：
##### （1）example为demo,里面主要包括使用方式，如何调用；
##### （2）library为依赖Module，第三方库引用的文件都在library文件夹里
##### （3）其他文件默认提交，不做说明


### 3、[测试DEMO]：
##### 调用底部导航栏代码如下
        布局文件
        <com.hjm.bottomtabbarold.BottomTabBar
            android:id="@+id/bottom_tab_bar"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        </com.hjm.bottomtabbarold.BottomTabBar>
        
        代码调用
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);
        mb.init(getSupportFragmentManager())
                .setImgSize(60,60)//设置图片尺寸
                .setFontSize(12)//设置字体尺寸
                .setTabPadding(10,6,10)
                .setChangeColor(Color.BLUE,Color.GRAY)//设置选中和未选中的颜色
                .addTabItem("标题1",R.mipmap.my_select,R.mipmap.my_normal, Fragment1.class)
                .addTabItem("标题2",R.mipmap.mystudy_select,R.mipmap.mystudy_normal, Fragment2.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {

                    }
                });
##### 调用动画加载
	loadingDialog = new LoadingDialog(ViewsActivity.this, true);
                loadingDialog.show();
##### 调用圆行图片
	img = (CornerImageView) findViewById(R.id.img);
        //图片圆形加载
        Glide.with(this).load("")
                .error(this.getResources().getDrawable(R.mipmap.white))
                .placeholder(this.getResources().getDrawable(R.mipmap.white))
                .transform(new CenterCrop(this), new GlideCircleTransform(this))
                .into(img);
##### 调用圆角矩形图片		
	//图片圆角加载
        img2 = (ImageView) findViewById(R.id.img2);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png")
                .error(this.getResources().getDrawable(R.mipmap.white))
                .placeholder(this.getResources().getDrawable(R.mipmap.white))
                .transform(new CenterCrop(this), new GlideRoundTransform(this))
                .into(img2);
##### 调用普通提示框
    private  CustomDialog commondialog;
    private void showDialog() {
        commondialog = new CustomDialog(this);
        commondialog.show();
        commondialog.setMessage("毛春江帅吗？");
        commondialog.setTitle("提示");
        commondialog.setCancleText("不帅");
        commondialog.setConfirmText("帅");
        commondialog.setConfirmColor(R.drawable.btn_blue_click_color);
        commondialog.setCancleColor(R.drawable.btn_c333333_click_color);
        commondialog.setYesOnclickListener(new CustomDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                commondialog.dismiss();
            }
        });
        commondialog.setNoOnclickListener(new CustomDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
            }
        });
    }
### 4、[历史版本]：
##### 2018.6.28
    *完成自定义导航栏功能，其中包括Fragment切换功能，版本v1.0.0
    *引用方式：   
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    dependencies {
	        implementation 'com.github.githubmcj:myview:v1.0.0'
	}
##### 2018.8.9
    *添加圆角控件、添加普通提示框、删除多余依赖库、添加glide库
    *引用方式：   
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    dependencies {
	        implementation 'com.github.githubmcj:myview:v1.0.1'
	}


### 5、[联系方式]：
##### email：550612711@qq.com 对这个工程不明白的地方可以通过该联系方式与我联系。
