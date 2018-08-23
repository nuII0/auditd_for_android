# Build the auditctl binary

LOCAL_PATH:= $(call my-dir)
MY_PATH := $(LOCAL_PATH)

# Kompilieren des forensikmediator Programmes.
include $(CLEAR_VARS)

LOCAL_PATH := $(MY_PATH)

ETC_DIR := $(TARGET_OUT)/etc/audit

LOCAL_MODULE := forensikmediator
LOCAL_MODULE_TAGS := eng
LOCAL_SRC_FILES:= src/forensikmediator.c \
				  src/socketoperations.h \
				  src/socketoperations.c \
				  src/requesthandling.h \
				  src/requesthandling.c \
				  src/responses.h \
				  src/responses.c \
				  src/externalcommand.h \
				  src/externalcommand.c \
				  src/cjson/cJSON.h \
				  src/cjson/cJSON.c 


LOCAL_C_INCLUDES :=	./ \
			./src

LOCAL_CFLAGS :=  -fPIE -DPIE -g -D_GNU_SOURCE -fno-strict-aliasing 
LOCAL_CFLAGS += -fPIE
LOCAL_LDFLAGS += -fPIE -pie

LOCAL_LDLIBS := -llog

include $(BUILD_EXECUTABLE)

# Kompilieren des audit-dispatch Programmes.
include $(CLEAR_VARS)

LOCAL_PATH := $(MY_PATH)

ETC_DIR := $(TARGET_OUT)/etc/audit

LOCAL_MODULE := audit-dispatch
LOCAL_MODULE_TAGS := eng
LOCAL_SRC_FILES:= src/audit-dispatch.c \
				  src/socketoperations.h \
				  src/socketoperations.c \


LOCAL_C_INCLUDES :=	./ \
			./src

LOCAL_CFLAGS :=  -fPIE -DPIE -g -D_GNU_SOURCE -fno-strict-aliasing 
LOCAL_CFLAGS += -fPIE
LOCAL_LDFLAGS += -fPIE -pie

LOCAL_LDLIBS := -llog

include $(BUILD_EXECUTABLE)

