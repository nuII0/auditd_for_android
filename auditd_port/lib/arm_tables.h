/* This is a generated file, see Makefile.am for its inputs. */
static const char arm_syscall_strings[] = "accept\0accept4\0access\0acct\0add_key\0adjtimex\0alarm\0bdflush\0bind\0bpf\0"
	"brk\0capget\0capset\0chdir\0chmod\0chown\0chown32\0chroot\0clock_adjtime\0clock_getres\0"
	"clock_gettime\0clock_nanosleep\0clock_settime\0clone\0close\0connect\0copy_file_range\0creat\0delete_module\0dup\0"
	"dup2\0dup3\0epoll_create\0epoll_create1\0epoll_ctl\0epoll_wait\0eventfd\0eventfd2\0execve\0execveat\0"
	"exit\0exit_group\0faccessat\0fadvise64_64\0fallocate\0fanotify_init\0fanotify_mark\0fchdir\0fchmod\0fchmodat\0"
	"fchown\0fchown32\0fchownat\0fcntl\0fcntl64\0fdatasync\0fgetxattr\0finit_module\0flistxattr\0flock\0"
	"fork\0fremovexattr\0fsetxattr\0fstat\0fstat64\0fstatat64\0fstatfs\0fstatfs64\0fsync\0ftruncate\0"
	"ftruncate64\0futex\0futimesat\0get_mempolicy\0get_robust_list\0getcpu\0getcwd\0getdents\0getdents64\0getegid\0"
	"getegid32\0geteuid\0geteuid32\0getgid\0getgid32\0getgroups\0getgroups32\0getitimer\0getpeername\0getpgid\0"
	"getpgrp\0getpid\0getppid\0getpriority\0getrandom\0getresgid\0getresgid32\0getresuid\0getresuid32\0getrlimit\0"
	"getrusage\0getsid\0getsockname\0getsockopt\0gettid\0gettimeofday\0getuid\0getuid32\0getxattr\0init_module\0"
	"inotify_add_watch\0inotify_init\0inotify_init1\0inotify_rm_watch\0io_cancel\0io_destroy\0io_getevents\0io_setup\0io_submit\0ioctl\0"
	"ioprio_get\0ioprio_set\0ipc\0kcmp\0kexec_load\0keyctl\0kill\0lchown\0lchown32\0lgetxattr\0"
	"link\0linkat\0listen\0listxattr\0llistxattr\0llseek\0lookup_dcookie\0lremovexattr\0lseek\0lsetxattr\0"
	"lstat\0lstat64\0madvise\0mbind\0membarrier\0memfd_create\0mincore\0mkdir\0mkdirat\0mknod\0"
	"mknodat\0mlock\0mlock2\0mlockall\0mmap\0mmap2\0mount\0move_pages\0mprotect\0mq_getsetattr\0"
	"mq_notify\0mq_open\0mq_timedreceive\0mq_timedsend\0mq_unlink\0mremap\0msgctl\0msgget\0msgrcv\0msgsnd\0"
	"msync\0munlock\0munlockall\0munmap\0name_to_handle_at\0nanosleep\0newselect\0nfsservctl\0nice\0open\0"
	"open_by_handle_at\0openat\0pause\0pciconfig_iobase\0pciconfig_read\0pciconfig_write\0perf_event_open\0personality\0pipe\0pipe2\0"
	"pivot_root\0pkey_alloc\0pkey_free\0pkey_mprotect\0poll\0prctl\0pread64\0preadv\0preadv2\0prlimit64\0"
	"process_vm_readv\0process_vm_writev\0ptrace\0pwrite64\0pwritev\0pwritev2\0quotactl\0read\0readahead\0readdir\0"
	"readlink\0readlinkat\0readv\0reboot\0recv\0recvfrom\0recvmmsg\0recvmsg\0remap_file_pages\0removexattr\0"
	"rename\0renameat\0renameat2\0request_key\0restart_syscall\0rmdir\0rt_sigaction\0rt_sigpending\0rt_sigprocmask\0rt_sigqueueinfo\0"
	"rt_sigreturn\0rt_sigsuspend\0rt_sigtimedwait\0rt_tgsigqueueinfo\0sched_get_priority_max\0sched_get_priority_min\0sched_getaffinity\0sched_getattr\0sched_getparam\0sched_getscheduler\0"
	"sched_rr_get_interval\0sched_setaffinity\0sched_setattr\0sched_setparam\0sched_setscheduler\0sched_yield\0seccomp\0select\0semctl\0semget\0"
	"semop\0semtimedop\0send\0sendfile\0sendfile64\0sendmmsg\0sendmsg\0sendto\0set_mempolicy\0set_robust_list\0"
	"set_tid_address\0setdomainname\0setfsgid\0setfsgid32\0setfsuid\0setfsuid32\0setgid\0setgid32\0setgroups\0setgroups32\0"
	"sethostname\0setitimer\0setns\0setpgid\0setpriority\0setregid\0setregid32\0setresgid\0setresgid32\0setresuid\0"
	"setresuid32\0setreuid\0setreuid32\0setrlimit\0setsid\0setsockopt\0settimeofday\0setuid\0setuid32\0setxattr\0"
	"shmat\0shmctl\0shmdt\0shmget\0shutdown\0sigaction\0sigaltstack\0signalfd\0signalfd4\0sigpending\0"
	"sigprocmask\0sigreturn\0sigsuspend\0socket\0socketcall\0socketpair\0splice\0stat\0stat64\0statfs\0"
	"statfs64\0statx\0stime\0swapoff\0swapon\0symlink\0symlinkat\0sync\0sync_file_range\0syncfs\0"
	"syscall\0sysctl\0sysfs\0sysinfo\0syslog\0tee\0tgkill\0time\0timer_create\0timer_delete\0"
	"timer_getoverrun\0timer_gettime\0timer_settime\0timerfd_create\0timerfd_gettime\0timerfd_settime\0times\0tkill\0truncate\0truncate64\0"
	"ugetrlimit\0umask\0umount\0umount2\0uname\0unlink\0unlinkat\0unshare\0uselib\0userfaultfd\0"
	"ustat\0utime\0utimensat\0utimes\0vfork\0vhangup\0vmsplice\0vserver\0wait4\0waitid\0"
	"write\0writev";
