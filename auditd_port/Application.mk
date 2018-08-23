# Root Verzeichnis vom Projekt (Ort der Android.mk Datei)
APP_PROJECT_PATH := ./

# Android 6 Marshmallow als Zielplattform
APP_PLATFORM := android-23

APP_BUILD_SCRIPT := ./Android.mk

# Richtige Releases sollten aus Performancegründen mit 'release' gebaut werden
APP_OPTIM := debug
#APP_OPTIM := release

APP_CPPFLAGS := 

# Unterstütze ABI sind:
# armeabi-v7a
# x86_64
# (x86)
APP_ABI := x86
