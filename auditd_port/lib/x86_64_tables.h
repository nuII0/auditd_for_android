/* This is a generated file, see Makefile.am for its inputs. */
static const char x86_64_syscall_strings[] = "_sysctl\0accept\0accept4\0access\0acct\0add_key\0adjtimex\0afs_syscall\0alarm\0arch_prctl\0"
	"bind\0bpf\0brk\0capget\0capset\0chdir\0chmod\0chown\0chroot\0clock_adjtime\0"
	"clock_getres\0clock_gettime\0clock_nanosleep\0clock_settime\0clone\0close\0connect\0copy_file_range\0creat\0create_module\0"
	"delete_module\0dup\0dup2\0dup3\0epoll_create\0epoll_create1\0epoll_ctl\0epoll_ctl_old\0epoll_pwait\0epoll_wait\0"
	"epoll_wait_old\0eventfd\0eventfd2\0execve\0execveat\0exit\0exit_group\0faccessat\0fadvise64\0fallocate\0"
	"fanotify_init\0fanotify_mark\0fchdir\0fchmod\0fchmodat\0fchown\0fchownat\0fcntl\0fdatasync\0fgetxattr\0"
	"finit_module\0flistxattr\0flock\0fork\0fremovexattr\0fsetxattr\0fstat\0fstatfs\0fsync\0ftruncate\0"
	"futex\0futimesat\0get_kernel_syms\0get_mempolicy\0get_robust_list\0get_thread_area\0getcpu\0getcwd\0getdents\0getdents64\0"
	"getegid\0geteuid\0getgid\0getgroups\0getitimer\0getpeername\0getpgid\0getpgrp\0getpid\0getpmsg\0"
	"getppid\0getpriority\0getrandom\0getresgid\0getresuid\0getrlimit\0getrusage\0getsid\0getsockname\0getsockopt\0"
	"gettid\0gettimeofday\0getuid\0getxattr\0init_module\0inotify_add_watch\0inotify_init\0inotify_init1\0inotify_rm_watch\0io_cancel\0"
	"io_destroy\0io_getevents\0io_setup\0io_submit\0ioctl\0ioperm\0iopl\0ioprio_get\0ioprio_set\0kcmp\0"
	"kexec_file_load\0kexec_load\0keyctl\0kill\0lchown\0lgetxattr\0link\0linkat\0listen\0listxattr\0"
	"llistxattr\0lookup_dcookie\0lremovexattr\0lseek\0lsetxattr\0lstat\0madvise\0mbind\0membarrier\0memfd_create\0"
	"migrate_pages\0mincore\0mkdir\0mkdirat\0mknod\0mknodat\0mlock\0mlock2\0mlockall\0mmap\0"
	"modify_ldt\0mount\0move_pages\0mprotect\0mq_getsetattr\0mq_notify\0mq_open\0mq_timedreceive\0mq_timedsend\0mq_unlink\0"
	"mremap\0msgctl\0msgget\0msgrcv\0msgsnd\0msync\0munlock\0munlockall\0munmap\0name_to_handle_at\0"
	"nanosleep\0newfstatat\0nfsservctl\0open\0open_by_handle_at\0openat\0pause\0perf_event_open\0personality\0pipe\0"
	"pipe2\0pivot_root\0pkey_alloc\0pkey_free\0pkey_mprotect\0poll\0ppoll\0prctl\0pread\0preadv\0"
	"preadv2\0prlimit64\0process_vm_readv\0process_vm_writev\0pselect6\0ptrace\0putpmsg\0pwrite\0pwritev\0pwritev2\0"
	"query_module\0quotactl\0read\0readahead\0readlink\0readlinkat\0readv\0reboot\0recvfrom\0recvmmsg\0"
	"recvmsg\0remap_file_pages\0removexattr\0rename\0renameat\0renameat2\0request_key\0restart_syscall\0rmdir\0rt_sigaction\0"
	"rt_sigpending\0rt_sigprocmask\0rt_sigqueueinfo\0rt_sigreturn\0rt_sigsuspend\0rt_sigtimedwait\0rt_tgsigqueueinfo\0sched_get_priority_max\0sched_get_priority_min\0sched_getaffinity\0"
	"sched_getattr\0sched_getparam\0sched_getscheduler\0sched_rr_get_interval\0sched_setaffinity\0sched_setattr\0sched_setparam\0sched_setscheduler\0sched_yield\0seccomp\0"
	"security\0select\0semctl\0semget\0semop\0semtimedop\0sendfile\0sendmmsg\0sendmsg\0sendto\0"
	"set_mempolicy\0set_robust_list\0set_thread_area\0set_tid_address\0setdomainname\0setfsgid\0setfsuid\0setgid\0setgroups\0sethostname\0"
	"setitimer\0setns\0setpgid\0setpriority\0setregid\0setresgid\0setresuid\0setreuid\0setrlimit\0setsid\0"
	"setsockopt\0settimeofday\0setuid\0setxattr\0shmat\0shmctl\0shmdt\0shmget\0shutdown\0sigaltstack\0"
	"signalfd\0signalfd4\0socket\0socketpair\0splice\0stat\0statfs\0statx\0swapoff\0swapon\0"
	"symlink\0symlinkat\0sync\0sync_file_range\0syncfs\0sysfs\0sysinfo\0syslog\0tee\0tgkill\0"
	"time\0timer_create\0timer_delete\0timer_getoverrun\0timer_gettime\0timer_settime\0timerfd\0timerfd_gettime\0timerfd_settime\0times\0"
	"tkill\0truncate\0tuxcall\0umask\0umount2\0uname\0unlink\0unlinkat\0unshare\0uselib\0"
	"userfaultfd\0ustat\0utime\0utimensat\0utimes\0vfork\0vhangup\0vmsplice\0vserver\0wait4\0"
	"waitid\0write\0writev";
