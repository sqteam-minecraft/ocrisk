#include <iostream>
#include <org_sqteam_ocrisk_API.h>

class Test{
public:
    Test(int val){
        this->val = val;
    }
    int val;
};

/*
 * Class:     org_sqteam_ocrisk_API
 * Method:    init
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_sqteam_ocrisk_API_init(JNIEnv * env, jobject clazz){
    Test *test = new Test(1234);
    std::cerr << "data is: " << test->val << " ptr is: " << test << std::endl;
    return (jlong)test;
}

/*
 * Class:     org_sqteam_ocrisk_API
 * Method:    test
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_sqteam_ocrisk_API_test(JNIEnv * env, jobject clazz, jlong data){
     std::cerr << "data is: " << ((Test*)data)->val << std::endl;

}

/*
 * Class:     org_sqteam_ocrisk_API
 * Method:    destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_sqteam_ocrisk_API_destroy
  (JNIEnv * env, jobject obj, jlong data){
       delete ((Test*)data);
 }