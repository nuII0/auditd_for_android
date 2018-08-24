/* This is a generated file, see Makefile.am for its inputs. */
static const char s390x_syscall_strings[] = "_sysctl\0accept4\0access\0acct\0add_key\0adjtimex\0afs_syscall\0alarm\0bdflush\0bind\0"
	"bpf\0brk\0capget\0capset\0chdir\0chmod\0chown\0chroot\0clock_adjtime\0clock_getres\0"
	"clock_gettime\0clock_nanosleep\0clock_settime\0clone\0close\0connect\0copy_file_range\0creat\0create_module\0delete_module\0"
	"dup\0dup2\0dup3\0epoll_create\0epoll_create1\0epoll_ctl\0epoll_pwait\0epoll_wait\0eventfd\0eventfd2\0"
	"execve\0execveat\0exit\0exit_group\0faccessat\0fadvise64\0fallocate\0fanotify_init\0fanotify_mark\0fchdir\0"
	"fchmod\0fchmodat\0fchown\0fchownat\0fcntl\0fdatasync\0fgetxattr\0finit_module\0flistxattr\0flock\0"
	"fork\0fremovexattr\0fsetxattr\0fstat\0fstatfs\0fstatfs64\0fsync\0ftruncate\0futex\0futimesat\0"
	"get_kernel_syms\0get_robust_list\0getcpu\0getcwd\0getdents\0getegid\0geteuid\0getgid\0getgroups\0getitimer\0"
	"getpeername\0getpgid\0getpgrp\0getpid\0getpmsg\0getppid\0getpriority\0getrandom\0getresgid\0getresuid\0"
	"getrlimit\0getrusage\0getsid\0getsockname\0getsockopt\0gettid\0gettimeofday\0getuid\0getxattr\0idle\0"
	"init_module\0inotify_add_watch\0inotify_init\0inotify_init1\0inotify_rm_watch\0io_cancel\0io_destroy\0io_getevents\0io_setup\0io_submit\0"
	"ioctl\0ioprio_get\0ioprio_set\0ipc\0kcmp\0kexec_load\0keyctl\0kill\0lchown\0lgetxattr\0"
	"link\0linkat\0listen\0listxattr\0llistxattr\0lremovexattr\0lseek\0lsetxattr\0lstat\0madvise\0"
	"membarrier\0memfd_create\0mincore\0mkdir\0mkdirat\0mknod\0mknodat\0mlock\0mlock2\0mlockall\0"
	"mmap\0mount\0mprotect\0mq_getsetattr\0mq_notify\0mq_open\0mq_timedreceive\0mq_timedsend\0mq_unlink\0mremap\0"
	"msync\0munlock\0munlockall\0munmap\0name_to_handle_at\0nanosleep\0newfstatat\0nfsservctl\0nice\0open\0"
	"open_by_handle_at\0openat\0pause\0perf_event_open\0personality\0pipe\0pipe2\0pivot_root\0poll\0ppoll\0"
	"prctl\0pread\0preadv\0preadv2\0prlimit64\0process_vm_readv\0process_vm_writev\0pselect6\0ptrace\0putpmsg\0"
	"pwrite\0pwritev\0pwritev2\0query_module\0quotactl\0read\0readahead\0readdir\0readlink\0readlinkat\0"
	"readv\0reboot\0recvfrom\0recvmmsg\0recvmsg\0remap_file_pages\0removexattr\0rename\0renameat\0renameat2\0"
	"request_key\0rmdir\0rt_sigaction\0rt_sigpending\0rt_sigprocmask\0rt_sigqueueinfo\0rt_sigreturn\0rt_sigsuspend\0rt_sigtimedwait\0rt_tgsigqueueinfo\0"
	"s390_pci_mmio_read\0s390_pci_mmio_write\0s390_runtime_instr\0sched_get_priority_max\0sched_get_priority_min\0sched_getaffinity\0sched_getattr\0sched_getparam\0sched_getscheduler\0sched_rr_get_interval\0"
	"sched_setaffinity\0sched_setattr\0sched_setparam\0sched_setscheduler\0sched_yield\0seccomp\0select\0sendfile\0sendmmsg\0sendmsg\0"
	"sendto\0set_robust_list\0set_tid_address\0setdomainname\0setfsgid\0setfsuid\0setgid\0setgroups\0sethostname\0setitimer\0"
	"setns\0setpgid\0setpriority\0setregid\0setresgid\0setresuid\0setreuid\0setrlimit\0setsid\0setsockopt\0"
	"settimeofday\0setuid\0setxattr\0shutdown\0sigaction\0sigaltstack\0signal\0signalfd\0signalfd4\0sigpending\0"
	"sigprocmask\0sigreturn\0sigsuspend\0socket\0socketcall\0socketpair\0splice\0stat\0statfs\0statfs64\0"
	"statx\0swapoff\0swapon\0symlink\0symlinkat\0sync\0sync_file_range\0syncfs\0sysfs\0sysinfo\0"
	"syslog\0tee\0tgkill\0timer_create\0timer_delete\0timer_getoverrun\0timer_gettime\0timer_settime\0timerfd\0timerfd_create\0"
	"timerfd_gettime\0timerfd_settime\0times\0tkill\0truncate\0umask\0umount\0umount2\0uname\0unlink\0"
	"unlinkat\0unshare\0uselib\0userfaultfd\0ustat\0utime\0utimensat\0utimes\0vfork\0vhangup\0"
	"vmsplice\0wait4\0waitid\0write\0writev";