static const unsigned x86_64_syscall_s2i_s[] = {
	0,8,15,23,30,35,43,52,64,70,
	81,86,90,94,101,108,114,120,126,133,
	147,160,174,190,204,210,216,224,240,246,
	260,274,278,283,288,301,315,325,339,351,
	362,377,385,394,401,410,415,426,436,446,
	456,470,484,491,498,507,514,523,529,539,
	549,562,573,579,584,597,607,613,621,627,
	637,643,653,669,683,699,715,722,729,738,
	749,757,765,772,782,792,804,812,820,827,
	835,843,855,865,875,885,895,905,912,924,
	935,942,955,962,971,983,1001,1014,1028,1045,
	1055,1066,1079,1088,1098,1104,1111,1116,1127,1138,
	1143,1159,1170,1177,1182,1189,1199,1204,1211,1218,
	1228,1239,1254,1267,1273,1283,1289,1297,1303,1314,
	1327,1341,1349,1355,1363,1369,1377,1383,1390,1399,
	1404,1415,1421,1432,1441,1455,1465,1473,1489,1502,
	1512,1519,1526,1533,1540,1547,1553,1561,1572,1579,
	1597,1607,1618,1629,1634,1652,1659,1665,1681,1693,
	1698,1704,1715,1726,1736,1750,1755,1761,1767,1773,
	1780,1788,1798,1815,1833,1842,1849,1857,1864,1872,
	1881,1894,1903,1908,1918,1927,1938,1944,1951,1960,
	1969,1977,1994,2006,2013,2022,2032,2044,2060,2066,
	2079,2093,2108,2124,2137,2151,2167,2185,2208,2231,
	2249,2263,2278,2297,2319,2337,2351,2366,2385,2397,
	2405,2414,2421,2428,2435,2441,2452,2461,2470,2478,
	2485,2499,2515,2531,2547,2561,2570,2579,2586,2596,
	2608,2618,2624,2632,2644,2653,2663,2673,2682,2692,
	2699,2710,2723,2730,2739,2745,2752,2758,2765,2774,
	2786,2795,2805,2812,2823,2830,2835,2842,2848,2856,
	2863,2871,2881,2886,2902,2909,2915,2923,2930,2934,
	2941,2946,2959,2972,2989,3003,3017,3025,3041,3057,
	3063,3069,3078,3086,3092,3100,3106,3113,3122,3130,
	3137,3149,3155,3161,3171,3178,3184,3192,3201,3209,
	3215,3222,3228,
};
static const int x86_64_syscall_s2i_i[] = {
	156,43,288,21,163,248,159,183,37,158,
	49,321,12,125,126,80,90,92,161,305,
	229,228,230,227,56,3,42,326,85,174,
	176,32,33,292,213,291,233,214,281,232,
	215,284,290,59,322,60,231,269,221,285,
	300,301,81,91,268,93,260,72,75,193,
	313,196,73,57,199,190,5,138,74,77,
	202,261,177,239,274,211,309,79,78,217,
	108,107,104,115,36,52,121,111,39,181,
	110,140,318,120,118,97,98,124,51,55,
	186,96,102,191,175,254,253,294,255,210,
	207,208,206,209,16,173,172,252,251,312,
	320,246,250,62,94,192,86,265,50,194,
	195,212,198,8,189,6,28,237,324,319,
	256,27,83,258,133,259,149,325,151,9,
	154,165,279,10,245,244,240,243,242,241,
	25,71,68,70,69,26,150,152,11,303,
	35,262,180,2,304,257,34,298,135,22,
	293,155,330,331,329,7,271,157,17,295,
	327,302,310,311,270,101,182,18,296,328,
	178,179,0,187,89,267,19,169,45,299,
	47,216,197,82,264,316,249,219,84,13,
	127,14,129,15,130,128,297,146,147,204,
	315,143,145,148,203,314,142,144,24,317,
	185,23,66,64,65,220,40,307,46,44,
	238,273,205,218,171,123,122,106,116,170,
	38,308,109,141,114,119,117,113,160,112,
	54,164,105,188,30,31,67,29,48,131,
	282,289,41,53,275,4,137,332,168,167,
	88,266,162,277,306,139,99,103,276,234,
	201,222,226,225,224,223,283,287,286,100,
	200,76,184,95,166,63,87,263,272,134,
	323,136,132,280,235,58,153,278,236,61,
	247,1,20,
};
static int x86_64_syscall_s2i(const char *s, int *value) {
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
	return s2i__(x86_64_syscall_strings, x86_64_syscall_s2i_s, x86_64_syscall_s2i_i, 333, copy, value);
	}
}
static const unsigned x86_64_syscall_i2s_direct[] = {
	1903,3222,1629,210,2830,607,1283,1750,1267,1399,
	1432,1572,90,2066,2093,2124,1098,1767,1857,1938,
	3228,23,1693,2414,2385,1512,1547,1341,1289,2758,
	2739,2745,274,278,1659,1597,782,64,2608,820,
	2452,2805,216,8,2478,1951,2470,1969,2765,81,
	1211,912,792,2812,2699,924,204,579,3178,394,
	410,3209,1177,3100,2428,2435,2421,2752,1526,1540,
	1533,1519,523,573,621,529,3069,627,729,722,
	108,484,2006,1349,2060,240,1199,3106,2863,1918,
	114,491,120,507,1182,3086,942,885,895,2915,
	3057,1842,955,2923,765,2723,2579,757,749,2624,
	835,812,2692,2673,2644,772,2586,2663,875,2653,
	865,804,2570,2561,905,94,101,2079,2151,2108,
	2137,2774,3155,1363,3130,1681,3149,2835,613,2909,
	843,2632,2351,2263,2366,2278,2185,2208,2297,1377,
	1553,1390,1561,3184,1404,1704,0,1761,70,43,
	2682,126,2881,30,2710,1415,3092,2856,2848,1944,
	2596,2547,1111,1104,246,971,260,653,1881,1894,
	1618,827,1849,52,3078,2405,935,1908,2730,1273,
	597,962,1189,539,1218,1228,562,1994,1254,584,
	3063,2941,637,2319,2231,2515,1079,1055,1066,1088,
	1045,699,1239,288,325,362,1977,738,2531,2044,
	2441,436,2946,3003,2989,2972,2959,190,160,147,
	174,415,351,315,2934,3171,3201,1297,2485,669,
	1465,1502,1489,1473,1455,1441,1159,3215,35,2032,
	1170,1127,1116,1001,983,1028,1327,1652,1355,1369,
	514,643,1607,3113,2013,1204,2871,1927,498,426,
	1833,1755,3122,2499,683,2823,2930,2886,3192,1421,
	3161,339,2786,3017,377,446,3041,3025,15,2795,
	385,301,283,1698,1014,1773,1864,2167,1665,1960,
	456,470,1788,1579,1634,133,2902,2461,2618,715,
	1798,1815,1138,549,2337,2249,2022,2397,855,1314,
	1143,86,401,3137,1303,1383,224,1780,1872,1736,
	1715,1726,2842,
};
static const char *x86_64_syscall_i2s(int v) {
	return i2s_direct__(x86_64_syscall_strings, x86_64_syscall_i2s_direct, 0, 332, v);
}
