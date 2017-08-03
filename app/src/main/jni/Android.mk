	LOCAL_PATH := $(call my-dir)
	include $(CLEAR_VARS)

	#opencv
	OPENCVROOT:= C:\opencv
	OPENCV_CAMERA_MODULES:=on
	OPENCV_INSTALL_MODULES:=on
	OPENCV_LIB_TYPE:=SHARED
	include ${OPENCVROOT}/sdk/native/jni/OpenCV.mk

	LOCAL_SRC_FILES := io_github_andylx96_myapplication_NativeClass.cpp

	LOCAL_LDLIBS += -llog
	LOCAL_MODULE := MyLibs


	include $(BUILD_SHARED_LIBRARY)