static const unsigned s390x_syscall_s2i_s[] = {
	0,8,16,23,28,36,45,57,63,71,
	76,80,84,91,98,104,110,116,123,137,
	150,164,180,194,200,206,214,230,236,250,
	264,268,273,278,291,305,315,327,338,346,
	355,362,371,376,387,397,407,417,431,445,
	452,459,468,475,484,490,500,510,523,534,
	540,545,558,568,574,582,592,598,608,614,
	624,640,656,663,670,679,687,695,702,712,
	722,734,742,750,757,765,773,785,795,805,
	815,825,835,842,854,865,872,885,892,901,
	906,918,936,949,963,980,990,1001,1014,1023,
	1033,1039,1050,1061,1065,1070,1081,1088,1093,1100,
	1110,1115,1122,1129,1139,1150,1163,1169,1179,1185,
	1193,1204,1217,1225,1231,1239,1245,1253,1259,1266,
	1275,1280,1286,1295,1309,1319,1327,1343,1356,1366,
	1373,1379,1387,1398,1405,1423,1433,1444,1455,1460,
	1465,1483,1490,1496,1512,1524,1529,1535,1546,1551,
	1557,1563,1569,1576,1584,1594,1611,1629,1638,1645,
	1653,1660,1668,1677,1690,1699,1704,1714,1722,1731,
	1742,1748,1755,1764,1773,1781,1798,1810,1817,1826,
	1836,1848,1854,1867,1881,1896,1912,1925,1939,1955,
	1973,1992,2012,2031,2054,2077,2095,2109,2124,2143,
	2165,2183,2197,2212,2231,2243,2251,2258,2267,2276,
	2284,2291,2307,2323,2337,2346,2355,2362,2372,2384,
	2394,2400,2408,2420,2429,2439,2449,2458,2468,2475,
	2486,2499,2506,2515,2524,2534,2546,2553,2562,2572,
	2583,2595,2605,2616,2623,2634,2645,2652,2657,2664,
	2673,2679,2687,2694,2702,2712,2717,2733,2740,2746,
	2754,2761,2765,2772,2785,2798,2815,2829,2843,2851,
	2866,2882,2898,2904,2910,2919,2925,2932,2940,2946,
	2953,2962,2970,2977,2989,2995,3001,3011,3018,3024,
	3032,3041,3047,3054,3060,
};
static const int s390x_syscall_s2i_i[] = {
	149,364,33,51,278,124,137,27,134,361,
	351,45,184,185,12,15,212,61,337,261,
	260,262,259,120,6,362,375,8,127,129,
	41,63,326,249,327,250,312,251,318,323,
	11,354,1,248,300,253,314,332,333,133,
	94,299,207,291,55,148,229,344,232,143,
	2,235,226,108,100,266,118,93,238,292,
	130,305,311,183,141,202,201,200,205,105,
	368,132,65,20,188,64,96,349,211,209,
	191,77,147,367,365,236,78,199,227,112,
	128,285,284,324,286,247,244,245,243,246,
	54,283,282,117,343,277,280,37,198,228,
	9,296,363,230,231,234,19,225,107,219,
	356,350,218,39,289,14,290,150,374,152,
	90,21,125,276,275,271,274,273,272,163,
	144,151,153,91,335,162,293,169,34,5,
	336,288,29,331,136,42,325,217,168,302,
	172,180,328,376,334,340,341,301,26,189,
	181,329,377,167,131,3,222,89,85,298,
	145,88,371,357,372,267,233,38,295,347,
	279,40,174,176,175,178,173,179,177,330,
	353,352,342,159,160,240,346,155,157,161,
	239,345,154,156,158,348,142,187,358,370,
	369,304,252,121,216,215,214,206,74,104,
	339,57,97,204,210,208,203,75,66,366,
	79,213,224,373,67,186,48,316,322,73,
	126,119,72,359,102,360,306,106,99,265,
	379,115,87,83,297,36,307,338,135,116,
	103,308,241,254,258,257,256,255,317,319,
	321,320,43,237,92,60,22,52,122,10,
	294,303,86,355,62,30,315,313,190,111,
	309,114,281,4,146,
};
static int s390x_syscall_s2i(const char *s, int *value) {
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
	return s2i__(s390x_syscall_strings, s390x_syscall_s2i_s, s390x_syscall_s2i_i, 315, copy, value);
	}
}
static const unsigned s390x_syscall_i2s_direct[] = {
	371,540,1699,3054,1460,200,-1u,230,1110,2946,
	355,98,-1u,1239,104,-1u,-1u,-1u,1163,750,
	1280,2925,-1u,-1u,-1u,1638,57,-1u,1490,2995,
	-1u,-1u,16,1455,-1u,2712,1088,1810,1225,1848,
	264,1524,2898,-1u,80,-1u,-1u,2546,-1u,-1u,
	23,2932,-1u,1033,484,-1u,2400,-1u,-1u,2919,
	116,2989,268,765,742,2468,2524,-1u,-1u,-1u,
	-1u,2605,2572,2372,2458,-1u,825,872,2486,-1u,
	-1u,-1u,2694,-1u,1722,2970,2687,1748,1714,1275,
	1398,2910,598,452,-1u,773,2408,-1u,2657,574,
	-1u,2623,2754,2384,712,2652,1179,568,-1u,-1u,
	3024,901,-1u,3041,2679,2746,1061,592,2595,194,
	2323,2940,-1u,36,1286,2583,236,906,250,624,
	1690,734,445,63,2740,1512,45,-1u,-1u,-1u,
	670,2251,534,1373,1742,3060,835,490,0,1253,
	1379,1266,1387,2197,2109,2212,2124,2231,2031,2054,
	2143,1423,1366,-1u,-1u,-1u,1677,1546,1444,-1u,
	-1u,1557,1912,1854,1881,1867,1939,1896,1925,1563,
	1653,-1u,663,84,91,2534,2258,757,1645,3018,
	815,-1u,-1u,-1u,-1u,-1u,-1u,1093,885,695,
	687,679,2449,2420,702,2362,468,2439,805,2429,
	795,110,2499,2355,2346,2337,1535,1217,1185,-1u,
	-1u,1704,-1u,2506,1169,558,892,1100,500,1129,
	1139,523,1798,1150,545,865,2904,608,2165,2077,
	2765,-1u,1014,990,1001,1023,980,376,278,305,
	327,2307,397,2772,2829,2815,2798,2785,180,150,
	137,164,-1u,-1u,2664,582,1781,-1u,-1u,-1u,
	1319,1356,1343,1327,1309,1295,1070,28,1836,1081,
	3047,1050,1039,936,918,963,-1u,1483,1231,1245,
	475,614,1433,2953,1817,1115,2702,1731,459,387,
	1629,1551,2962,2291,640,2645,2717,2761,3032,-1u,
	656,315,3011,407,3001,2553,2843,338,2851,2882,
	2866,2562,346,949,1529,273,291,1569,1660,1955,
	1496,417,431,1584,1405,1465,123,2733,2394,1594,
	1611,2012,1065,510,2183,2095,1826,2243,785,1204,
	76,1992,1973,362,2977,1193,1764,2267,2616,2634,
	71,206,1122,8,854,2475,842,722,2284,2276,
	1755,1773,2515,1259,214,1576,1668,-1u,2673,
};
static const char *s390x_syscall_i2s(int v) {
	return i2s_direct__(s390x_syscall_strings, s390x_syscall_i2s_direct, 1, 379, v);
}
