# Add project specific ProGuard rules here.
#
# http://developer.android.com/tools/help/proguard.html

# Add any project specific keep options here:

# If you use -dontobfuscate you can omit the following rules, but this will
# mean that your code will be easy to reverse engineer.
-keep class com.google.vending.licensing.ILicensingService
-keep class com.android.vending.licensing.ILicensingService

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static final int *;
}
