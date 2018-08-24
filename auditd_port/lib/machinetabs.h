/* This is a generated file, see Makefile.am for its inputs. */
static const char machine_strings[] = "arm\0armeb\0armv5tejl\0armv5tel\0armv6l\0armv7l\0i386\0i486\0i586\0i686\0"
	"ia64\0ppc\0ppc64\0ppc64le\0s390\0s390x\0x86_64";
static const unsigned machine_s2i_s[] = {
	0,4,10,20,29,36,43,48,53,58,
	63,68,72,78,86,91,97,
};
static const int machine_s2i_i[] = {
	8,8,8,8,8,8,0,0,0,0,
	2,4,3,10,6,5,1,
};
static int machine_s2i(const char *s, int *value) {
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
	return s2i__(machine_strings, machine_s2i_s, machine_s2i_i, 17, copy, value);
	}
}
static const unsigned machine_i2s_direct[] = {
	43,97,63,72,68,91,86,-1u,4,-1u,
	78,
};
static const char *machine_i2s(int v) {
	return i2s_direct__(machine_strings, machine_i2s_direct, 0, 10, v);
}
