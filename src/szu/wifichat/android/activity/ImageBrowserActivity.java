package szu.wifichat.android.activity;

import java.util.ArrayList;
import java.util.List;

import szu.wifichat.android.BaseActivity;
import szu.wifichat.android.R;
import szu.wifichat.android.adapter.ImageBrowserAdapter;
import szu.wifichat.android.view.PhotoTextView;
import szu.wifichat.android.view.ScrollViewPager;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ImageBrowserActivity extends BaseActivity implements
        OnPageChangeListener {

    private ScrollViewPager mSvpPager;
    private PhotoTextView mPtvPage;
    private ImageBrowserAdapter mAdapter;
    private int mPosition;
    private int mTotal;

    public static final String PATH = "path";
    public static final String POSITION = "position";
    public static final String IMAGE_TYPE = "image_type";
    public static final String TYPE_ALBUM = "image_album";
    public static final String TYPE_PHOTO = "image_photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebrowser);
        initViews();
        initEvents();
        init();
    }

    @Override
    protected void initViews() {
        mSvpPager = (ScrollViewPager) findViewById(R.id.imagebrowser_svp_pager);
        mPtvPage = (PhotoTextView) findViewById(R.id.imagebrowser_ptv_page);
    }

    @Override
    protected void initEvents() {
        mSvpPager.setOnPageChangeListener(this);
    }

    private void init() {
        String mType = getIntent().getStringExtra(IMAGE_TYPE);
        String path = getIntent().getStringExtra(PATH);
        List<String> photos = new ArrayList<String>();
        photos.add(path);
        mPtvPage.setText("1/1");
        mAdapter = new ImageBrowserAdapter(mApplication, photos, mType);
        mSvpPager.setAdapter(mAdapter);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        mPosition = arg0;
        mPtvPage.setText((mPosition % mTotal) + 1 + "/" + mTotal);
    }
  
    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, R.anim.zoom_exit);
    }

    @Override
    public void processMessage(Message msg) {
        // TODO Auto-generated method stub
        
    }

}
