#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_kirra_hidestringnativec_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Passw0rdRahasi4";
    return env->NewStringUTF(hello.c_str());
}
