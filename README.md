# Android Headset Tester

This app will help you test your headset/headphones.
1) With this app you can easily determine if headset (TRRS 4 pin) or headphones are connected to audio jack. Some Android devices do not show you this information (for example, Samsung S4).
2) App can be used to make electrical tests. If you want to assemble your own remote control, you can test how device will recognise different values of resistance.

Tips:
1) While plugging, no one button should be pressed on remote controller, otherwise device will not recognise mic.
2) I have never seen 4-function wired headset, but in google specifcation there is reserved "voice" function. I tested it with command "adb shell input keyevent KEYCODE_VOICE_ASSIST".
It was introdused only since Android 5.0 as keycode 231. On 4.4.2 this keycode was used by samsung as KEYCODE_EMAIL.
3) This app only will show you generic headset buttons. If you somehow modified kl files in /system/usr/keylayout, then you should better use KeyTest app.

# Install from Google Play
https://play.google.com/store/apps/details?id=ru.linuxcomp.apps.hstester
