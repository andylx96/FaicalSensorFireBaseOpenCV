package io.github.andylx96.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;

public class CameraMain extends AppCompatActivity {

    ImageView result;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button openCVCamButton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_main);

        Button click = (Button) findViewById(R.id.camera);
        result = (ImageView) findViewById(R.id.imageView);
        openCVCamButton = (Button) findViewById(R.id.openCVCamButton);

        openCVCamSetup();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void openCVCamSetup() {

        openCVCamButton = (Button) findViewById(R.id.openCVCamButton);
        openCVCamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CameraMain.this, OpenCVCam.class));


            }
        });
    }

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            result.setImageBitmap(imageBitmap);
        }
    }

}
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("CameraMain Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
//    }
//}


//
//    import android.content.Intent;
//    import android.content.pm.ActivityInfo;
//    import android.hardware.Camera;
//    import android.net.Uri;
//    import android.provider.MediaStore;
//    import android.support.v7.app.AppCompatActivity;
//    import android.os.Bundle;
//    import android.util.Log;
//    import android.view.SurfaceView;
//    import android.view.View;
//    import android.widget.Button;
//    import android.widget.ImageView;
//    import android.widget.TextView;
//
//    import java.io.File;
//    //
//    //import org.opencv.android.BaseLoaderCallback;
//    //import org.opencv.android.CameraBridgeViewBase;
//    //import org.opencv.android.JavaCameraView;
//    //import org.opencv.android.LoaderCallbackInterface;
//    //import org.opencv.android.OpenCVLoader;
//    //import org.opencv.core.CvType;
//    //import org.opencv.core.Mat;
//    //import org.opencv.imgproc.Imgproc;
//
//    public class CameraMain extends AppCompatActivity {
//
//        ImageView imageView;
//        static final int CAM_REQUEST= 1;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_camera_main);
//            imageView = (ImageView) findViewById(R.id.image_view);
//            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//    //        File file = getFile();
//    //        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
//            startActivityForResult(camera_intent, CAM_REQUEST);
//
//
//        }
//
//    }
//
//
//
//    //
//    //    private static final String TAG = "OpenCVActivity";
//    //    JavaCameraView javaCameraView;
//    //    Mat mRgba, imgGray, imgCanny;
//    //
//    //
//    //
//    //    BaseLoaderCallback mLoaderCallBack = new BaseLoaderCallback(this) {
//    //        @Override
//    //        public void onManagerConnected(int status) {
//    //            switch (status){
//    //                case BaseLoaderCallback.SUCCESS:{
//    //                    javaCameraView.enableView();
//    //                    break;
//    //
//    //                }
//    //                default:{
//    //
//    //                    super.onManagerConnected(status);
//    //                    break;
//    //                }}}
//    //    };
//    //
//    //    // Used to load the 'native-lib' library on application startup.
//    ////    static {
//    ////        System.loadLibrary("native-lib");
//    ////        System.loadLibrary("MyLibs");
//    //////        System.loadLibrary("MyFaceLibs");
//    ////    }
//    //
//    //    @Override
//    //    protected void onCreate(Bundle savedInstanceState) {
//    //        super.onCreate(savedInstanceState);
//    //        setContentView(R.layout.activity_camera_main);
//    //        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    //
//    //        // Example of a call to a native method
//    ////        TextView tv = (TextView) findViewById(R.id.sample_text);
//    ////        tv.setText(stringFromJNI());
//    //
//    //        javaCameraView = (JavaCameraView)findViewById(R.id.java_camera_view);
//    //        javaCameraView.setVisibility(SurfaceView.VISIBLE);
//    //        javaCameraView.setCvCameraViewListener(this);
//    ////        javaCameraView.setMaxFrameSize(480,320);
//    ////            javaCameraView.set
//    //
//    ////        ((TextView)findViewById(R.id.text_view)).setText(NativeClass.getMessageFromJNI());
//    ////        Button cannyButton =(Button)findViewById(R.id.buttonCanny);
//    ////        cannyButton.setOnClickListener(new cannyButtonListener());
//    //    }
//    //
//    //
//    //    @Override
//    //    protected void onPause(){
//    //        super.onPause();
//    //        if (javaCameraView!=null)
//    //            javaCameraView.disableView();
//    //    }
//    //
//    //    @Override
//    //    protected void onDestroy(){
//    //        super.onDestroy();
//    //        javaCameraView.disableView();
//    //    }
//    //
//    //    @Override
//    //    protected void onResume(){
//    //        super.onResume();
//    //
//    //
//    //        if(OpenCVLoader.initDebug()){
//    //            Log.d(TAG, "Open CV Loaded");
//    //            mLoaderCallBack.onManagerConnected(LoaderCallbackInterface.SUCCESS);
//    //
//    //        }
//    //        else {Log.d(TAG,"Open CV Not Loaded");
//    //            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0,this,mLoaderCallBack);
//    //        }
//    //
//    //
//    //    }
//    //
//    //    @Override
//    //    public void onCameraViewStarted(int width, int height) {
//    //        mRgba =  new Mat(height, width, CvType.CV_8UC4);
//    ////initizlize var
//    //        imgGray = new Mat(height, width, CvType.CV_8UC1);
//    //        imgCanny = new Mat(height, width, CvType.CV_8UC1);
//    //
//    //    }
//    //
//    //    @Override
//    //    public void onCameraViewStopped() {
//    //        mRgba.release();
//    //    }
//    //
//    //    @Override
//    //    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
//    //        mRgba = inputFrame.rgba();
//    //
//    ////set gray scale;
//    ////        Imgproc.cvtColor(mRgba, imgGray, Imgproc.COLOR_RGB2GRAY);
//    //// set canny
//    ////        Imgproc.Canny(mRgba, imgCanny, 50, 150);
//    ////caled face dection method
//    ////        NativeClass.faceDetection(mRgba.getNativeObjAddr());
//    //        return mRgba;
//    ////        returns canny
//    ////    return imgCanny;
//    //    }
//    //
//    ////    public native String stringFromJNI();
//    //
//    //
//    //
//    ////    private class cannyButtonListener implements View.OnClickListener {
//    ////        @Override
//    ////        public void onClick(View v) {
//    ////
//    ////        }
//    ////    }
//    //}
//    //
