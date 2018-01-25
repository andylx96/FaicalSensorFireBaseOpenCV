package io.github.andylx96.myapplication;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class OpenCVCam extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2{

    private static final String TAG = "MainActivity";
    private static final String LOG = "OpenCVCam";
    JavaCameraView javaCameraView;
    Mat mRgba, imgGray, imgCanny;

    String face_cascade_name = "/storage/emulated/0/data/haarcascades/haarcascade_frontalface_alt.xml";
    String eyes_cascade_name = "/storage/emulated/0/data/haarcascades/haarcascade_eye_tree_eyeglasses.xml";

    CascadeClassifier faceCascade;
    CascadeClassifier eyesCascade;


    BaseLoaderCallback mLoaderCallBack = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case BaseLoaderCallback.SUCCESS:{
                    javaCameraView.enableView();
                    break;

                }
                default:{

                    super.onManagerConnected(status);
                    break;
                }}}
    };

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("MyLibs");
//        System.loadLibrary("MyFaceLibs");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opencvcam);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());



        javaCameraView = (JavaCameraView)findViewById(R.id.java_camera_view);
        javaCameraView.setVisibility(SurfaceView.VISIBLE);
        javaCameraView.setCvCameraViewListener(this);
//        javaCameraView.setMaxFrameSize(480,320);
//            javaCameraView.set

//        ((TextView)findViewById(R.id.text_view)).setText(NativeClass.getMessageFromJNI());
//        Button cannyButton =(Button)findViewById(R.id.buttonCanny);
//        cannyButton.setOnClickListener(new cannyButtonListener());
    }


    @Override
    protected void onPause(){
        super.onPause();
        if (javaCameraView!=null)
            javaCameraView.disableView();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        javaCameraView.disableView();
    }

    @Override
    protected void onResume(){
        super.onResume();


        if(OpenCVLoader.initDebug()){
            Log.d(TAG, "Open CV Loaded");
            mLoaderCallBack.onManagerConnected(LoaderCallbackInterface.SUCCESS);

        }
        else {Log.d(TAG,"Open CV Not Loaded");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0,this,mLoaderCallBack);
        }


    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        mRgba =  new Mat(height, width, CvType.CV_8UC4);
//initizlize var
        imgGray = new Mat(height, width, CvType.CV_8UC1);
        imgCanny = new Mat(height, width, CvType.CV_8UC1);

    }

    @Override
    public void onCameraViewStopped() {
        mRgba.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();

//set gray scale;
//        Imgproc.cvtColor(mRgba, imgGray, Imgproc.COLOR_RGB2GRAY);
// set canny
//        Imgproc.Canny(mRgba, imgCanny, 50, 150);
//caled face dection method

//        NativeClass.faceDetection(mRgba.getNativeObjAddr());

    float displacement = detectAndDisplay(mRgba);

//   re     float displacement = detectAndDisplay(mRgba);
//        Toast.makeText( OpenCVCam.this, String.valueOf(displacement), Toast.LENGTH_SHORT).show();

//re        Log.d(LOG, String.valueOf(displacement));



            return mRgba;
//        return mRgba;
//        returns canny
//    return imgCanny;
    }

//    public native String stringFromJNI();



//    private class cannyButtonListener implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//
//        }
//    }

    private float detectAndDisplay(Mat frame)
    {
        Size s = frame.size();
        float heightF = (float)s.height/2;


        faceCascade = new CascadeClassifier();
        faceCascade.load(face_cascade_name);
        int absoluteFaceSize  = 0;


        MatOfRect faces = new MatOfRect();
        Mat grayFrame = new Mat();

//        if( !face_cascade.load( face_cascade_name ) ){ printf("--(!)Error loading\n");  };
//        if( !eyes_cascade.load( eyes_cascade_name ) ){ printf("--(!)Error loading\n");  };


        // convert the frame in gray scale
        Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
        // equalize the frame histogram to improve the result
        Imgproc.equalizeHist(grayFrame, grayFrame);

        // compute minimum face size (20% of the frame height, in our case)
        if (absoluteFaceSize == 0)
        {
            int height = grayFrame.rows();
            if (Math.round(height * 0.1f) > 0)
            {
                absoluteFaceSize = Math.round(height * 0.2f);
            }
        }




        // detect faces
        faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE,
                new Size(absoluteFaceSize, absoluteFaceSize), new Size());

        // each rectangle in faces is a face: draw them!
        Rect[] facesArray = faces.toArray();
        Point center;
        float displace = 0;
        for (int i = 0; i < facesArray.length; i++) {

//            Imgproc.rectangle(frame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0), 3);
            center = new Point( facesArray[i].x + facesArray[i].width*0.5, facesArray[i].y + facesArray[i].height*0.5 );
            Imgproc.ellipse( frame, center,new  Size( facesArray[i].width*0.5, facesArray[i].height*0.5), 0, 0, 360,new  Scalar( 255, 0, 255 ), 4, 8, 0 );
            displace = (float)center.y;

        }

        return heightF - displace;
    }


}
