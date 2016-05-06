package cn.wycode.bannertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import cn.wycode.hybanner.HYViewPager;

public class MainActivity extends AppCompatActivity {

    public static ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HYViewPager banner = (HYViewPager) findViewById(R.id.banner);

        initImageLoader();

        ArrayList<ImageView> imageViews = new ArrayList<>();

        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
//        iv.setImageResource(R.drawable.one);
        imageLoader.displayImage("http://img.mm522.net/flashAll/20120502/1335945503zcBMJr.jpg",iv);
        imageViews.add(iv);

        ImageView iv1 = new ImageView(this);
        iv1.setScaleType(ImageView.ScaleType.FIT_XY);
//        iv1.setImageResource(R.drawable.two);
        imageLoader.displayImage("http://pic1.win4000.com/pic/6/07/42f9243396.jpg",iv1);
        imageViews.add(iv1);
//
        ImageView iv2 = new ImageView(this);
        iv2.setScaleType(ImageView.ScaleType.FIT_XY);
//        iv2.setImageResource(R.drawable.three);
        imageLoader.displayImage("http://pic.4j4j.cn/upload/pic/20130704/fcdf38dcf7.jpg",iv2);
        imageViews.add(iv2);
//
//        ImageView iv3 = new ImageView(this);
//        iv3.setScaleType(ImageView.ScaleType.FIT_XY);
////        iv3.setImageResource(R.drawable.four);
//        imageLoader.displayImage("http://www.bz55.com/uploads/allimg/110913/1HR111B-0.jpg",iv3);
//        imageViews.add(iv3);


        assert banner != null;
        banner.setViews(imageViews,true);


    }


    private void initImageLoader() {
        // Create default options which will be used for every
        // displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.one) // resource
                .showImageForEmptyUri(R.drawable.one) // resource or
                // drawable
                .showImageOnFail(R.drawable.one) // resource or
//                         drawable
                .displayer(new FadeInBitmapDisplayer(200, true, false, false)).cacheInMemory(true).cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(512, 512) // default
                .diskCacheExtraOptions(512, 512, null).defaultDisplayImageOptions(defaultOptions)
                .build();

        ImageLoader.getInstance().init(config); // Do it on Application start
        imageLoader = ImageLoader.getInstance();
//     Then later, when you want to display image
//     DiningMasterApplication.imageLoader.displayImage( String imageUrl,
//     ImageView imageView);

    }
}
