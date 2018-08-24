/* This is a generated file, see Makefile.am for its inputs. */
static const char seccomp_strings[] = "allow\0errno\0kill\0log\0trace\0trap";
static const int seccomp_i2s_i[] = {
	0,196608,327680,2146435072,2147221504,2147418112,
};
static const unsigned seccomp_i2s_s[] = {
	12,27,6,21,17,0,
};
static const char *seccomp_i2s(int v) {
	return i2s_bsearch__(seccomp_strings, seccomp_i2s_i, seccomp_i2s_s, 6, v);
}