static const unsigned arm_syscall_s2i_s[] = {
	0,7,15,22,27,35,44,50,58,63,
	67,71,78,85,91,97,103,111,118,132,
	145,159,175,189,195,201,209,225,231,245,
	249,254,259,272,286,296,307,315,324,331,
	340,345,356,366,379,389,403,417,424,431,
	440,447,456,465,471,479,489,499,512,523,
	529,534,547,557,563,571,581,589,599,605,
	615,627,633,643,657,673,680,687,696,707,
	715,725,733,743,750,759,769,781,791,803,
	811,819,826,834,846,856,866,878,888,900,
	910,920,927,939,950,957,970,977,986,995,
	1007,1025,1038,1052,1069,1079,1090,1103,1112,1122,
	1128,1139,1150,1154,1159,1170,1177,1182,1189,1198,
	1208,1213,1220,1227,1237,1248,1255,1270,1283,1289,
	1299,1305,1313,1321,1327,1338,1351,1359,1365,1373,
	1379,1387,1393,1400,1409,1414,1420,1426,1437,1446,
	1460,1470,1478,1494,1507,1517,1524,1531,1538,1545,
	1552,1558,1566,1577,1584,1602,1612,1622,1633,1638,
	1643,1661,1668,1674,1691,1706,1722,1738,1750,1755,
	1761,1772,1783,1793,1807,1812,1818,1826,1833,1841,
	1851,1868,1886,1893,1902,1910,1919,1928,1933,1943,
	1951,1960,1971,1977,1984,1989,1998,2007,2015,2032,
	2044,2051,2060,2070,2082,2098,2104,2117,2131,2146,
	2162,2175,2189,2205,2223,2246,2269,2287,2301,2316,
	2335,2357,2375,2389,2404,2423,2435,2443,2450,2457,
	2464,2470,2481,2486,2495,2506,2515,2523,2530,2544,
	2560,2576,2590,2599,2610,2619,2630,2637,2646,2656,
	2668,2680,2690,2696,2704,2716,2725,2736,2746,2758,
	2768,2780,2789,2800,2810,2817,2828,2841,2848,2857,
	2866,2872,2879,2885,2892,2901,2911,2923,2932,2942,
	2953,2965,2975,2986,2993,3004,3015,3022,3027,3034,
	3041,3050,3056,3062,3070,3077,3085,3095,3100,3116,
	3123,3131,3138,3144,3152,3159,3163,3170,3175,3188,
	3201,3218,3232,3246,3261,3277,3293,3299,3305,3314,
	3325,3336,3342,3349,3357,3363,3370,3379,3387,3394,
	3406,3412,3418,3428,3435,3441,3449,3458,3466,3472,
	3479,3485,
};
static const int arm_syscall_s2i_i[] = {
	285,366,33,51,309,124,27,134,282,386,
	45,184,185,12,15,182,212,61,372,264,
	263,265,262,120,6,283,391,8,129,41,
	63,358,250,357,251,252,351,356,11,387,
	1,248,334,270,352,367,368,133,94,333,
	95,207,325,55,221,148,231,379,234,143,
	2,237,228,108,197,327,100,267,118,93,
	194,240,326,320,339,345,183,141,217,50,
	202,49,201,47,200,80,205,105,287,132,
	65,20,64,96,384,171,211,165,209,76,
	77,147,286,295,224,78,24,199,229,128,
	317,316,360,318,247,244,245,243,246,54,
	315,314,117,378,347,311,37,16,198,230,
	9,330,284,232,233,140,249,236,19,227,
	107,196,220,319,389,385,219,39,323,14,
	324,150,390,152,90,192,21,344,125,279,
	278,274,277,276,275,163,304,303,302,301,
	144,151,153,91,370,162,142,169,34,5,
	371,322,29,271,272,273,364,136,42,359,
	218,395,396,394,168,172,180,361,392,369,
	376,377,26,181,362,393,131,3,225,89,
	85,332,145,88,291,292,365,297,253,235,
	38,329,382,310,0,40,174,176,175,178,
	173,179,177,363,159,160,242,381,155,157,
	161,241,380,154,156,158,383,82,300,299,
	298,312,289,187,239,374,296,290,321,338,
	256,121,139,216,138,215,46,214,81,206,
	74,104,375,57,97,71,204,170,210,164,
	208,70,203,75,66,294,79,23,213,226,
	305,308,306,307,293,67,186,349,355,73,
	126,119,72,281,102,288,340,106,195,99,
	266,397,25,115,87,83,331,36,341,373,
	113,149,135,116,103,342,268,13,257,261,
	260,259,258,350,354,353,43,238,92,193,
	191,60,22,52,122,10,328,337,86,388,
	62,30,348,269,190,111,343,313,114,280,
	4,146,
};
static int arm_syscall_s2i(const char *s, int *value) {
	size_t len, i;
	 if (s == NULL || value == NULL)
		return 0;
	len = strlen(s);
	{ char copy[len + 1];
	for (i = 0; i < len; i++) {
		char c = s[i];
		copy[i] = GT_ISUPPER(c) ? c - 'A' + 'a' : c;
	}
	copy[i] = 0;
	return s2i__(arm_syscall_strings, arm_syscall_s2i_s, arm_syscall_s2i_i, 362, copy, value);
	}
}
static const unsigned arm_syscall_i2s_direct[] = {
	2082,340,529,1928,3479,1638,195,-1u,225,1208,
	3363,324,85,3170,1373,91,1182,-1u,-1u,1283,
	819,1420,3342,2841,970,3056,1886,44,-1u,1668,
	3412,-1u,-1u,15,1633,-1u,3095,1177,2044,1359,
	2098,245,1750,3293,-1u,67,2630,743,-1u,725,
	707,22,3349,-1u,1122,465,-1u,2696,-1u,-1u,
	3336,111,3406,249,826,811,2810,2901,-1u,-1u,
	2780,2716,2975,2942,2668,2800,900,910,957,2828,
	759,2646,2443,3077,-1u,1951,3387,3070,1977,1943,
	1409,1577,3305,605,424,440,834,2704,-1u,3034,
	581,-1u,2993,3152,2680,781,3022,1299,557,-1u,
	-1u,3441,-1u,3123,3466,3062,3144,1150,599,2965,
	189,2576,3357,-1u,35,1437,2953,-1u,995,231,
	-1u,1919,803,417,50,3138,1738,-1u,2610,2590,
	1248,687,1612,523,1552,1971,3485,920,479,3131,
	1387,1558,1400,1566,2389,2301,2404,2316,2423,2223,
	2246,2335,1602,1517,2758,878,-1u,-1u,1807,1622,
	2736,856,1812,2162,2104,2131,2117,2189,2146,2175,
	1818,1893,97,680,71,78,2911,2486,-1u,-1u,
	3435,3325,1414,3314,615,3027,1305,563,1189,977,
	750,733,715,2789,2725,769,2656,447,2768,888,
	2746,866,103,2848,2637,2619,2599,696,1761,1351,
	1313,471,-1u,-1u,950,1933,2857,1289,547,986,
	1198,489,1227,1237,512,2032,1270,534,3299,2495,
	627,2357,2269,1103,1079,1090,1112,1069,345,1255,
	259,286,296,2015,-1u,-1u,2560,3175,3232,3218,
	3201,3188,175,145,132,159,3041,589,3163,3428,
	366,1674,1691,1706,1470,1507,1494,1478,1460,1446,
	3472,2986,58,201,1220,0,927,791,3004,2481,
	2523,1984,1989,2892,2817,939,2515,2007,2464,2457,
	2450,1545,1538,1531,1524,2866,2879,2885,2872,27,
	2070,1170,2470,3458,1139,1128,1025,1007,1052,1321,
	643,2530,1661,1365,1379,456,633,571,3370,2051,
	1213,3085,1960,431,356,-1u,-1u,3379,2544,657,
	3015,3100,3159,3449,1426,673,-1u,1159,3418,2923,
	3246,307,379,3277,3261,2932,315,272,254,1755,
	1038,1826,1902,2205,1722,1998,7,389,403,1841,
	1584,1643,118,3116,2506,2690,1851,1868,1154,499,
	2375,2287,2060,2435,846,1338,63,331,3394,1327,
	1393,209,1833,1910,1793,1772,1783,3050,
};
static const char *arm_syscall_i2s(int v) {
	return i2s_direct__(arm_syscall_strings, arm_syscall_i2s_direct, 0, 397, v);
}
