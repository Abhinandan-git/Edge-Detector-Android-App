#include <jni.h>
#include <string>
#include <android/log.h>

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, "JNI", __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "JNI", __VA_ARGS__)

extern "C" void processFrameNative(
        JNIEnv *env,
        jobject thiz,
        jobject buffer,
        jint width,
        jint height
) {
    LOGI("processFrameNative called: %dx%d", width, height);
    // TODO: implement processFrame()
}

static JNINativeMethod methods[] = {
        {"processFrame", "(Ljava/nio/ByteBuffer;II)V", (void*)processFrameNative}
};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
    JNIEnv *env = nullptr;

    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        LOGE("JNI_OnLoad FAILED: GetEnv error");
        return JNI_ERR;
    }

    jclass clazz = env->FindClass("net/abhinandan/edge_detector_android_app/NativeBridge");

    if (clazz == nullptr) {
        LOGE("JNI_OnLoad FAILED: NativeBridge class not found!");
        return JNI_ERR;
    }

    if (env->RegisterNatives(clazz, methods, sizeof(methods) / sizeof(methods[0])) < 0) {
        LOGE("JNI_OnLoad FAILED: RegisterNatives failed!");
        return JNI_ERR;
    }

    LOGI("JNI_OnLoad SUCCESS: native methods registered");
    return JNI_VERSION_1_6;
}
