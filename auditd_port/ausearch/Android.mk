# Buildvorgang von 'ausearch'

LOCAL_PATH:= $(call my-dir)
MY_PATH := $(LOCAL_PATH)


include $(call all-subdir-makefiles)
include ./../libcutils4ndk/Android.mk
include $(CLEAR_VARS)

LOCAL_PATH := $(MY_PATH)

ETC_DIR := $(TARGET_OUT)/etc/audit

LOCAL_MODULE := ausearch
LOCAL_MODULE_TAGS := eng
LOCAL_SRC_FILES:= lib/libaudit.c \
			lib/message.c \
			lib/strsplit.c \
			lib/netlink.c \
			lib/lookup_table.c \
			lib/audit_logging.c \
			lib/deprecated.c \
			src/auditd-config.h \
			src/auditd-config.c \
			src/accesstab.h \
			src/ausearch-avc.c \
			src/ausearch-avc.h \
			src/ausearch.c \
			src/ausearch-checkpt.c \
			src/ausearch-checkpt.h \
			src/ausearch-common.h \
			src/ausearch-int.c \
			src/ausearch-int.h \
			src/ausearch-llist.c \
			src/ausearch-llist.h \
			src/ausearch-lol.c \
			src/ausearch-lol.h \
			src/ausearch-lookup.c \
			src/ausearch-lookup.h \
			src/ausearch-match.c \
			src/ausearch-nvpair.c \
			src/ausearch-nvpair.h \
			src/ausearch-options.c \
			src/ausearch-options.h \
			src/ausearch-parse.c \
			src/ausearch-parse.h \
			src/ausearch-report.c \
			src/ausearch-string.c \
			src/ausearch-string.h \
			src/ausearch-time.c \
			src/ausearch-time.h \
			src/delete_all.c \
			auparse/accesstab.h \
			auparse/auditd-config.c \
			auparse/auparse.c \
			auparse/auparse-defs.h \
			auparse/auparse.h \
			auparse/auparse-idata.h \
			auparse/auparse.pc.in \
			auparse/captab.h \
			auparse/clocktab.h \
			auparse/clone-flagtab.h \
			auparse/data_buf.c \
			auparse/data_buf.h \
			auparse/ellist.c \
			auparse/ellist.h \
			auparse/epoll_ctl.h \
			auparse/expression.c \
			auparse/expression-design.txt \
			auparse/expression.h \
			auparse/famtab.h \
			auparse/fcntl-cmdtab.h \
			auparse/flagtab.h \
			auparse/icmptypetab.h \
			auparse/inethooktab.h \
			auparse/internal.h \
			auparse/interpret.c \
			auparse/interpret.h \
			auparse/ioctlreqtab.h \
			auparse/ip6optnametab.h \
			auparse/ipccmdtab.h \
			auparse/ipctab.h \
			auparse/ipoptnametab.h \
			auparse/lru.c \
			auparse/lru.h \
			auparse/message.c \
			auparse/mmaptab.h \
			auparse/mounttab.h \
			auparse/netactiontab.h \
			auparse/nfprototab.h \
			auparse/normalize.c \
			auparse/normalize_evtypetab.h \
			auparse/normalize-internal.h \
			auparse/normalize-llist.c \
			auparse/normalize-llist.h \
			auparse/normalize_obj_kind_map.h \
			auparse/normalize_obj_kind_maps.h \
			auparse/normalize_record_map.h \
			auparse/normalize_record_maps.h \
			auparse/normalize_syscall_map.h \
			auparse/normalize_syscall_maps.h \
			auparse/nvlist.c \
			auparse/nvlist.h \
			auparse/open-flagtab.h \
			auparse/persontab.h \
			auparse/pktoptnametab.h \
			auparse/prctl-opt-tab.h \
			auparse/private.h \
			auparse/prottab.h \
			auparse/ptracetab.h \
			auparse/recvtab.h \
			auparse/rlimittab.h \
			auparse/rnode.h \
			auparse/schedtab.h \
			auparse/seccomptab.h \
			auparse/seektab.h \
			auparse/shm_modetab.h \
			auparse/signaltab.h \
			auparse/sockleveltab.h \
			auparse/sockoptnametab.h \
			auparse/socktab.h \
			auparse/socktypetab.h \
			auparse/tcpoptnametab.h \
			auparse/tty_named_keys.h \
			auparse/typetab.h \
			auparse/umounttab.h \
			libev/ev.c \
			libev/event.c \

LOCAL_C_INCLUDES :=	./ \
			./lib \
			./libc \
			./\
			./libev \
			./auparse \
			./src

LOCAL_CFLAGS :=  -fPIE -DPIE -g -D_GNU_SOURCE -fno-strict-aliasing 
LOCAL_CFLAGS += -fPIE
LOCAL_LDFLAGS += -fPIE -pie

LOCAL_SHARED_LIBRARIES := libcutils
LOCAL_LDLIBS := -llog

include $(BUILD_EXECUTABLE)
