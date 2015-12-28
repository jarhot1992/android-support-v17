# Copyright 2007 The Android Open Source Project
#
LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES :=android-v4:libs/android-support-v4.jar \
                                        android-v7:libs/android-support-v7-recyclerview.jar 

include $(BUILD_MULTI_PREBUILT)

include $(CLEAR_VARS)

LOCAL_STATIC_JAVA_LIBRARIES := android-v4 \
                               android-v7

LOCAL_MODULE := android-support-v17

LOCAL_SRC_FILES := $(call all-subdir-java-files)

include $(BUILD_STATIC_JAVA_LIBRARY)


