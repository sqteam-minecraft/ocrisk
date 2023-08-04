#include <iostream>
#include <org_sqteam_ocrisk_Main.h>

JNIEXPORT void JNICALL Java_org_sqteam_ocrisk_Main_print
  (JNIEnv *, jobject)
{
std::cerr << "Hello From C++ World!\n";
return;
}